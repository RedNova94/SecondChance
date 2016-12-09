/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mariana Rocha
 */
public class DAOGeneralizer {

    ConnectionForInventory actualConnection = null;
    PreparedStatement commandStatement = null;

    public void openConnection() {
        actualConnection = new ConnectionForInventory();
        actualConnection.openConnection();
    }

    public void closeConnection() throws SQLException {
        commandStatement.close();
        actualConnection.closeConnection();
    }

    public PreparedStatement prepareQuery(String command) throws SQLException {
        return actualConnection.getConnection().prepareStatement(command);
    }
}
