/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author bryanvislaochavez
 */
@Getter
@Setter
public class Usuario extends Auditable {
    private Integer id;
    private String uuid;
    private String documentNumber;
    private String fullName;
    private String phone;
    private String email;
    private String password;
    private Integer status;
    private List<Rol> roles;
    
    public Usuario(Integer id,String uuid,String documentNumber,String fullName,String phone,String email,String password,Integer status){
        this.id = id;
        this.uuid = uuid;
        this.documentNumber = documentNumber;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.status = status;
             
    }
    
    
}
