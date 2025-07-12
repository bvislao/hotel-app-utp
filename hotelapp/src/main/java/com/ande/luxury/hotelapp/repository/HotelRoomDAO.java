/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.Booking;
import com.ande.luxury.hotelapp.entities.Hotel;
import com.ande.luxury.hotelapp.entities.HotelRoom;
import com.ande.luxury.hotelapp.entities.RoomType;
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
    String spManagementHotelRoomsList = "call sp_management_hotel_rooms_list();";
    
    @Override
    public List<HotelRoom> findAll() throws Exception{
           List<HotelRoom> result = new ArrayList<>();
           Connection conn = databaseConnection.getInstancia().getConexion();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(callFindAll)) {

            
            while (rs.next()) {
                HotelRoom hotelRoom = new HotelRoom();
                hotelRoom.setId(rs.getInt("id"));
                hotelRoom.setUuid(rs.getString("uuid"));
                
                if(rs.getInt("hotel_category") > 0){
                     Hotel hotel = new Hotel(rs.getString("hotel_address"), rs.getInt("hotel_category"), rs.getString("hotel_address"));
                     hotelRoom.setHotel(hotel);
                }
                if(rs.getInt("room_type_id") > 0){
                      RoomType roomType = new  RoomType(rs.getInt("room_type_id"), rs.getString("room_type_uuid"), rs.getString("room_type_description"), 1);
                      hotelRoom.setRoomType(roomType);
                }
                Integer bookingId = (Integer) rs.getObject("booking_id");
                if (bookingId != null) {
                    // booking_id no es NULL
                    Booking booking = new Booking(rs.getInt("booking_id"),
                            rs.getString("booking_uuid"),
                            rs.getInt("booking_pin_code"),
                            rs.getDate("booking_check_in"),
                            rs.getDate("booking_check_out"),
                            rs.getInt("booking_user_id"),
                            rs.getInt("booking_childrens"), 
                            rs.getInt("booking_adults"),
                            rs.getString("booking_document_number_guest"),
                            rs.getString("booking_full_name_guest"), 
                            rs.getString("booking_email_guest"), 
                            rs.getString("booking_country_code"), 
                            rs.getString("booking_phone_number"), 
                            rs.getString("booking_comments"),
                            rs.getInt("booking_total_nights"),
                            rs.getDouble("booking_total"),
                            rs.getInt("booking_is_released")
                    );
                    hotelRoom.setBookingReference(booking);
                          
                }
              
                
                
                hotelRoom.setRoomNumber(rs.getInt("room_number"));
                hotelRoom.setCapacity(rs.getInt("capacity"));
                hotelRoom.setPricePerHour(rs.getDouble("price_per_hour"));
                hotelRoom.setPricePerNight(rs.getDouble("price_per_night"));
                hotelRoom.setReserved(rs.getBoolean("is_reserved"));
                result.add(hotelRoom);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
    public  List<HotelRoom>  getRoomsListForManagement() throws Exception{
           List<HotelRoom> result = new ArrayList<>();
           Connection conn = databaseConnection.getInstancia().getConexion();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(spManagementHotelRoomsList)) {
            while (rs.next()) {
                HotelRoom hotelRoom = new HotelRoom();
                hotelRoom.setUuid(rs.getString("uuid"));
                hotelRoom.setRoomNumber(rs.getInt("room_number"));
                hotelRoom.setRoomTypeDescription(rs.getString("room_type"));
                hotelRoom.setCapacity(rs.getInt("capacity"));
                hotelRoom.setPricePerHour(rs.getDouble("price_per_hour"));
                hotelRoom.setPricePerNight(rs.getDouble("price_per_night"));
                hotelRoom.setIsReservedStr(rs.getString("is_reserved"));
                hotelRoom.setActiveStr(rs.getString("active"));
                result.add(hotelRoom);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    
   
    
    
}
