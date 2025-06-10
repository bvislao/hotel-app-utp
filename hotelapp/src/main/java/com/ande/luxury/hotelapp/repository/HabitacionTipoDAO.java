/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.entities.HabitacionTipo;
import com.ande.luxury.hotelapp.entities.Rol;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class HabitacionTipoDAO extends BaseDAO<HabitacionTipo> {
    
    public HabitacionTipoDAO() {
        super("hotel.room_type", new RowMapper<HabitacionTipo>() {
            @Override
            public HabitacionTipo map(ResultSet rs) throws SQLException {
                return new HabitacionTipo(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getString("description"),
                        rs.getInt("active")
                );
            }
        });
    }
    
}
