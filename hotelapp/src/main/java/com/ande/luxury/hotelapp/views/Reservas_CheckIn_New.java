/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ande.luxury.hotelapp.views;

import com.ande.luxury.hotelapp.entities.Booking;
import com.ande.luxury.hotelapp.entities.HotelRoom;
import com.ande.luxury.hotelapp.entities.Usuario;
import com.ande.luxury.hotelapp.services.BookingService;
import com.ande.luxury.hotelapp.services.UsuarioService;
import com.ande.luxury.hotelapp.utilsdb.Constants;
import static com.ande.luxury.hotelapp.utilsdb.Constants.formatCurrency;
import com.ande.luxury.hotelapp.utilsdb.DialogUtils;
import static com.ande.luxury.hotelapp.views.Main.userLoguin;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class Reservas_CheckIn_New extends javax.swing.JFrame {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Reservas_CheckIn_New.class);
    private static String userLogin;
    private static HotelRoom dataRoom;
    private static Usuario clientBooking;
    private Reservas_CheckIn formularioPadre;
    private double totalBooking = 0;
    private Integer totalDays;

    /**
     * Creates new form Reservas_CheckIn_New
     */
    public Reservas_CheckIn_New(String userLogin, String text, HotelRoom dataRoom, Reservas_CheckIn formularioPadre) {
        initComponents();
        this.userLogin = userLogin;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lblTextHabitacion.setText(text);
        jCalendarStart.setMinSelectableDate(new Date());
        jCalendarEnd.setMinSelectableDate(jCalendarStart.getDate());
        this.dataRoom = dataRoom;
        this.formularioPadre = formularioPadre;
        btnReservar.setEnabled(false);
        jCalendarStart.setEnabled(false);
        jCalendarEnd.setEnabled(false);
        lblDias.setText(formatCurrency(0D));
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
        jCalendarStart = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        jCalendarEnd = new com.toedter.calendar.JCalendar();
        lblClientEncontrado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        btnNewClient = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        lblTextHabitacion = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        spinerNinos = new javax.swing.JSpinner();
        spinerAdultos = new javax.swing.JSpinner();
        txtPIN = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnReservar = new javax.swing.JButton();
        lblDias = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Reservar Habitación");

        jCalendarStart.setDate(new java.util.Date(1749932835000L));
        jCalendarStart.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jCalendarStart.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jCalendarStartInputMethodTextChanged(evt);
            }
        });
        jCalendarStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarStartPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Fecha de Inicio");

        jCalendarEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarEndPropertyChange(evt);
            }
        });

        lblClientEncontrado.setBackground(new java.awt.Color(204, 255, 0));
        lblClientEncontrado.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblClientEncontrado.setText("------------");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Fecha Fin");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Cliente/NumeroDocumento");

        txtNumDoc.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtNumDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDocActionPerformed(evt);
            }
        });
        txtNumDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumDocKeyTyped(evt);
            }
        });

        btnNewClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new.png"))); // NOI18N
        btnNewClient.setToolTipText("Nuevo Cliente");
        btnNewClient.setDisabledIcon(null);
        btnNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewClientActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        btnSearch.setToolTipText("Buscar");
        btnSearch.setDisabledIcon(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblTextHabitacion.setBackground(new java.awt.Color(204, 255, 0));
        lblTextHabitacion.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblTextHabitacion.setText("txt");

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear.png"))); // NOI18N
        btnLimpiar.setToolTipText("Nuevo Cliente");
        btnLimpiar.setDisabledIcon(null);
        btnLimpiar.setEnabled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel3.setText("Niños");

        jLabel6.setText("Adultos");

        jLabel7.setText("Email");

        jLabel8.setText("Celular");

        jLabel9.setText("PIN CODE");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel10.setText("Comentario");

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane1.setViewportView(txtComentario);

        spinerAdultos.setValue(1);

        txtPIN.setEnabled(false);
        txtPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPINActionPerformed(evt);
            }
        });

        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnReservar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        lblDias.setBackground(new java.awt.Color(0, 255, 204));
        lblDias.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblDias.setForeground(new java.awt.Color(0, 0, 0));
        lblDias.setText("0");

        jLabel12.setText("DIAS");

        jLabel13.setText("TOTAL");

        lblTotal.setBackground(new java.awt.Color(0, 255, 204));
        lblTotal.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(lblTextHabitacion)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewClient)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(114, 114, 114))
                                            .addComponent(jCalendarStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCalendarEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)))
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblClientEncontrado)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblDias)
                                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(spinerAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(16, 16, 16))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(spinerNinos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnReservar)
                                        .addContainerGap())))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblTextHabitacion))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpiar)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCalendarEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCalendarStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnNewClient)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblClientEncontrado)
                                .addGap(54, 54, 54)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(spinerNinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(spinerAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDias)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lblTotal))
                        .addGap(23, 23, 23)
                        .addComponent(btnReservar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCalendarStartInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jCalendarStartInputMethodTextChanged

    }//GEN-LAST:event_jCalendarStartInputMethodTextChanged

    private void jCalendarStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarStartPropertyChange
        // TODO add your handling code here:
        // TODO add your handling code here:
        Date date = jCalendarStart.getDate();
        jCalendarEnd.setMinSelectableDate(date);
        jCalendarEnd.setDate(date);
        int milisecondsByDay = 86400000;
        totalDays = (int) ((jCalendarStart.getDate().getTime() - jCalendarEnd.getDate().getTime()) / milisecondsByDay) + 1;
        lblDias.setText(String.valueOf(totalDays));
        if (dataRoom != null) {
            if (totalDays > 0) {
                totalBooking = totalDays * dataRoom.getPricePerNight();
            }
        }
        lblTotal.setText("S/." + String.valueOf(totalBooking));
    }//GEN-LAST:event_jCalendarStartPropertyChange

    private void txtNumDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDocActionPerformed
        // TODO add your handling code here:
        if (txtNumDoc.getText().isEmpty()) {
            DialogUtils.showError(null, "Validación", "Ingresa el numero de documento valido");
            return;
        }
        searchDocument(txtNumDoc.getText());
    }//GEN-LAST:event_txtNumDocActionPerformed

    public void searchDocument(String txtDocumentNumber) {
        Usuario userSearch;
        UsuarioService usuarioService = new UsuarioService();
        try {

            userSearch = usuarioService.findOnlyClients(txtNumDoc.getText());
            if (userSearch == null) {
                DialogUtils.showInfo(null, "Busqueda", "No se encontro al cliente");
                return;
            }
            clientBooking = userSearch;

            lblClientEncontrado.setText(userSearch.getFullName());
            txtNumDoc.setEnabled(false);
            btnSearch.setEnabled(false);
            btnNewClient.setEnabled(false);
            btnLimpiar.setEnabled(true);
            btnReservar.setEnabled(true);
            txtEmail.setText(userSearch.getEmail());
            txtCelular.setText(userSearch.getPhone());
            jCalendarStart.setEnabled(true);
            jCalendarStart.setMinSelectableDate(new Date());
            jCalendarEnd.setEnabled(true);
            jCalendarEnd.setMinSelectableDate(new Date());
            txtPIN.setText(String.valueOf(dataRoom.getRoomNumber()) + String.valueOf(Constants.getRandomNumber()));
            lblDias.setText("0");
            lblTotal.setText("S/ 0.00");
        } catch (Exception ex) {
            Logger.getLogger(Reservas_CheckIn_New.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (txtNumDoc.getText().isEmpty()) {
            DialogUtils.showError(null, "Validación", "Ingresa el numero de documento valido");
            return;
        }
        searchDocument(txtNumDoc.getText());
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        clientBooking = null;
        lblClientEncontrado.setText("----------");
        txtNumDoc.setEnabled(true);
        txtNumDoc.setText("");
        btnSearch.setEnabled(true);
        btnNewClient.setEnabled(true);
        btnLimpiar.setEnabled(false);
        btnReservar.setEnabled(false);
        txtEmail.setText("");
        txtCelular.setText("");
        txtComentario.setText("");
        jCalendarStart.setEnabled(false);
        jCalendarEnd.setEnabled(false);
        lblDias.setText("0");
        lblTotal.setText("S/ 0.00");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPINActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed

        try {
            validateRequestBooking();
            Booking booking = new Booking();
            booking.setHotelRoom(dataRoom);
            booking.setUserId(clientBooking.getId());
            booking.setDocumentNumber(clientBooking.getDocumentNumber());
            booking.setFullName(clientBooking.getFullName());
            booking.setCheckOut(jCalendarEnd.getDate());
            booking.setCheckIn(jCalendarStart.getDate());
            booking.setPinCode(Integer.valueOf(txtPIN.getText()));
            booking.setChildrens(Integer.valueOf(spinerNinos.getValue().toString()));
            booking.setAdults(Integer.valueOf(spinerAdultos.getValue().toString()));
            booking.setPhone(txtCelular.getText());
            booking.setEmail(txtEmail.getText());
            booking.setComments(txtComentario.getText());
            booking.setTotal(totalBooking);
            booking.setTotalNights(totalDays);
            booking.setCreated_by(userLogin);
            BookingService service = new BookingService();
            service.saveBooking(booking);
            //TODO Refresh
            formularioPadre.refresh();
            this.dispose();
        } catch (Exception ex) {
            DialogUtils.showError(this, "Error", ex.getMessage());
            Logger.getLogger(Reservas_CheckIn_New.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReservarActionPerformed

    private void jCalendarEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarEndPropertyChange
        // TODO add your handling code here:
        int milisecondsByDay = 86400000;
        totalDays = (int) ((jCalendarEnd.getDate().getTime() - jCalendarStart.getDate().getTime()) / milisecondsByDay) + 1;
        lblDias.setText(String.valueOf(totalDays));
        if (dataRoom != null) {
            if (totalDays > 0) {
                totalBooking = totalDays * dataRoom.getPricePerNight();
            }
        }
        lblTotal.setText("S/." + String.valueOf(totalBooking));
    }//GEN-LAST:event_jCalendarEndPropertyChange

    private void txtNumDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignora el carácter
        }
    }//GEN-LAST:event_txtNumDocKeyTyped

    private void btnNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewClientActionPerformed
        // TODO add your handling code here:
            Clientes_Nuevo form = new Clientes_Nuevo(userLoguin);
        form.setVisible(true);
    }//GEN-LAST:event_btnNewClientActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservas_CheckIn_New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservas_CheckIn_New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservas_CheckIn_New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservas_CheckIn_New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservas_CheckIn_New(userLogin, "", null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNewClient;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JCalendar jCalendarEnd;
    private com.toedter.calendar.JCalendar jCalendarStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClientEncontrado;
    private javax.swing.JLabel lblDias;
    private javax.swing.JLabel lblTextHabitacion;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JSpinner spinerAdultos;
    private javax.swing.JSpinner spinerNinos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNumDoc;
    private javax.swing.JTextField txtPIN;
    // End of variables declaration//GEN-END:variables

    private void validateRequestBooking() {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(txtNumDoc.getText()), "DOI : Número de documento invalido");
        Integer totalPersons = Integer.valueOf(spinerNinos.getValue().toString()) + Integer.valueOf(spinerAdultos.getValue().toString());
        Preconditions.checkArgument(!(totalPersons <= 0), "AFORO : Cantidad minima debe ser mayor a 0");
    }

}
