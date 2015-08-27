package es.unican.istr.rtgen.tool.mast.results;

import java.sql.*;

/**
 * Created by juanm on 27/08/2015.
 */
public class DBHandler {

    public static final String TABLE_NAME = "RESULTS";

    private enum TABLE_COLUMNS {SEED, NPROCS, NFLOWS, NTASKS, RANDOM_LENGTH, SINGLE_FLOWS, SCHED_POLICY,
                                PERIOD_DISTRIBUTION, PERIOD_BASE_PERIOD_RATIO,
                                E2E_DEADLINE,
                                LOCALIZATION,
                                UTILIZATION_START, UTILIZATION_STEP, UTILIZATION_TOP, UTILIZATION_BCET_FACTOR, UTILIZATION_WCET_METHOD, UTILIZATION_BALANCING};

    public static boolean tableExists(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(String.format("jdbc:sqlite:%s", dbName));
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet res = dbm.getTables(null, null, TABLE_NAME, null);
            return res.next(); // true if table exist, false if not

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void createMastTable(String dbName) {
        if (!tableExists(dbName)) {
            try {
                Class.forName("org.sqlite.JDBC");
                Connection con = DriverManager.getConnection(String.format("jdbc:sqlite:%s", dbName));

                Statement stmt = con.createStatement();

            } catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }

        }
    }

}
