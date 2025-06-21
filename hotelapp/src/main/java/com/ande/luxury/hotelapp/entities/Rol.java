/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author HP
 */
@Getter
@Setter
public class Rol extends Auditable  {
    private Integer id;
    private String uuid;
    private String code;
    private String description;
    
    public Rol(Integer id){
        this.id = id;
    }
    
    public Rol(Integer id,String uuid,String code,String description,Integer active){
        this.id = id;
        this.uuid = uuid;
        this.code = code;
        this.description = description;
    }
    
}
