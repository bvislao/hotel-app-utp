/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.Usuario;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.Constants;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import com.ande.luxury.hotelapp.utilsdb.Seguridad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bryanvislaochavez
 */
public class UsuarioDAO extends BaseDAO<Usuario> {
    
    public UsuarioDAO() {
        super("hotel.users", new RowMapper<Usuario>() {
            @Override
            public Usuario map(ResultSet rs) throws SQLException {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getString("document_number"),
                        rs.getString("full_name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("status_id")
                );
            }
        });
    }
    
    private String queryInsert = "INSERT INTO hotel.users (uuid, document_number, full_name, phone, email, password, status_id, active, created_by," +
"                         created_at) values(?,?,?,?,?,?,?,?,?,?);";
    
    
    public Usuario getDataUser(String username) throws Exception{
        Usuario user = this.findUserByUsername(username);
        if(user == null) throw new Exception("Ocurrio un error al querer insertar.");
        return user;
    }
    public boolean validateAutenticate(String username,String password){
        Usuario user = this.findUserByUsername(username);
        if(user!=null){
            if(Seguridad.decrypt(password, user.getPassword())) return true; else return false;
        }else{
            return false;
        }
    }
    public void saveUsuario(Usuario usuario) throws Exception{
       validateSaveUsuario(usuario);
       try(Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryInsert)){
           
           stmt.setString(1, Constants.generateUuid()); // uuid
           stmt.setString(2, usuario.getDocumentNumber()); // document_number
           stmt.setString(3, usuario.getFullName()); // full_name
           stmt.setString(4, usuario.getPhone()); // phone
           stmt.setString(5, usuario.getEmail()); // email
           stmt.setString(6, Seguridad.encrypt(usuario.getPassword())); // password
           stmt.setInt(7, Constants.EntityStatus.ACTIVO.getValue()); // status_id
           stmt.setInt(8, Constants.EntityActive.ACTIVO.getValue()); // active
           stmt.setString(9, usuario.getCreated_by()); // created_by
           stmt.setDate(10, java.sql.Date.valueOf(usuario.getCreated_at()) ); //created_at
           stmt.executeQuery();
           conn.close();
       }catch(Exception ex){
           throw new Exception("Ocurrio un error al querer insertar.");
       }finally {
           
        }
    }
    
    public void validateSaveUsuario(Usuario usuario) throws Exception{
        if(usuario.getDocumentNumber().isBlank() || usuario.getDocumentNumber().isEmpty()){
            throw new Exception("Número de documento no válido.");
        }if(usuario.getEmail().isEmpty()){
            throw new Exception("Número de documento no válido.");
     
        }
        
    }
    
    
    
    
    
}
