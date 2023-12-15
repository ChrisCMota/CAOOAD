/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author furta
 */
public class SqlPlayerDataReader implements PlayerDataReader {
    
private final String DB_URL;
    private final String USER;
    private final String PASS;

    public SqlPlayerDataReader(String dbUrl, String user, String pass) {
        this.DB_URL = dbUrl;
        this.USER = user;
        this.PASS = pass;
    }

    SqlPlayerDataReader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getPlayerData(String teamName) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            return stmt.executeQuery("SELECT * FROM " + teamName + ";");
        }
    }
}

