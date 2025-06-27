/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.RoomType;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryanvislaochavez
 */
public class RoomTypeDAO extends BaseDAO<RoomType> {

    public RoomTypeDAO() {
        super("room_type", new RowMapper<RoomType>() {
            @Override
            public RoomType map(ResultSet rs) throws SQLException {
                return new RoomType(
                    rs.getInt("id"),
                    rs.getString("uuid"),
                    rs.getString("description"),
                    rs.getInt("active")
                );
            }
        });
    }
    
    public void insert(RoomType roomType) throws Exception {
        String sql = "INSERT INTO room_type (uuid, description, active) VALUES (?, ?, ?)";
        Connection conn = databaseConnection.getInstancia().getConexion();
        try (
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, roomType.getUuid());
            stmt.setString(2, roomType.getDescription());
            stmt.setInt(3, roomType.getActive());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ✅ Obtener todos los tipos de habitación
    public List<RoomType> getAll() throws Exception {
        List<RoomType> list = new ArrayList<>();
        String sql = "SELECT * FROM room_type";
Connection conn = databaseConnection.getInstancia().getConexion();
        try (
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RoomType tipo = new RoomType(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getString("description"),
                        rs.getInt("active")
                );
                list.add(tipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
}

