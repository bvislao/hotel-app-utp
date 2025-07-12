/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ande.luxury.hotelapp.views;

import com.ande.luxury.hotelapp.repository.RoomTypeDAO;
import com.ande.luxury.hotelapp.entities.RoomType;

import javax.swing.*;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryanvislaochavez
 */
public class TipoHabitacion_Crear extends javax.swing.JFrame {

    /**
     * Creates new form TipoHabitacion_Crear
     */
    public TipoHabitacion_Crear() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Crear Tipo de Habitación");
    }
    
    private void guardarTipoHabitacion() throws Exception {
        String descripcion = txtDescrip.getText().trim();
        int activo = cbAct.getSelectedIndex();

        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese una descripción.");
            return;
        }

        if (activo == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un estado válido.");
            return;
        }

        RoomType nuevo = new RoomType(
            0,
            UUID.randomUUID().toString(),
            descripcion,
            activo - 1 // Porque el índice 1 = Activo (valor 0), 2 = Inactivo (valor 1)
        );

        RoomTypeDAO dao = new RoomTypeDAO();
        dao.insert(nuevo);

        JOptionPane.showMessageDialog(this, "Tipo de habitación registrado correctamente.");
        txtDescrip.setText("");
        cbAct.setSelectedIndex(0);
        
        this.dispose(); 
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDescrip = new javax.swing.JTextField();
        cbAct = new javax.swing.JComboBox<>();
        btnGuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descripcion:");

        cbAct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Activo ", "Inactivo", " " }));

        btnGuar.setText("Guardar");
        btnGuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuar)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(btnGuar)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuarActionPerformed
        try {
            guardarTipoHabitacion();
        } catch (Exception ex) {
            Logger.getLogger(TipoHabitacion_Crear.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuarActionPerformed

     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TipoHabitacion_Crear().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuar;
    private javax.swing.JComboBox<String> cbAct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtDescrip;
    // End of variables declaration//GEN-END:variables
}
