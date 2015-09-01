package es.unican.istr.gen4mast;

import es.unican.istr.rtgen.system.elements.config.LinearSystemConfigurableOptions;
import es.unican.istr.rtgen.tool.mast.config.MastToolConfigurableOptions;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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


    private void establishColumns() {
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

}
