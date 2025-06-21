/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ande.luxury.hotelapp;

import com.ande.luxury.hotelapp.views.Login;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author bryanvislaochavez
 */
public class Hotelapp {

    public static void main(String[] args) {
    // Option 1: Using a resource URL
        // Configura el Look and Feel Nimbus
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
            // Fallback al LaF predeterminado si Nimbus falla
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
         // Use SwingUtilities.invokeLater to run on the EDT
        javax.swing.SwingUtilities.invokeLater(() -> {
            Login mainForm = new Login();
            mainForm.setVisible(true); // This shows the window
        });
    }
}
