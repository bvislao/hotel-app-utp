/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class databaseConnection {

    private static final Logger logger = LoggerFactory.getLogger(databaseConnection.class);

    public static Connection getConnection() throws Exception,SQLException, FileNotFoundException {
        try {
            Properties props = new Properties();
            InputStream input = new FileInputStream("config.properties");
            props.load(input);
            String URL_DATABASE = props.getProperty("db.url");
            String USER_DATABASE = props.getProperty("db.user");
            String PASSWORD_DATABASE = props.getProperty("db.password");
            return DriverManager.getConnection(URL_DATABASE, USER_DATABASE, PASSWORD_DATABASE);
        } catch (SQLException ex) {
            logger.error("Ocurrio un error al conectar la base de datos" + " ==> " + ex.getMessage() + " -- " + ex.getSQLState());
            throw new SQLException(ex);
        } catch (IOException e) {
            logger.error("No se encontro archivo de configuración");
            throw new Exception(e.getMessage());
        }

    }
}
