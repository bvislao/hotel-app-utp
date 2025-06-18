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
public class Hotel  extends Auditable {
    
     private Integer id;
    private String uuid;
    private Integer category;
    private String address;
    private String location;
    private Integer statusId;
  
        public Hotel(){
        
    }
        
       public Hotel(Integer id,String uuid,Integer category,String address,String location,Integer statusId){
        this.id = id;
        this.uuid = uuid;
        this.category = category;
        this.address = address;
        this.location = location;
        this.statusId = statusId;
    }
    
    
}
