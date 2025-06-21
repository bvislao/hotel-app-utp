/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.entities.Hotel;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bryanvislaochavez
 */
public class HotelDAO extends BaseDAO<Hotel>{
    
     public HotelDAO() {
        super("hotel.hotel", new RowMapper<Hotel>() {
            @Override
            public Hotel map(ResultSet rs) throws SQLException {
                return new Hotel(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getInt("category"),
                        rs.getString("address"),
                        rs.getString("location"),
                        rs.getInt("status_id")
                );
            }
        });
    }
     

}
