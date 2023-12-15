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
public class SqlPlayerDataInserter implements PlayerDataInserter {
    
private final String DB_URL;
    private final String USER;
    private final String PASS;

    public SqlPlayerDataInserter(String dbUrl, String user, String pass) {
        this.DB_URL = dbUrl;
        this.USER = user;
        this.PASS = pass;
    }

    SqlPlayerDataInserter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertPlayerData(String teamName, String name, int number, String birth, String position, int goalsScored, String background) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(
                    String.format("INSERT INTO %s (name, number, birth, position, goalsScored, background) "
                                    + "VALUES (\"%s\", %d, \"%s\", \"%s\", %d,  \"%s\") ;",
                            teamName, name, number, birth, position, goalsScored, background)
            );
        }
    }
}

