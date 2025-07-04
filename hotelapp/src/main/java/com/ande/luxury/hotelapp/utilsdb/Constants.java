/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import java.text.DecimalFormat;
import java.util.UUID;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author bryanvislaochavez
 */
public class Constants {

    public static String key = "h0t3l-utp-1nt3gr4d0r";
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

    public static java.sql.Date convertToSqlDate(Date utilDate) {
        if (utilDate == null) {
            return null;
        }
        return new java.sql.Date(utilDate.getTime());
    }

    public static int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(100000, 999999);
    }
    
     // Método 3: Método personalizado más robusto (Recomendado)
    public static String formatCurrency(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        return "S/ " + formatter.format(amount);
    }

}
