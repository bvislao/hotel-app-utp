/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.HotelRoom;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class HotelRoomDAO extends BaseDAO<HotelRoom>{
    
    private static final Logger logger = LoggerFactory.getLogger(HotelRoomDAO.class);
    
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
    
    String queryUpdateReserverd= "update hotel_room  set is_reserved = ? where uuid = ? ";
    
    public void updateReserved(Integer isReserved,String uuid) throws Exception{
                try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(queryUpdateReserverd)) {
                     stmt.setInt(1, isReserved); //is_reserved
                    stmt.setString(2, uuid); // uuid
                    stmt.executeUpdate();
                }catch(Exception ex){
                     logger.error("Error updateReserved => " + ex.getMessage());
                    throw new Exception("Ocurrio un error al querer insertar.");
                }finally {
                }
    }
    
}
