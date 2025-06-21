/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author bryanvislaochavez
 */
public class DialogUtils {
     // Colores personalizados
    private static final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private static final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private static final Color WARNING_COLOR = new Color(241, 196, 15);
    private static final Color ERROR_COLOR = new Color(231, 76, 60);
    private static final Color INFO_COLOR = new Color(52, 73, 94);
    
     /**
     * Muestra un diálogo de información personalizado
     */
    public static void showInfo(Component parent, String title, String message) {
        showCustomDialog(parent, title, message, JOptionPane.INFORMATION_MESSAGE, INFO_COLOR);
    }
    
    /**
     * Muestra un diálogo de éxito
     */
    public static void showSuccess(Component parent, String title, String message) {
        showCustomDialog(parent, title, message, JOptionPane.INFORMATION_MESSAGE, SUCCESS_COLOR);
    }
    
    /**
     * Muestra un diálogo de advertencia
     */
    public static void showWarning(Component parent, String title, String message) {
        showCustomDialog(parent, title, message, JOptionPane.WARNING_MESSAGE, WARNING_COLOR);
    }
    
    /**
     * Muestra un diálogo de error
     */
    public static void showError(Component parent, String title, String message) {
        showCustomDialog(parent, title, message, JOptionPane.ERROR_MESSAGE, ERROR_COLOR);
    }
    
    /**
     * Muestra un diálogo de confirmación con opciones personalizadas
     */
    public static boolean showConfirmation(Component parent, String title, String message) {
        return showConfirmation(parent, title, message, new String[]{"Sí", "No"}) == 0;
    }
    
