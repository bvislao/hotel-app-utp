/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import lombok.Data;

/**
 *
 * @author HP
 */
@Data
public class Rol {
    private Integer id;
    private String uuid;
    private String code;
    private String description;
    private Integer active;
    
    public Rol(Integer id,String uuid,String code,String description,Integer active){
        this.id = id;
        this.uuid = uuid;
        this.code = code;
        this.description = description;
        this.active = active;
    }
    
}
