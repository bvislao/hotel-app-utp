/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.services;

import com.ande.luxury.hotelapp.entities.Booking;
import com.ande.luxury.hotelapp.entities.Hotel;
import com.ande.luxury.hotelapp.entities.HotelRoom;
import com.ande.luxury.hotelapp.entities.RoomType;
import com.ande.luxury.hotelapp.entities.models.SearchBookings;
import com.ande.luxury.hotelapp.repository.BookingDAO;
import com.ande.luxury.hotelapp.repository.HotelDAO;
import com.ande.luxury.hotelapp.repository.HotelRoomDAO;
import com.ande.luxury.hotelapp.repository.RoomTypeDAO;
import com.ande.luxury.hotelapp.utilsdb.DialogUtils;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class BookingService {
    
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    
    public List<HotelRoom> findAll() {
        List<HotelRoom> listReturn = new ArrayList<>();
        try{
        HotelRoomDAO hotelRoomDAO = new HotelRoomDAO();
        listReturn = hotelRoomDAO.findAll();
        for(HotelRoom item : listReturn){
            HotelDAO hotelDAO = new HotelDAO();
            RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
            BookingDAO bookingDAO = new BookingDAO();
            Hotel hotel = hotelDAO.findById(item.getHotelId());
            item.setHotel(hotel);
            RoomType roomType = roomTypeDAO.findById(item.getRoomTypeId());
            item.setRoomType(roomType);
            if(item.getBookingId() > 0){
                Booking booking =     bookingDAO.findById(item.getBookingId());
                item.setBookingReference(booking);
            }
            
            
        }
        }catch(Exception ex){
            listReturn = null;
            logger.error(ex.getMessage());
        }
        return listReturn;
    }
    
    public void saveBooking(Booking booking) throws Exception{
        try{
            BookingDAO bookingDAO = new BookingDAO();
            String uuidRegistered = bookingDAO.save(booking);
            if(!uuidRegistered.isEmpty()){
                DialogUtils.showSuccess(null, "Reserva", "Reserva confirmada ID=> " + uuidRegistered);
            }else{
                DialogUtils.showWarning(null, "Reserva", "No se pudo registrar la reserva");
            }
            
        }catch(Exception ex){
            logger.error(ex.getMessage());
            throw new Exception("Ocurrio un error al registrar");
        }
    }
    
     public void checkOutBooking(String  uuid,String user) throws Exception{
        try{
            BookingDAO bookingDAO = new BookingDAO();
            bookingDAO.checkout(uuid,user);
            DialogUtils.showSuccess(null, "Reserva", "Se hizo el checkout correctamente");
        }catch(Exception ex){
            logger.error(ex.getMessage());
            throw new Exception("Ocurrio un error al registrar");
        }
    }
    

    public List<SearchBookings> listBookingsByDocumentNumber(String document) throws Exception{
          BookingDAO bookingDAO = new BookingDAO();
          return bookingDAO.listBookingForCheckoutByDocument(document);
    }
    
}
