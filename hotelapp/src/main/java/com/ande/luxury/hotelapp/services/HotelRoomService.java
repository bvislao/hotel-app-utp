/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.services;

import com.ande.luxury.hotelapp.entities.HotelRoom;
import com.ande.luxury.hotelapp.repository.HotelRoomDAO;
import com.ande.luxury.hotelapp.utilsdb.DialogUtils;
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
            DialogUtils.showError(null, "Error", "Ocurrio un error al listar las habitaciones");
            logger.error(ex.getMessage());
        }
        return listReturn;
    }
    
    public HotelRoom findByUuid(String uuid){
         HotelRoom returnObject = new HotelRoom();
        try {
            HotelRoomDAO hotelRoomDAO = new HotelRoomDAO();
            returnObject = hotelRoomDAO.findByUuid(uuid);
        } catch (Exception ex) {
            returnObject = null;
            DialogUtils.showError(null, "Error", "Ocurrio un error obtener la información");
            logger.error(ex.getMessage());
        }
        return returnObject;
    }
    
    public void save(HotelRoom hotelRoom){
         try {
            HotelRoomDAO hotelRoomDAO = new HotelRoomDAO();
            hotelRoomDAO.save(hotelRoom);
        } catch (Exception ex) {
             DialogUtils.showError(null, "Error", "Ocurrio un error al guardar la habitación nueva");
            logger.error(ex.getMessage());
        }
    }
    
    public void delete(String uuid){
         try {
            HotelRoomDAO hotelRoomDAO = new HotelRoomDAO();
            hotelRoomDAO.deleteByUuid(uuid);
        } catch (Exception ex) {
             DialogUtils.showError(null, "Error", "Ocurrio un error al eliminar  la habitación");
            logger.error(ex.getMessage());
        }
    }

}
