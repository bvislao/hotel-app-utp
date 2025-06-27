/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import lombok.Data;

/**
 *
 * @author ferfer
 */
@Data
public class BookingServiceType extends Auditable {
    private Integer id;
    private String uuid;
    private String name;
    private Integer price;
    
     public BookingServiceType(){
        
    }
     
     public BookingServiceType (Integer id,String uuid, String name, Integer price){
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.price = price;
    }
}
