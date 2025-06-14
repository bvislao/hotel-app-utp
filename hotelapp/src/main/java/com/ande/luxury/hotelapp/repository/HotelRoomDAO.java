/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.entities.Hotel;
import com.ande.luxury.hotelapp.entities.HotelRoom;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bryanvislaochavez
 */
public class HotelRoomDAO extends BaseDAO<HotelRoom>{
    
    public HotelRoomDAO() {
        super("hotel.hotel_room", new RowMapper<HotelRoom>() {
            @Override
            public HotelRoom map(ResultSet rs) throws SQLException {
                return new HotelRoom(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getInt("hotel_id"),
                        rs.getInt("room_type_id"),
                        rs.getInt("room_number"),
                        rs.getDouble("price_per_hour"),
                        rs.getDouble("price_per_night"),
                        rs.getBoolean("is_reserved"),
                        rs.getInt("status_id")
                );
            }
        });
    }
    
}
