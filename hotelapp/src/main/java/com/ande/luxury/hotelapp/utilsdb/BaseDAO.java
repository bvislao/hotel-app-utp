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

/**
 *
 * @author bryanvislaochavez
 */
public class BaseDAO<T> {

    private final String tableName;
    private final RowMapper<T> rowMapper;

    public BaseDAO(String tableName, RowMapper<T> rowMapper) {
        this.tableName = tableName;
        this.rowMapper = rowMapper;
    }

    public List<T> findAll() {
        List<T> result = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        try (Connection conn = databaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result.add(rowMapper.map(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public T findUserByUsername(String username) {
        String sql = "SELECT * FROM " + tableName + " WHERE document_number = ?";
        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rowMapper.map(rs);  // Assuming you have a RowMapper<T>
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T findById(int id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rowMapper.map(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
