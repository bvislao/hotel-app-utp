/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.database;

import com.ande.luxury.hotelapp.utilsdb.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bryanvislaochavez
 */
public class databaseConnection {
    
 
     public static Connection getConnection() throws SQLException {
         try{
            return DriverManager.getConnection(Constants.URL_DATABASE, Constants.USER_DATABASE, Constants.PASSWORD_DATABASE);     
         }catch(SQLException ex){
             throw new SQLException(ex);
         }
        
    }
}
