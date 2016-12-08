/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mariana Rocha
 */
public class ConnectionForInventory {

    private Connection actualConnection;

    public void openConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            actualConnection = DriverManager.getConnection("jdbc:sqlite:BakeryDB.db");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return actualConnection;
    }

    public void closeConnection() {
        try {
            actualConnection.close();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }
}
