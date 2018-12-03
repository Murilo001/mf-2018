/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.murilo001.loinc.model.dao;
import com.github.murilo001.loinc.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class TableCoreDAO {
    
    public void create(String[] campos) {
        Connection con =  ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            String sqlId = "CREATE TABLE LOINC " +
                   "(" + campos[0] + " INTEGER not NULL, ";
            String sqlCampos = "";
            for (int i = 1; i < campos.length; i++) {
                 sqlCampos += campos[i] + " VARCHAR(255), ";
            }
            String sqlPrimaryKey =   " PRIMARY KEY ( " + campos[0] + " ))";
            String sql = sqlId + sqlCampos + sqlPrimaryKey;
            con.createStatement().executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Created table in given database...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
    
    
}
