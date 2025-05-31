/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.services;

import com.ande.luxury.hotelapp.entities.Rol;
import com.ande.luxury.hotelapp.entities.Usuario;
import com.ande.luxury.hotelapp.entities.UsuarioRol;
import com.ande.luxury.hotelapp.repository.RolDAO;
import com.ande.luxury.hotelapp.repository.UsuarioDAO;
import com.ande.luxury.hotelapp.repository.UsuarioRolDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryanvislaochavez
 */
public class UsuarioService {
    
    public Usuario validateCredentials(String user,String password){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean result = usuarioDAO.validateAutenticate(user,password);
        if(result){
            Usuario userData = usuarioDAO.findUserByUsername(user);
            UsuarioRolDAO userRolDAO = new UsuarioRolDAO();
            List<UsuarioRol> listRoles = userRolDAO.findRolesByUsuario(userData.getUuid());
            if(!listRoles.isEmpty()){
                RolDAO rolDAO = new RolDAO();
                List<Rol> listRolesByUser = new ArrayList<>();
                for(UsuarioRol userRoles : listRoles){
                    Rol rol = rolDAO.findById(userRoles.getId());
                    listRolesByUser.add(rol);
                }
                userData.setRoles(listRolesByUser);
            }
            return userData;
        }else{
            return null;
        }
    }
    public List<Usuario> listUsers(){
        List<Usuario> usuariosList = new ArrayList<>();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuariosList = usuarioDAO.findAll();
        UsuarioRolDAO userRolDAO = new UsuarioRolDAO();
        for(Usuario user : usuariosList){
            List<UsuarioRol> listRoles = userRolDAO.findRolesByUsuario(user.getUuid());
            if(!listRoles.isEmpty()){
                RolDAO rolDAO = new RolDAO();
                List<Rol> listRolesByUser = new ArrayList<>();
                for(UsuarioRol userRoles : listRoles){
                    Rol rol = rolDAO.findById(userRoles.getId());
                    listRolesByUser.add(rol);
                }
                user.setRoles(listRolesByUser);
            }
        }
        return usuariosList;
    }
}
