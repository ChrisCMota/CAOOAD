/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author furta
 */
public class SqlDataAccess implements DataAccess {
    
private final String DB_URL;
    private final String USER;
    private final String PASS;
    private final SchemaAndTableCreator schemaAndTableCreator;
    private final PlayerDataInserter playerDataInserter;
    private final PlayerDataReader playerDataReader;

    public SqlDataAccess(String dbUrl, String user, String pass) {
        this.DB_URL = dbUrl;
        this.USER = user;
        this.PASS = pass;
        this.schemaAndTableCreator = new SqlSchemaAndTableCreator();
        this.playerDataInserter = new SqlPlayerDataInserter();
        this.playerDataReader = new SqlPlayerDataReader();
    }

    @Override
    public void createSchemaAndTables(String dbName, String[] teams) throws SQLException {
        schemaAndTableCreator.createSchemaAndTables(dbName, teams);
    }

    @Override
    public void insertPlayerData(String teamName, String name, int number, String birth, String position, int goalsScored, String background) throws SQLException {
        playerDataInserter.insertPlayerData(teamName, name, number, birth, position, goalsScored, background);
    }

    @Override
    public ResultSet getPlayerData(String teamName) throws SQLException {
        return playerDataReader.getPlayerData(teamName);
    }
}
