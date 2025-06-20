/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities.models;

import lombok.Data;

/**
 *
 * @author bryanvislaochavez
 */
@Data
public class SearchBookings {
    private String uuid;
    private String roomNumber;
    private String roomUuid;
    private double subtotalRoom;
    private double subTotalServices;
    private double total;
    
}
