package model.Inventory;

import Utilites.StorageCommands;
import Utilites.StorageLabels;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mariana Rocha
 */
public class StorageDAO extends DAOGeneralizer {

    public static void main(String[] args) {
        StorageDAO dao= new StorageDAO();
        dao.addDessertToStorage(4, 3);
    }
    
//add joptionpane after create menu to add stock
    public void addDessertToStorage(int dessertKey, int amount) {
        try {
            openConnection();
            commandStatement = prepareQuery(StorageCommands.INSERT.getCommand());
            commandStatement.setInt(1, dessertKey);
            commandStatement.setInt(2, amount);
            commandStatement.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public int getStockFromThisDessert(int dessertKey) {
        int stock = -1;
        try {
            openConnection();
            commandStatement = prepareQuery(StorageCommands.SELECT_STOCK.getCommand());
            commandStatement.setInt(1, dessertKey);
            ResultSet results = commandStatement.executeQuery();
            while (results.next()) {
                stock = results.getInt(StorageLabels.STOCK.getColumName());
            }
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        } finally {
            return stock;
        }
    }

    public void removeStockFromDessert(int dessertKey, int amount) {
        try {
            openConnection();
            commandStatement = prepareQuery(StorageCommands.REMOVE_AMOUNT.getCommand());
            commandStatement.setInt(1, amount);
            commandStatement.setInt(2, dessertKey);
            
            commandStatement.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public ArrayList<Dessert> getTotalProducts() {
        ArrayList<Dessert> itemsList = new ArrayList<>();
        try {
            openConnection();
            commandStatement = prepareQuery(StorageCommands.SELECT_DESSERT_AND_STOCK.getCommand());
            ResultSet results = commandStatement.executeQuery();
            while (results.next()) {
                itemsList.add(BakeryMenuDAO.getNexDessertFromMenu(results));
            }
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        } finally {
            return itemsList;
        }
    }
}
