/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.repository;

import com.ande.luxury.hotelapp.database.databaseConnection;
import com.ande.luxury.hotelapp.entities.Usuario;
import com.ande.luxury.hotelapp.entities.UsuarioRol;
import com.ande.luxury.hotelapp.utilsdb.BaseDAO;
import com.ande.luxury.hotelapp.utilsdb.Constants;
import com.ande.luxury.hotelapp.utilsdb.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bryanvislaochavez
 */
public class UsuarioRolDAO extends BaseDAO<UsuarioRol> {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioRolDAO.class);

    public UsuarioRolDAO() {
        super("hotel.users_role", new RowMapper<UsuarioRol>() {
            @Override
            public UsuarioRol map(ResultSet rs) throws SQLException {
                return new UsuarioRol(
                        rs.getInt("id"),
                        rs.getString("uuid"),
                        rs.getInt("user_id"),
                        rs.getInt("rol_id"),
                        rs.getInt("active")
                );
            }
        });
    }

    public List<UsuarioRol> findRolesByUsuario(String uuid) throws Exception {
        UsuarioDAO userDAO = new UsuarioDAO();
        List<UsuarioRol> listRoles = this.findAll();
        Usuario usuario = userDAO.findByUuid(uuid);
        if (usuario != null) {
            return listRoles.stream().filter(x -> x.getUser_id().equals(usuario.getId())).toList();
        }
        return null;
    }

    private String queryInsert = "INSERT INTO hotel.users_role (uuid, user_id, rol_id, active, created_by, created_at) "
            + " values(?,?,?,?,?,?);";

    public UsuarioRol save(UsuarioRol usuarioRol) throws Exception {

        String uuid = Constants.generateUuid();
        usuarioRol.setUuid(uuid); // Asigna el UUID generado al objeto
        usuarioRol.setActive(Constants.EntityActive.ACTIVO.getValue());

        try (Connection conn = databaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, uuid);
            stmt.setInt(2, usuarioRol.getUser_id()); // user_id
            stmt.setInt(3, usuarioRol.getRol_id()); // rol_id
            stmt.setInt(4, usuarioRol.getActive()); // active
            stmt.setString(5, usuarioRol.getCreated_by()); // created_by
            stmt.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
            stmt.execute();
            conn.close();
            return usuarioRol;
        } catch (Exception ex) {
            logger.error("Error UsuarioRol -> save => " + ex.getMessage());
            throw new Exception("Ocurrio un error al querer insertar.");
        } finally {
            return usuarioRol;
        }
    }

}
