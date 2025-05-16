/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.entities.Usuarios;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bryanvislaochavez
 */
public class UsuarioDAO extends BaseDAO<Usuarios> {
    
    public UsuarioDAO(String tableName, RowMapper<Usuarios> rowMapper) {
        super(tableName, rowMapper);
    }
    
   
    
    public void insert(Usuarios usuario){
        String sql = "INSERT INTO ";
    }
    
}
