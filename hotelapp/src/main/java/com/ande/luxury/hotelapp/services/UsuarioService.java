/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.services;

import com.ande.luxury.hotelapp.entities.Usuario;
import com.ande.luxury.hotelapp.repository.UsuarioDAO;

/**
 *
 * @author bryanvislaochavez
 */
public class UsuarioService {
    
    public Usuario validateCredentials(String user,String password){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean result = usuarioDAO.validateAutenticate(user,password);
        if(result){
            return usuarioDAO.findUserByUsername(user);
        }else{
            return null;
        }
    }
}
