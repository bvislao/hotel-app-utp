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
import javax.transaction.TransactionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    
   

    @TransactionScoped
    public String createUser(Usuario objUser){
        String response = "";
        try{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuarioRegistered = usuarioDAO.findUserByUsername(objUser.getDocumentNumber());
            if(usuarioRegistered == null){
                Usuario usuarioSave = usuarioDAO.saveUsuario(objUser);
                if(usuarioSave != null){
                    response = "";
                }
            }else{
                response = "El usuario con número de documento ya existe";
            }
            return response;
        }catch(Exception ex){
            response = ex.getMessage();
            logger.error(ex.getMessage());
            return response;
        }
    }
    public Usuario validateCredentials(String user,String password) throws Exception{
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
                    Rol rol = rolDAO.findById(userRoles.getRol_id());
                    listRolesByUser.add(rol);
                }
                userData.setRoles(listRolesByUser);
            }
            return userData;
        }else{
            return null;
        }
    }
    public List<Usuario> listUsers() throws Exception{
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
                    Rol rol = rolDAO.findById(userRoles.getRol_id());
                    listRolesByUser.add(rol);
                }
                user.setRoles(listRolesByUser);
            }
        }
        return usuariosList;
    }
    
    public Usuario findOnlyClients(String documentNumber) throws Exception{
        validateFindOnlyClients(documentNumber);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findUserByUsername(documentNumber);
    }

    private void validateFindOnlyClients(String documentNumber) throws Exception {
        if(documentNumber.isBlank()){
            throw new Exception("Ingrese número de documento del cliente");
        }
    }
}
