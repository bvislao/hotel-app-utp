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
    private Integer active;
    
    
       public RoomType(){
        
    }
       
     public RoomType(String uuid,String description){
        this.uuid = uuid;
        this.description = description;
    }
       
    public RoomType(Integer id,String uuid,String description,Integer active){
        this.id = id;
        this.uuid = uuid;
        this.description = description;
        this.active = active;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getDescription() {
        return description;
    }
}
