/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import com.ande.luxury.hotelapp.views.Main;
import com.ande.luxury.hotelapp.views.Usuarios_Gestion;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bryanvislaochavez
 */
public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean clicked;
    private int row, col;
    private JTable table;
    private Usuarios_Gestion parent;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        this.table = table;

        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    public ButtonEditor(JCheckBox checkBox, JTable table, String label,Usuarios_Gestion parent) {
        super(checkBox);
        this.table = table;
        this.label = label;
        this.parent=parent;

        button = new JButton();
        button.setOpaque(true);
        button.setText(label);
        button.addActionListener(e -> fireEditingStopped());

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        this.row = row;
        this.col = column;
        clicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            String uuid = table.getValueAt(row, 0).toString();

            if (col == 6) { // Edit column
                parent.editarFilaEnFormularioPadre(row);
                // 👉 You can open a form or dialog to edit this record
            } else if (col == 7) { // Delete column
                int confirm = JOptionPane.showConfirmDialog(button, "Delete uuid: " + uuid + "?");
                if (confirm == JOptionPane.YES_OPTION) {
                    ((DefaultTableModel) table.getModel()).removeRow(row);
                }
            }
        }
        clicked = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

}
