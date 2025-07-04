/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.database;

import com.ande.luxury.hotelapp.utilsdb.AESUtil;
import static com.ande.luxury.hotelapp.utilsdb.Constants.key;
import java.io.FileInputStream;
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
    private static databaseConnection instancia;
    private Connection conexion;
    private String URL_DATABASE;
    private String USER_DATABASE;
    private String PASSWORD_DATABASE;

    public databaseConnection() throws Exception {
        cargarPropiedades();
        conectar();
    }

    private void cargarPropiedades() throws Exception {
        try {
            Properties props = new Properties();
            InputStream input = new FileInputStream("config.properties");
            props.load(input);
            String descryptUrl = AESUtil.decrypt(props.getProperty("db.url"), key);
            String descryptUser = AESUtil.decrypt(props.getProperty("db.user"), key);
            String descryptPwd = AESUtil.decrypt(props.getProperty("db.password"), key);
            URL_DATABASE = descryptUrl;
            USER_DATABASE = descryptUser;
            PASSWORD_DATABASE = descryptPwd;
        } catch (IOException e) {
            logger.error("No se encontró archivo de configuración", e);
            throw new Exception("Error cargando archivo de configuración");
        }
    }

    // Método Singleton
    public static databaseConnection getInstancia() throws Exception {
        if (instancia == null) {
            instancia = new databaseConnection();
        }
        return instancia;
    }

    private void conectar() {
        try {
            conexion = DriverManager.getConnection(URL_DATABASE, USER_DATABASE, PASSWORD_DATABASE);
            logger.info("Conexión establecida con éxito");
        } catch (SQLException e) {
            logger.error("Error al conectar con la base de datos", e);
        }
    }
    // Método que valida si la conexión sigue activa

    public Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                logger.warn("Conexión cerrada. Reintentando...");
                conectar();
            }
        } catch (SQLException e) {
            logger.error("Error verificando conexión", e);
        }
        return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                logger.info("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            logger.error("Error al cerrar la conexión", e);
        }
    }
}
