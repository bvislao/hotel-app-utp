/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.services;

import com.ande.luxury.hotelapp.entities.HabitacionTipo;
import com.ande.luxury.hotelapp.repository.HabitacionTipoDAO;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author HP
 */
public class HabitacionTipoService {
     private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
     
     public List<HabitacionTipo> findAll() throws Exception{
         List<HabitacionTipo> listReturn = new ArrayList<>();
         HabitacionTipoDAO habitacionTipoDAO = new HabitacionTipoDAO();
         listReturn = habitacionTipoDAO.findAll();
         return listReturn;
     }
}
