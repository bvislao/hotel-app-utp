/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import com.ande.luxury.hotelapp.database.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class BaseDAO<T> {

    private static final Logger logger = LoggerFactory.getLogger(BaseDAO.class);
    
    private final String tableName;
    private final RowMapper<T> rowMapper;

    public BaseDAO(String tableName, RowMapper<T> rowMapper) {
        this.tableName = tableName;
        this.rowMapper = rowMapper;
    }

    public List<T> findAll() throws Exception {
        List<T> result = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName + " WHERE active = 1";
        Connection conn = databaseConnection.getInstancia().getConexion();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result.add(rowMapper.map(rs));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public T findById(int id) throws Exception {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        Connection conn = databaseConnection.getInstancia().getConexion();
        try ( PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rowMapper.map(rs);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    public T findByUuid(String uuid) throws Exception {
        String sql = "SELECT * FROM " + tableName + " WHERE uuid = ?";
        Connection conn = databaseConnection.getInstancia().getConexion();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, uuid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rowMapper.map(rs);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int id) throws Exception {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        Connection conn = databaseConnection.getInstancia().getConexion();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

}