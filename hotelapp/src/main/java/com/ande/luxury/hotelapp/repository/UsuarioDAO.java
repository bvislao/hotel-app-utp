/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.Usuario;
import com.ande.luxury.hotelapp.services.UsuarioService;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.Constants;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import com.ande.luxury.hotelapp.utilsdb.Seguridad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class UsuarioDAO extends BaseDAO<Usuario> {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioDAO.class);

    public UsuarioDAO() {
        super("hotel.users", new RowMapper<Usuario>() {
            @Override
            public Usuario map(ResultSet rs) throws SQLException {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getString("document_number"),
                        rs.getString("full_name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("status_id")
                );
            }
        });
    }

    private String queryInsert = "INSERT INTO hotel.users (uuid, document_number, full_name, phone, email, password, status_id, active, created_by,"
            + "                         created_at) values(?,?,?,?,?,?,?,?,?,?);";

    public Usuario getDataUser(String username) throws Exception {
        Usuario user = this.findUserByUsername(username);
        if (user == null) {
            throw new Exception("Ocurrio un error al querer insertar.");
        }
        return user;
    }

    public boolean validateAutenticate(String username, String password) throws Exception {
        Usuario user = this.findUserByUsername(username);
        if (user != null) {
            if (Seguridad.decrypt(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Usuario saveUsuario(Usuario usuario) throws Exception {
        validateSaveUsuario(usuario);

        String uuid = Constants.generateUuid();
        usuario.setUuid(uuid); // Asigna el UUID generado al objeto
        String encryptPassword = Seguridad.encrypt(usuario.getPassword().trim());
        usuario.setPassword(encryptPassword);
        usuario.setStatus(Constants.EntityStatus.ACTIVO.getValue());
        usuario.setActive(Constants.EntityActive.ACTIVO.getValue());

        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, uuid);
            stmt.setString(2, usuario.getDocumentNumber()); // document_number
            stmt.setString(3, usuario.getFullName()); // full_name
            stmt.setString(4, usuario.getPhone()); // phone
            stmt.setString(5, usuario.getEmail()); // email
            stmt.setString(6, usuario.getPassword()); // password
            stmt.setInt(7, usuario.getStatus()); // status_id
            stmt.setInt(8, usuario.getActive()); // active
            stmt.setString(9, usuario.getCreated_by()); // created_by
            stmt.setDate(10, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stmt.executeUpdate();
            // 🔑 Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId(generatedKeys.getInt(1)); 
                }
            }
            conn.close();
            
            return usuario;
        } catch (Exception ex) {
            logger.error("Error saveUsuario => " + ex.getMessage());
            throw new Exception("Ocurrio un error al querer insertar.");
        } finally {
            return usuario;
        }
    }

    public void validateSaveUsuario(Usuario usuario) throws Exception {
        if (usuario.getDocumentNumber().isBlank() || usuario.getDocumentNumber().isEmpty()) {
            throw new Exception("Número de documento no válido.");
        }
        if (usuario.getEmail().isEmpty()) {
            throw new Exception("Número de documento no válido.");

        }

    }

}
