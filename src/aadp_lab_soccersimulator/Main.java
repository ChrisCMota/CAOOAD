/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Sam
 * Please put the names and student numbers of the team here:
 * 
 * Name 1:Christian Carvalho da Mota
 * Number 1:2021274
 * 
 * Name 2:Marcus Ribeiro
 * Number 2:2021304
 * 
 * Name 3:
 * Number 3:
 * 
 * Name 4:
 * Number 4
 * 
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        
    
        String dbUrl = "jdbc:mysql://localhost/world_cup";
        String user = "football";
        String pass = "Java is almost as good as football";

        PlayerDataReader playerDataReader = new SqlPlayerDataReader(dbUrl, user, pass);

        
        String teamName = "Ireland";
        try {
            ResultSet rs = playerDataReader.getPlayerData(teamName);
            // Process and display player data from ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int number = rs.getInt("number");
                String birth = rs.getString("birth");
                String position = rs.getString("position");
                int goalsScored = rs.getInt("goalsScored");
                String background = rs.getString("background");

                System.out.println(String.format("Name: %s, Number: %d, Birth: %s, Position: %s, Goals Scored: %d", name, number, birth, position, goalsScored));
                System.out.println("Background: " + background);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}   

