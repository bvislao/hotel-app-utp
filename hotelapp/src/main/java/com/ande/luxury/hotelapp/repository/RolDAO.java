/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.entities.Rol;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bryanvislaochavez
 */
public class RolDAO  extends BaseDAO<Rol>{
    
    public RolDAO() {
        super("hotel.rol", new RowMapper<Rol>() {
            @Override
            public Rol map(ResultSet rs) throws SQLException {
                return new Rol(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getString("code"),
                        rs.getString("description"),
                        rs.getInt("active")
                );
            }
        });
    }
    
}
