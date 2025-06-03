/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author bryanvislaochavez
 */
public class Seguridad {
    private static int strength = 12; // cost factor (log rounds)
    private static final Logger logger = LoggerFactory.getLogger(Seguridad.class);
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(strength);
    // Hash (Encrypt)

    public static String encrypt(String plainText) {
        try {
            return encoder.encode(plainText);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    // Verify (Match plain with encrypted)
    public static boolean decrypt(String plainText, String hashedValue) {
        try {
            return encoder.matches(plainText, hashedValue);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return false;
        }
    }

}
