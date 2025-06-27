/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.services;

import com.ande.luxury.hotelapp.entities.BookingServiceType;
import com.ande.luxury.hotelapp.repository.BookingServiceTypeDAO;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class BookingServiceTypeService {
    
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceTypeService.class);
    
        
    public List<BookingServiceType> findAll() {
        List<BookingServiceType> listReturn = new ArrayList<>();
        try{
        BookingServiceTypeDAO bookingServiceTypeDAO = new BookingServiceTypeDAO();
        listReturn = bookingServiceTypeDAO.findAll();
      }catch(Exception ex){
            listReturn = null;
            logger.error(ex.getMessage());
        }
        return listReturn;
    }
    
    
}
