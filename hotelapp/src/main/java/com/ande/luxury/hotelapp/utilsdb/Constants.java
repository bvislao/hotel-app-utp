/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import java.util.UUID;

/**
 *
 * @author bryanvislaochavez
 */
public class Constants {

    public static final String URL_DATABASE = "jdbc:mysql://localhost:33060/hotel"; // your DB
    public static final String USER_DATABASE = "root"; // your DB user
    public static final String PASSWORD_DATABASE = "toor"; // your DB password

    public static String generateUuid() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString();
    }

    /**
     * Estado del registro para las operaciones
     */
    public enum EntityStatus {
        ACTIVO(1),
        INACTIVO(2);

        private final int value;

        EntityStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Activo como registro lógico 
     */
    public enum EntityActive {
        ACTIVO(1),
        INACTIVO(0);

        private final int value;

        EntityActive(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
