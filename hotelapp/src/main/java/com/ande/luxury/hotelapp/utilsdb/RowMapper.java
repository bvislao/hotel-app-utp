/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ande.luxury.hotelapp.utilsdb;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bryanvislaochavez
 */
public interface RowMapper<T> {
    T map(ResultSet rs) throws SQLException;
}
