/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.BookingsService;
import com.ande.luxury.hotelapp.entities.HotelRoom;
import com.ande.luxury.hotelapp.entities.models.SearchBookings;
import com.ande.luxury.hotelapp.services.BookingService;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class BookingsServiceDAO extends BaseDAO<BookingsService> {

    private static final Logger logger = LoggerFactory.getLogger(BookingsServiceDAO.class);

    public BookingsServiceDAO() {
        super("bookings_service", new RowMapper<BookingsService>() {
            @Override
            public BookingsService map(ResultSet rs) throws SQLException {
                return new BookingsService(
                        rs.getString("uuid"),
                        rs.getInt("booking_id"),
                        rs.getInt("bookings_service_type_id"),
                        rs.getInt("count"),
                        rs.getDouble("price"),
                        rs.getDouble("price_total"));
            }
        });
    }

    String callBookingsServicesByBookingId = "call sp_get_bookings_service_by_booking_id(?)";
    String callBookingServiceCreateByBooking = "call sp_add_service_to_booking(?,?,?,?,?)";

    public List<BookingsService> listServicesByBookingId(Integer bookingId) throws Exception {
        List<BookingsService> result = new ArrayList<>();
        Connection conn = databaseConnection.getInstancia().getConexion();
        try (
                PreparedStatement stmt = conn.prepareStatement(callBookingsServicesByBookingId)) {
            stmt.setInt(1, bookingId); // Setea el parámetro del procedimiento
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BookingsService service = new BookingsService();
                service.setUuid(rs.getString("UUID"));
                service.setBookingId(rs.getInt("BOOKING_ID"));
                service.setBookingServiceTypeId(rs.getInt("BOOKINGS_SERVICE_TYPE_ID"));
                BookingServiceTypeDAO bookingServiceTypeDAO = new BookingServiceTypeDAO();
                service.setBookingServiceType(bookingServiceTypeDAO.findByUuid(service.getUuid()));
                service.setCount(rs.getInt("COUNT"));
                service.setPrice(rs.getDouble("PRICE"));
                service.setPriceTotal(rs.getDouble("PRICE_TOTAL"));
                service.setActive(rs.getInt("ACTIVE"));
                result.add(service);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    public void saveBookingsService(BookingsService bookingsService) throws Exception {
        Connection conn = databaseConnection.getInstancia().getConexion();
        try (
                PreparedStatement stmt = conn.prepareStatement(callBookingServiceCreateByBooking)) {
            stmt.setInt(1, bookingsService.getBookingId()); // Setea el parámetro del procedimiento
            stmt.setInt(2, bookingsService.getBookingServiceTypeId()); // Setea el parámetro del procedimiento
            stmt.setInt(3, bookingsService.getCount()); // Setea el parámetro del procedimiento
            stmt.setDouble(4, bookingsService.getPrice()); // Setea el parámetro del procedimiento
            stmt.setString(5, bookingsService.getCreated_by()); // Setea el parámetro del procedimiento
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
