/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.Booking;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.Constants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class BookingDAO extends BaseDAO<Booking> {
    
    private static final Logger logger = LoggerFactory.getLogger(BookingDAO.class);

    public BookingDAO() {
        super("hotel.bookings", (ResultSet rs) -> new Booking(
                rs.getInt("id"),
                rs.getString("uuid"),
                rs.getInt("hotel_room_id"),
                rs.getInt("pin_code"),
                rs.getDate("check_in"),
                rs.getDate("check_out"),
                rs.getInt("user_id"),
                rs.getInt("childrens"),
                rs.getInt("adults"),
                rs.getString("document_number_guest"),
                rs.getString("full_name_guest"),
                rs.getString("email_guest"),
                rs.getString("country_code"),
                rs.getString("phone_number"),
                rs.getString("comments"),
                rs.getInt("total_nights"),
                rs.getDouble("total"),
                rs.getInt("is_released")
        )
        );
    }

    String queryInsert = "CALL spBookingCreated(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    //String listServicesByBookingId = "CALL spListServicesByBooking(?);"
    //String searchBookingsByDocument = "CALL spSearchBookingForCheckOut(?);"
   // String checkOutBoking = "CALL spCheckoutBooking(?,?); "

    @Transactional
    public String save(Booking booking) throws Exception {
        
          String uuid = Constants.generateUuid();
        booking.setUuid(uuid); // Asigna el UUID generado al objeto
        booking.setActive(Constants.EntityActive.ACTIVO.getValue());
        
          try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, uuid);
            stmt.setInt(2, booking.getHotelRoom().getId()); // hotel_room_id
            stmt.setInt(3, booking.getPinCode()); // pin_code
            stmt.setDate(4, Constants.convertToSqlDate(booking.getCheckIn())); // check_in
            stmt.setInt(5, booking.getUserId()); // user_id
            stmt.setInt(6, booking.getChildrens()); // childrens
            stmt.setInt(7, booking.getAdults()); // adults
            stmt.setString(8, booking.getDocumentNumber()); // document_number_guest
            stmt.setString(9, booking.getFullName()); // full_name_guest
            stmt.setString(10, booking.getEmail()); // email_guest
            stmt.setString(11, booking.getCountryCode()); // country_code
            stmt.setString(12, booking.getPhone()); // phone_number
            stmt.setString(13, booking.getComments()); // comments
            stmt.setInt(14, booking.getActive()); // active
            stmt.setString(15, booking.getCreated_by()); // created_by
            stmt.setDate(16, java.sql.Date.valueOf(java.time.LocalDate.now()));  // created_by
            stmt.setInt(17, booking.getTotalNights()); // total_nights
            stmt.setDouble(18, booking.getTotal()); // total
            stmt.executeUpdate();
            conn.close();
            return booking.getUuid();
        } catch (Exception ex) {
            logger.error("Error saveBooking => " + ex.getMessage());
            throw new Exception("Ocurrio un error al querer insertar.");
        } finally {
              return booking.getUuid();
        }

    }

}
