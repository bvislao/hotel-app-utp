/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author bryanvislaochavez
 */
public class Seguridad {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    // Hash (Encrypt)

    public static String encrypt(String plainText) {
        return encoder.encode(plainText);
    }

    // Verify (Match plain with encrypted)
    public static boolean decrypt(String plainText, String hashedValue) {
        return encoder.matches(plainText, hashedValue);
    }

}
