package es.unican.istr.rtgen.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by juanm on 22/08/2015.
 * NOSQL Database handler
 */
public class DBHandler {

    private Connection dbConn = null;
    private HashMap<String, String> dbColumns = null;

    public DBHandler(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            dbConn = DriverManager.getConnection("jdbc:sqlite:test.db");
            dbColumns = new HashMap<>();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public DBHandler(String dbName, Map<String, String> columns) {
        try {
            Class.forName("org.sqlite.JDBC");
            dbConn = DriverManager.getConnection("jdbc:sqlite:test.db");
            dbColumns = new HashMap<>();
            for (String name: columns.keySet()){
                dbColumns.put(name, columns.get(name));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void addTableColumn(String name, String type) {
        dbColumns.put(name, type);
    }

    public void createTable() {
        try {
            // Creates statement string with columns and type
            Statement stmt = dbConn.createStatement();
            ArrayList<String> stmtStrList = new ArrayList<>();
            stmtStrList.add("CREATE TABLE RT_RESULTS (");
            Iterator<String> iter = dbColumns.keySet().iterator();
            String k = iter.next();
            while (true){
                stmtStrList.add(String.format("%s %s%s", k, dbColumns.get(k), iter.hasNext()?",":")"));
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
