/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.ande.luxury.hotelapp.views;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

/**
 *
 * @author bryanvislaochavez
 */
public class About extends javax.swing.JInternalFrame {

    /**
     * Creates new form About
     */
    public About() {
        initComponents();
        this.closable=true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label1 = new java.awt.Label();
        label4 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setForeground(java.awt.Color.lightGray);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Acerca de");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2.setFont(new java.awt.Font("Luminari", 1, 36)); // NOI18N
        label2.setText("Proyecto UTP - Curso Integrador l");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 10, -1, 49));

        label3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        label3.setText("BRYAN VISLAO CHAVEZ");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 81, 585, -1));

        label1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        label1.setText("ALEXIS GIANFRANCO BANCES ALCANTARA");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 117, 585, -1));

        label4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        label4.setText("FERNANDO JULIO FERNANDEZ YNGA");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 153, 585, -1));

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setText("Ir a Repositorio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 585, 41));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        abrirEnlace("https://github.com/bvislao/hotel-app-utp");
    }//GEN-LAST:event_jButton1ActionPerformed
    private void abrirEnlace(String url) {
        try {
            Desktop desktop = Desktop.getDesktop();
            if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI(url));
            } else {
                JOptionPane.showMessageDialog(this, "Navegador no soportado en este sistema.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al abrir el enlace: " + ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    // End of variables declaration//GEN-END:variables
}
