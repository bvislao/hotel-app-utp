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
public class RoomType extends Auditable{
        private Integer id;
    private String uuid;
    private String description;
    
    
        public RoomType(){
        
    }
       
    public RoomType(Integer id,String uuid,String description,Integer active){
        this.id = id;
        this.uuid = uuid;
        this.description = description;
    }
}
