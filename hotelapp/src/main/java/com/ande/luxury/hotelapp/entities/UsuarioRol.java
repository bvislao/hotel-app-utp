/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import lombok.Data;

/**
 *
 * @author bryanvislaochavez
 */
@Data
public class UsuarioRol extends Auditable  {
    private Integer id;
    private String uuid;
    private Integer user_id;
    private Usuario usuario;
    private Rol rol;
    private Integer rol_id;
    
    
     public UsuarioRol(Integer user_id,Integer rol_id){
        this.user_id = user_id;
        this.rol_id = rol_id;
    }
     
     public UsuarioRol(Integer id,String uuid,Integer user_id,Integer rol_id,Integer active){
        this.id = id;
        this.uuid = uuid;
        this.user_id = user_id;
        this.rol_id = rol_id;
    }
    public UsuarioRol(Integer id,String uuid,Usuario usuario,Rol rol,Integer active){
        this.id = id;
        this.uuid = uuid;
        this.usuario = usuario;
        this.rol = rol;
    }
    
}
