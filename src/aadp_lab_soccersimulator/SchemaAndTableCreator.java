/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.sql.SQLException;

/**
 *
 * @author furta
 */
public interface SchemaAndTableCreator {
    void createSchemaAndTables(String dbName, String[] teams) throws SQLException;
}