    /**
     * Muestra un diálogo de confirmación con opciones personalizables
     */
    public static int showConfirmation(Component parent, String title, String message, String[] options) {
        UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.PLAIN, 12));
        
        return JOptionPane.showOptionDialog(
            parent,
            createMessagePanel(message, PRIMARY_COLOR),
            title,
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );
    }
    
    /**
     * Muestra un diálogo de entrada de texto
     */
    public static String showInput(Component parent, String title, String message) {
        return showInput(parent, title, message, "");
    }
    
    /**
     * Muestra un diálogo de entrada de texto con valor por defecto
     */
    public static String showInput(Component parent, String title, String message, String defaultValue) {
        JTextField textField = new JTextField(defaultValue, 20);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JPanel panel = createInputPanel(message, textField, PRIMARY_COLOR);
        
        int result = JOptionPane.showConfirmDialog(
            parent,
            panel,
            title,
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        return result == JOptionPane.OK_OPTION ? textField.getText() : null;
    }
    
    /**
     * Muestra un diálogo con lista de selección
     */
    public static String showSelection(Component parent, String title, String message, List<String> options) {
        return showSelection(parent, title, message, options.toArray(new String[0]));
    }
    
    /**
     * Muestra un diálogo con lista de selección (array)
     */
    public static String showSelection(Component parent, String title, String message, String[] options) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JPanel panel = createInputPanel(message, comboBox, PRIMARY_COLOR);
        
        int result = JOptionPane.showConfirmDialog(
            parent,
            panel,
            title,
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        return result == JOptionPane.OK_OPTION ? (String) comboBox.getSelectedItem() : null;
    }
    
    /**
     * Muestra un diálogo personalizado con múltiples campos
     */
    public static DialogResult showCustomForm(Component parent, String title, FormField... fields) {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel de campos
        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        for (int i = 0; i < fields.length; i++) {
            FormField field = fields[i];
            
            // Label
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 0, 5, 10);
            JLabel label = new JLabel(field.getLabel() + ":");
            label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            fieldsPanel.add(label, gbc);
            
            // Campo
            gbc.gridx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;
            gbc.insets = new Insets(5, 0, 5, 0);
            field.getComponent().setPreferredSize(new Dimension(200, 25));
            fieldsPanel.add(field.getComponent(), gbc);
        }
        
        mainPanel.add(fieldsPanel, BorderLayout.CENTER);
        
        int result = JOptionPane.showConfirmDialog(
            parent,
            mainPanel,
            title,
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );
        
        return new DialogResult(result == JOptionPane.OK_OPTION, fields);
    }
    
    /**
     * Muestra un diálogo de progreso (no modal)
     */
    public static ProgressDialog showProgress(Component parent, String title, String message) {
        return new ProgressDialog(parent, title, message);
    }
    
    // Métodos auxiliares privados
    
    private static void showCustomDialog(Component parent, String title, String message, int messageType, Color accentColor) {
        JPanel panel = createMessagePanel(message, accentColor);
        
        JOptionPane.showMessageDialog(parent, panel, title, messageType);
    }
    
    private static JPanel createMessagePanel(String message, Color accentColor) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Barra de color superior
        JPanel colorBar = new JPanel();
        colorBar.setBackground(accentColor);
        colorBar.setPreferredSize(new Dimension(0, 4));
        panel.add(colorBar, BorderLayout.NORTH);
        
        // Mensaje
        JLabel messageLabel = new JLabel("<html><div style='width: 300px;'>" + message + "</div></html>");
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel.add(messageLabel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private static JPanel createInputPanel(String message, JComponent inputComponent, Color accentColor) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Barra de color superior
        JPanel colorBar = new JPanel();
        colorBar.setBackground(accentColor);
        colorBar.setPreferredSize(new Dimension(0, 4));
        panel.add(colorBar, BorderLayout.NORTH);
        
        // Mensaje
        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel.add(messageLabel, BorderLayout.NORTH);
        
        // Campo de entrada
        panel.add(inputComponent, BorderLayout.CENTER);
        
        return panel;
    }
    
    // Clases auxiliares
    
    /**
     * Representa un campo en un formulario personalizado
     */
    public static class FormField {
        private final String label;
        private final JComponent component;
        
        public FormField(String label, JComponent component) {
            this.label = label;
            this.component = component;
            
            // Aplicar estilo común
            component.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        }
        
        public String getLabel() {
            return label;
        }
        
        public JComponent getComponent() {
            return component;
        }
        
        public String getValue() {
            if (component instanceof JTextField textField) {
                return textField.getText();
            } else if (component instanceof JComboBox<?> comboBox) {
                return comboBox.getSelectedItem().toString();
            } else if (component instanceof JCheckBox checkBox) {
                return String.valueOf(checkBox.isSelected());
            }
            return "";
        }
    }
    
    /**
     * Resultado de un diálogo personalizado
     */
    public static class DialogResult {
        private final boolean accepted;
        private final FormField[] fields;
        
        public DialogResult(boolean accepted, FormField[] fields) {
            this.accepted = accepted;
            this.fields = fields;
        }
        
        public boolean isAccepted() {
            return accepted;
        }
        
        public String getValue(int index) {
            return fields[index].getValue();
        }
        
        public String getValue(String label) {
            for (FormField field : fields) {
                if (field.getLabel().equals(label)) {
                    return field.getValue();
                }
            }
            return null;
        }
    }
    
    /**
     * Diálogo de progreso no modal
     */
    public static class ProgressDialog {
        private final JDialog dialog;
        private final JProgressBar progressBar;
        private final JLabel statusLabel;
        
        public ProgressDialog(Component parent, String title, String message) {
            dialog = new JDialog(SwingUtilities.getWindowAncestor(parent), title, Dialog.ModalityType.MODELESS);
            
            JPanel panel = new JPanel(new BorderLayout(15, 15));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            
            statusLabel = new JLabel(message);
            statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            panel.add(statusLabel, BorderLayout.NORTH);
            
            progressBar = new JProgressBar();
            progressBar.setStringPainted(true);
            progressBar.setString("0%");
            panel.add(progressBar, BorderLayout.CENTER);
            
            dialog.add(panel);
            dialog.setSize(350, 120);
            dialog.setLocationRelativeTo(parent);
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dialog.setVisible(true);
        }
        
        public void updateProgress(int progress, String status) {
            SwingUtilities.invokeLater(() -> {
                progressBar.setValue(progress);
                progressBar.setString(progress + "%");
                if (status != null) {
                    statusLabel.setText(status);
                }
            });
        }
        
        public void close() {
            SwingUtilities.invokeLater(() -> dialog.dispose());
        }
    }
}
