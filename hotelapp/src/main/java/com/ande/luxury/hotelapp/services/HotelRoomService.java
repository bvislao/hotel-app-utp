/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.services;

import com.ande.luxury.hotelapp.entities.HotelRoom;
import com.ande.luxury.hotelapp.repository.HotelRoomDAO;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class HotelRoomService {

    private static final Logger logger = LoggerFactory.getLogger(HotelRoomService.class);

    public List<HotelRoom> findAll() {
        List<HotelRoom> listReturn = new ArrayList<>();
        try {
            HotelRoomDAO hotelRoomDAO = new HotelRoomDAO();
            listReturn = hotelRoomDAO.getRoomsListForManagement();
        } catch (Exception ex) {
            listReturn = null;
            logger.error(ex.getMessage());
        }
        return listReturn;
    }

}
