/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ande.luxury.hotelapp;

import com.ande.luxury.hotelapp.views.Main;

/**
 *
 * @author bryanvislaochavez
 */
public class Hotelapp {

    public static void main(String[] args) {
         // Use SwingUtilities.invokeLater to run on the EDT
        javax.swing.SwingUtilities.invokeLater(() -> {
            Main mainForm = new Main();
            mainForm.setVisible(true); // This shows the window
        });
    }
}
