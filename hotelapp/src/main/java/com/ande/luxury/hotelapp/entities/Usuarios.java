/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author bryanvislaochavez
 */
@Getter
@Setter
public class Usuarios {
    private Integer id;
    private String uuid;
    private String documentNumber;
    private String fullName;
    private String phone;
    private String email;
    private String password;
}
