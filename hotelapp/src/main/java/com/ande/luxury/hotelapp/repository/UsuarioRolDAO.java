/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.entities.Rol;
import com.ande.luxury.hotelapp.entities.Usuario;
import com.ande.luxury.hotelapp.entities.UsuarioRol;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryanvislaochavez
 */
public class UsuarioRolDAO extends BaseDAO<UsuarioRol> {
    
    
    public UsuarioRolDAO(){
        super("hotel.users_role", new RowMapper<UsuarioRol>() {
            @Override
            public UsuarioRol map(ResultSet rs) throws SQLException {
                return new UsuarioRol(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getInt("user_id"),
                        rs.getInt("rol_id"),
                        rs.getInt("active")
                );
            }
        });
    }
    
    public List<UsuarioRol> findRolesByUsuario(String uuid) throws Exception{
        UsuarioDAO userDAO = new UsuarioDAO();
        List<UsuarioRol> listRoles = this.findAll();
        Usuario usuario = userDAO.findByUuid(uuid);
        if(usuario!=null){
            return listRoles.stream().filter(x-> x.getUser_id().equals(usuario.getId())).toList();
        }
        return null;
    }
    
}
