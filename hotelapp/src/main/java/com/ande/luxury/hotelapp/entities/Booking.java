/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author bryanvislaochavez
 */

@Data
public class Booking  extends Auditable {
    
    private Integer id;
    private String uuid;
    private HotelRoom hotelRoom;
    private Integer hotelRoomId;
    private Integer pinCode;
    private Date checkIn;
    private Integer totalNights;
    private double total;
    private Integer isReleased;
    private Date checkOut;
    private Integer userId;
    private Integer childrens;
    private Integer adults;
    private String documentNumber;
    private String fullName;
    private String email;
    private String countryCode = "+51";
    private String phone;
    private String comments;
    
    public Booking(){
        
    }
    
    public Booking(Integer id,String uuid,Integer pinCode,Date checkIn,Date checkOut,Integer userId,Integer childrens, Integer adults,String documentNumber,String fullName,String email,String countryCode,String phone,String comments,Integer totalNights,double total,Integer isReleased){
        this.id=id;
        this.uuid=uuid;
        this.hotelRoomId=hotelRoomId;
        this.pinCode=pinCode;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.userId=userId;
        this.childrens=childrens;
        this.adults=adults;
        this.documentNumber=documentNumber;
        this.fullName=fullName;
        this.email=email;
        this.countryCode=countryCode;
        this.phone=phone;
        this.comments=comments;
        this.total = total;
        this.totalNights = totalNights;
        this.isReleased= isReleased;
        
    }

    /**
     *
     * @param id
     * @param hotelRoomId
     * @param pinCode
     * @param checkIn
     * @param checkOut
     * @param userId
     * @param childrens
     * @param adults
     * @param documentNumber
     * @param fullName
     * @param email
     * @param countryCode
     */
    public Booking(Integer id,String uuid,Integer hotelRoomId,Integer pinCode,Date checkIn,Date checkOut,Integer userId,Integer childrens, Integer adults,String documentNumber,String fullName,String email,String countryCode,String phone,String comments,Integer totalNights,double total,Integer isReleased){
        this.id=id;
        this.uuid=uuid;
        this.hotelRoomId=hotelRoomId;
        this.pinCode=pinCode;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.userId=userId;
        this.childrens=childrens;
        this.adults=adults;
        this.documentNumber=documentNumber;
        this.fullName=fullName;
        this.email=email;
        this.countryCode=countryCode;
        this.phone=phone;
        this.comments=comments;
        this.total = total;
        this.totalNights = totalNights;
        this.isReleased= isReleased;
        
    }
          
    
}
