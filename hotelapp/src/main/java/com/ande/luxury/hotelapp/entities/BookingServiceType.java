/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import com.ande.luxury.hotelapp.database.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import lombok.Data;

/**
 *
 * @author ferfer
 */
@Data
public class BookingServiceType extends Auditable {
    private Integer id;
    private String uuid;
    private String name;
    private Integer price;

    public BookingServiceType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean deleteById(int id) throws Exception {
    String sql = "DELETE FROM bookings_service_type WHERE id = ?";
    try (Connection conn = databaseConnection.getInstancia().getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        int rows = stmt.executeUpdate();
        return rows > 0;
    } catch (SQLException e) {
        e.printStackTrace();  // MUY IMPORTANTE para depurar
        return false;
    }
}

    
    public List<BookingServiceType> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
public class BookingServiceTypeService {

    }
     
     public BookingServiceType (Integer id,String uuid, String name, Integer price){
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }
     }


