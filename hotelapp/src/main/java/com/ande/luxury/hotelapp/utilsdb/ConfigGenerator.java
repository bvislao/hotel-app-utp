/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author bryanvislaochavez
 */
public class ConfigGenerator {

    private static final String CONFIG_FILE = "config.properties";

    public static void generateIfNotExists() {
        File configFile = new File(CONFIG_FILE);

        if (configFile.exists()) {
            System.out.println("✔ Archivo config.properties ya existe.");
            return;
        }

        // Usamos LinkedHashMap para mantener el orden de inserción
        Map<String, String> props = new LinkedHashMap<>();
        props.put("db.url", "jdbc:mysql://azp0z.h.filess.io:3307/hotelappdev_readyidea?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
        props.put("db.user", "hotelappdev_readyidea");
        props.put("db.password", "e1626383d9111de9d6895aa7eadfa6a97b75724c");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile))) {
            writer.write("# Archivo de configuración generado automáticamente\n");

            for (Map.Entry<String, String> entry : props.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }

            System.out.println("✅ Archivo config.properties creado correctamente.");
        } catch (IOException e) {
            System.err.println("❌ Error al crear config.properties: " + e.getMessage());
        }
    }
}
