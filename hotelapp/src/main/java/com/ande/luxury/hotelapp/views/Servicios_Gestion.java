package com.ande.luxury.hotelapp.views;

import com.ande.luxury.hotelapp.entities.BookingServiceType;
import com.ande.luxury.hotelapp.services.BookingServiceTypeService;
import com.ande.luxury.hotelapp.utilsdb.ButtonEditor;
import com.ande.luxury.hotelapp.utilsdb.ButtonRenderer;
import static com.ande.luxury.hotelapp.utilsdb.Constants.formatCurrency;
import java.awt.Component;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author bryanvislaochavez
 */
public class Servicios_Gestion extends javax.swing.JInternalFrame {

    private String userLoguin;

private void cargarDatosServicios() {
       String[] columnas = {"ID", "Nombre", "Precio", "Editar", "Eliminar"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    BookingServiceTypeService bookingServiceTypeService = new BookingServiceTypeService();
    List<BookingServiceType> listBooking = bookingServiceTypeService.findAll();
    
    if (!listBooking.isEmpty()) {
        for (BookingServiceType item : listBooking) {
            modelo.addRow(new Object[]{
                item.getId(),
                item.getName(),
                formatCurrency(item.getPrice()),
                "Editar", "Eliminar"
            });
        }
    }
    
    
  
    
  jTable1.setModel(modelo);

    jTable1.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer("Editar"));
    jTable1.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), jTable1, "Editar", this));

    jTable1.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer("Eliminar"));
    jTable1.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox(), jTable1, "Eliminar", this));

        }
        



    public Servicios_Gestion() {

}

    public void editarFilaEnFormularioPadre(int row) {
    int id = (int) jTable1.getValueAt(row, 0);
    JOptionPane.showMessageDialog(this, "Editar servicio ID: " + id);
    // Servicios_Editar form = new Servicios_Editar(id);
    // form.setVisible(true);
}

public void eliminarFilaEnFormularioPadre(int row) throws Exception {
    int id = (int) jTable1.getValueAt(row, 0);
    String nombre = (String) jTable1.getValueAt(row, 1);

    int confirm = JOptionPane.showConfirmDialog(this,
            "¿Eliminar el servicio: " + nombre + "?", "Confirmar",
            JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        BookingServiceType service = new BookingServiceType();
        boolean eliminado = service.deleteById(id); // este método lo veremos abajo

        if (eliminado) {
            ((DefaultTableModel) jTable1.getModel()).removeRow(row);
            JOptionPane.showMessageDialog(this, "Servicio eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el servicio.");
        }
    }
}

public class ButtonRenderer extends JButton implements TableCellRenderer {
     public ButtonRenderer(String label) {
        setText(label);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private final JButton button;
    private final JTable table;
    private final String action;
    private final Servicios_Gestion parent;

    public ButtonEditor(JCheckBox checkBox, JTable table, String action, Servicios_Gestion parent) {
        this.table = table;
        this.action = action;
        this.parent = parent;
        this.button = new JButton(action);

        button.addActionListener(e -> {
            fireEditingStopped();
            int row = table.getSelectedRow();
            if ("Editar".equals(action)) {
                parent.editarFilaEnFormularioPadre(row);
            } else if ("Eliminar".equals(action)) {
                try {
                    parent.eliminarFilaEnFormularioPadre(row);
                } catch (Exception ex) {
                    Logger.getLogger(Servicios_Gestion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return action;
    }
}

    public Servicios_Gestion(String usuario) {
        initComponents();
    this.userLoguin = usuario;
    cargarDatosServicios(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCrear1 = new javax.swing.JButton();

        setTitle("Ande Luxury :: Gestion Servicios");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Gestión de Servicios (Habitación)");

        btnCrear.setBackground(new java.awt.Color(102, 255, 102));
        btnCrear.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(0, 102, 102));
        btnCrear.setText("+ Crear ");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnCrear1.setBackground(new java.awt.Color(102, 255, 102));
        btnCrear1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnCrear1.setForeground(new java.awt.Color(0, 102, 102));
        btnCrear1.setText("+ Actualizar");
        btnCrear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrear)
                        .addGap(35, 35, 35))))
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(btnCrear1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnCrear))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCrear1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        //Usuario_Nuevo form = new Usuario_Nuevo();
        //form.setVisible(true);
        Servicios_Crear form = new Servicios_Crear();
        form.setVisible(true);

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCrear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrear1ActionPerformed
        // TODO add your handling code here:
        
      try {
        cargarDatosServicios(); // Reutiliza tu método que ya hace esto
        JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar datos:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCrear1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrear1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
 
}
