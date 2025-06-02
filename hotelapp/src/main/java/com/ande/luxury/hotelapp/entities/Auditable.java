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
public class Auditable {
    private Integer active;
    private String created_by;
    private String created_at;
    private String last_modified_by;
    private String last_modified_at;
    
}
