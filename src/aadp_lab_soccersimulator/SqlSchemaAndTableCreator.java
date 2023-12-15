/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author furta
 */
public class SqlSchemaAndTableCreator implements SchemaAndTableCreator{
    
private final String DB_URL;
    private final String USER;
    private final String PASS;

    public SqlSchemaAndTableCreator(String dbUrl, String user, String pass) {
        this.DB_URL = dbUrl;
        this.USER = user;
        this.PASS = pass;
    }

    SqlSchemaAndTableCreator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createSchemaAndTables(String dbName, String[] teams) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE SCHEMA IF NOT EXISTS " + dbName + ";");
            stmt.execute("USE " + dbName + ";");
            for (String team : teams) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS " + team + " ("
                                + "name VARCHAR(30) NOT NULL,"
                                + "number INT NOT NULL PRIMARY KEY,"
                                + "birth VARCHAR(30),"
                                + "position VARCHAR(30),"
                                + "goalsScored INT,"
                                + "background TEXT(1000));"
                );
            }
        }
    }
}

