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
public class BookingsService  extends Auditable{
    
    private String uuid;
    private Integer bookingId;
    private Booking booking;
    private Integer bookingServiceTypeId;
    private BookingServiceType bookingServiceType;
    private Integer count;
    private double price;
    private double priceTotal;
    
    public BookingsService(){}
    
    public BookingsService(String uuid,Integer bookingId,Integer bookingServiceTypeId,Integer count,double price,double priceTotal){
        this.uuid = uuid;
        this.bookingId = bookingId;
         this.bookingServiceTypeId = bookingServiceTypeId;
         this.count = count;
         this.price = price;
         this.priceTotal = priceTotal;
    } 
}
