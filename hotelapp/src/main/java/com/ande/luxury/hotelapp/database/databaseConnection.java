/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bryanvislaochavez
 */
public class databaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:33060/hotel"; // your DB
    private static final String USER = "root"; // your DB user
    private static final String PASSWORD = "toor"; // your DB password
 
     public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
