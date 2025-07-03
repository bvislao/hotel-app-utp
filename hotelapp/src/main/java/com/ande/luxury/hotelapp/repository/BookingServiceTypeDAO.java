/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.BookingServiceType;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ferfer
 */
public class BookingServiceTypeDAO extends BaseDAO <BookingServiceType>{

    public BookingServiceTypeDAO(){
        super("bookings_service_type", new RowMapper<BookingServiceType>() {
      @Override
      
    public BookingServiceType map(ResultSet rs) throws SQLException {
             return new BookingServiceType(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getString("name"),
                        rs.getInt("price")                );
            }
        });
    }

}
