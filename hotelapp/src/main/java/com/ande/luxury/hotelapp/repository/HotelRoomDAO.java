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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class HotelRoomDAO extends BaseDAO<HotelRoom>{
    
    private static final Logger logger = LoggerFactory.getLogger(HotelRoomDAO.class);
    
    public HotelRoomDAO() {
        super("hotel_room", new RowMapper<HotelRoom>() {
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
    
    String callFindAll = "call spListRooms();";
    
    @Override
    public List<HotelRoom> findAll() throws Exception{
           List<HotelRoom> result = new ArrayList<>();
           Connection conn = databaseConnection.getInstancia().getConexion();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(callFindAll)) {

            
            while (rs.next()) {
                HotelRoom hotelRoom = new HotelRoom();
                hotelRoom.setId(rs.getInt("id"));
                hotelRoom.setUuid(rs.getString("uuid"));
                hotelRoom.setHotelId(rs.getInt("hotel_id"));
                hotelRoom.setBookingId(rs.getInt("booking_id"));
                hotelRoom.setRoomTypeId(rs.getInt("room_type_id"));
                hotelRoom.setRoomNumber(rs.getInt("room_number"));
                hotelRoom.setCapacity(rs.getInt("capacity"));
                hotelRoom.setPricePerHour(rs.getDouble("price_per_hour"));
                hotelRoom.setPricePerNight(rs.getDouble("price_per_night"));
                hotelRoom.setReserved(rs.getBoolean("is_reserved"));
                hotelRoom.setStatusId(rs.getInt("status_id"));
                result.add(hotelRoom);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
   
    
    
}
