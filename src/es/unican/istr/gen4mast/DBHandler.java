package es.unican.istr.gen4mast;

import es.unican.istr.rtgen.system.elements.LinearSystem;
import es.unican.istr.rtgen.system.elements.config.DeadlineOptions;
import es.unican.istr.rtgen.system.elements.config.LinearSystemConfigurableOptions;
import es.unican.istr.rtgen.system.elements.config.SystemConfig;
import es.unican.istr.rtgen.system.mast.MastSystem;
import es.unican.istr.rtgen.tool.mast.config.MastConfig;
import es.unican.istr.rtgen.tool.mast.config.MastToolConfigurableOptions;
import es.unican.istr.rtgen.utils.Utils;

import java.sql.*;
import java.util.*;

/**
 * Created by juanm on 22/08/2015.
 * NOSQL Database handler
 */
public class DBHandler {

    private Connection con = null;
    private HashMap<String, String> columns = null;

    public DBHandler(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(String.format("jdbc:sqlite:%s", dbName));
            establishColumns();

            DatabaseMetaData meta = con.getMetaData();
            ResultSet tables = meta.getTables(null, null, "RT_RESULTS", null);
            if (!tables.next()) { // Table doesn't exist, create table
                createTable();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        con.close();
        super.finalize();
    }

    private void establishColumns() {
        columns = new HashMap<String,String>();
        for (LinearSystemConfigurableOptions o: LinearSystemConfigurableOptions.values()){
            switch (o) {
                case SEED: columns.put(o.name(),"INTEGER");break;
                case N_PROCESSORS: columns.put(o.name(), "INTEGER"); break;
                case N_FLOWS: columns.put(o.name(), "INTEGER"); break;
                case N_TASKS: columns.put(o.name(), "INTEGER"); break;
                case RANDOM_LENGTH: columns.put(o.name(), "BIT"); break;
                case SINGLE_FLOWS: columns.put(o.name(), "REAL"); break;
                case SCHED_POLICY: columns.put(o.name(), "VARCHAR(5)"); break;
                case PERIOD_DISTRIBUTION: columns.put(o.name(), "INTEGER"); break;
                case PERIOD_BASE: columns.put(o.name(), "REAL"); break;
                case PERIOD_RATIO: columns.put(o.name(), "REAL"); break;
                case DEADLINE: columns.put(o.name(), "VARCHAR(6)"); break;
                case TASK_LOCALIZATION: columns.put(o.name(), "INTEGER"); break;
                case UTILIZATION_START: columns.put(o.name(), "INTEGER"); break;
                case UTILIZATION_STEP: columns.put(o.name(), "INTEGER"); break;
                case UTILIZATION_TOP: columns.put(o.name(), "INTEGER"); break;
                case UTILIZATION_BCET_FACTOR: columns.put(o.name(), "REAL"); break;
                case UTILIZATION_WCET_METHOD: columns.put(o.name(), "INTEGER"); break;
                case UTILIZATION_BALANCING: columns.put(o.name(), "INTEGER"); break;
            }
        }

        for (MastToolConfigurableOptions o: MastToolConfigurableOptions.values()){
            switch (o) {
                case NAME: columns.put(o.name(), "VARCHAR(22)"); break;
                case ANALYSIS_TOOL: columns.put(o.name(), "INTEGER"); break;
                case SYNC: columns.put(o.name(), "BIT"); break;
                case ASSIGNMENT_TOOL: columns.put(o.name(), "INTEGER"); break;
                case HOSPA_INIT: columns.put(o.name(), "INTEGER"); break;
                case HOSPA_Ka: columns.put(o.name(), "REAL"); break;
                case HOSPA_Kr: columns.put(o.name(), "REAL"); break;
                case HOSPA_ITERATIONS: columns.put(o.name(), "INTEGER"); break;
                case HOSPA_OVERITERATIONS: columns.put(o.name(), "INTEGER"); break;
                case ANALYSIS_STOP_FACTOR: columns.put(o.name(), "REAL"); break;
                case LC_EDF_GSD: columns.put(o.name(), "BIT"); break;
                case LC_EDF_DS_FACTOR: columns.put(o.name(), "REAL"); break;
                case CALCULATE_SLACK: columns.put(o.name(), "BIT"); break;
                case JITTER_AVOIDANCE: columns.put(o.name(), "BIT"); break;
            }
        }

        // Results columns
        columns.put("MSU", "INTEGER");
        columns.put("SERIES", "VARBINARY(1620)"); //2*101*8+some paddding
    }


    public void createTable() {
        try {
            // Creates statement string with columns and type
            Statement stmt = con.createStatement();
            ArrayList<String> stmtStrList = new ArrayList<>();
            stmtStrList.add("CREATE TABLE RT_RESULTS (");

            Iterator<String> iter = columns.keySet().iterator();
            String k = iter.next();
            while (true){
                stmtStrList.add(String.format("%s %s%s", k, columns.get(k), iter.hasNext()?",":")"));
                if (iter.hasNext()) {
                    k = iter.next();
                } else {
                    break;
                }
            }

            // Execute statement
            stmt.executeUpdate(String.join("", stmtStrList));
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void addResultsRow(SystemConfig c, MastConfig m, Integer msu, double[] wcrtArray, double[] execTimeArray) {
        PreparedStatement p = null;

        ArrayList<String> cols = new ArrayList<>();
        for (LinearSystemConfigurableOptions o: LinearSystemConfigurableOptions.values()){
            cols.add(o.name());
        }
        for (LinearSystemConfigurableOptions o: LinearSystemConfigurableOptions.values()){
            cols.add(o.name());
        }
        cols.add("MSU");
        cols.add("SERIES");
        ArrayList<String> cols2 = new ArrayList<>();
        for (int i=1; i<=cols.size(); i++){
            cols2.add("?");
        }
        String query = String.format("INSERT INTO RT_RESULTS (%s) VALUES(%s)", String.join(",", cols), String.join(",", cols2));

        System.out.println(query);
        try {
            p = con.prepareStatement(query);

            int i = 1;

            // Store system characteristics
            p.setInt(i++, c.getSeed());
            p.setInt(i++, c.getnProcs());
            p.setInt(i++, c.getnFlows());
            p.setInt(i++, c.getnTasks());
            p.setBoolean(i++, c.getRandomLength());
            p.setFloat(i++, c.getSingleFlows());
            p.setString(i++, c.getSchedPolicy());

            p.setInt(i++, c.getPeriod().getDistribution().getValue());
            p.setFloat(i++, c.getPeriod().getBase());
            p.setFloat(i++, c.getPeriod().getRatio());

            if (c.getDeadline().getValue() == DeadlineOptions.K) {
                p.setString(i++, c.getDeadline().getValueK().toString());
            } else {
                p.setString(i++, c.getDeadline().getValue().name());
            }

            p.setInt(i++, c.getLocalization().getValue());

            p.setInt(i++, c.getUtilization().getStart());
            p.setInt(i++, c.getUtilization().getStep());
            p.setInt(i++, c.getUtilization().getTop());
            p.setFloat(i++, c.getUtilization().getBcetFactor());
            p.setInt(i++, c.getUtilization().getWcetMethod().getValue());
            p.setInt(i++, c.getUtilization().getBalancing().getValue());

            // Store MAST options
            p.setString(i++, m.getName());
            p.setInt(i++, m.getAnalysis().getValue());
            p.setBoolean(i++, m.getSync());
            p.setInt(i++, m.getAssignment().getValue());

            p.setInt(i++, m.getHospaConfig().getInit().getValue());
            p.setFloat(i++, m.getHospaConfig().getKa());
            p.setFloat(i++, m.getHospaConfig().getKr());
            p.setInt(i++, m.getHospaConfig().getIterations());
            p.setInt(i++, m.getHospaConfig().getOverIterations());

            p.setFloat(i++, m.getStopFactor());

            p.setBoolean(i++, m.getGsd());
            p.setFloat(i++, m.getDsFactor());

            p.setBoolean(i++, m.getCalculateSlack());
            p.setBoolean(i++, m.getJitterAvoidance());

            // Store Maximum Schedulable Utilization
            p.setInt(i++, msu);

            // Prepare results array
            double[] res = new double[wcrtArray.length+execTimeArray.length];
            for (int j=0; j<wcrtArray.length;j++){
                res[j] = wcrtArray[j];
            }
            for (int j=0; j<execTimeArray.length;j++){
                res[j+wcrtArray.length]=execTimeArray[j];
            }

            // Save series results
            p.setBytes(i++, Utils.doublesToBytes(res));

            // Save results
            p.executeUpdate();
            p.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
