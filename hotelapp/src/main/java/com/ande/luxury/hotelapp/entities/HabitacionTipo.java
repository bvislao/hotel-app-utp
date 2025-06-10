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
public class HabitacionTipo extends Auditable  {
    private Integer id;
    private String uuid;
    private String description;
    private Integer active;
    
    public HabitacionTipo(Integer id){
        this.id = id;
    }
    public HabitacionTipo(Integer id,String uuid,String description,Integer active){
        this.id = id;
        this.uuid = uuid;
        this.description =description;
        this.active = active;
    }
}
