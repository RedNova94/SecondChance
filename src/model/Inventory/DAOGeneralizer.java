/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Inventory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Mariana Rocha
 */
public class DAOGeneralizer {

    ConnectionForInventory actualConnection = null;
    PreparedStatement commandStatement = null;
    private static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";

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
    
    public static Calendar setFormatDate(String date) throws ParseException{
       Calendar calendar=Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat(FORMAT_TIME);
        calendar.setTime(dateFormat.parse(date));
        return calendar;
    }
}
