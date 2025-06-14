/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author bryanvislaochavez
 */
@Data
public class HotelRoom  extends Auditable {
    
    private Integer id;
    private String uuid;
    private Hotel hotel;
    private Integer hotelId;
    private RoomType roomType;
    private Integer roomTypeId;
    private Integer roomNumber;
    private double PricePerHour;
    private double PricePerNight;
    private boolean isReserved;
    private Integer statusId;
   
    
    public HotelRoom(){
        
    }
    
      public HotelRoom(Integer id,String uuid,Integer hotelId,Integer roomTypeId,Integer roomNumber,double PricePerHour,double PricePerNight,boolean isReserved, Integer statusId){
        this.id = id;
        this.uuid = uuid;
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.roomNumber = roomNumber;
        this.PricePerHour = PricePerHour;
        this.PricePerNight = PricePerNight;
        this.isReserved = isReserved;
        this.statusId = statusId;
    }
    
    
}
