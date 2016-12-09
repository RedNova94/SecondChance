package model.Inventory;

import EnumInventory.BakeryMenuCommands;
import EnumInventory.BakeryMenuLabels;
import EnumInventory.StorageLabels;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mariana Rocha
 */
public class BakeryMenuDAO extends DAOGeneralizer {

    public void addDessertToMenu(Dessert dessert) {
        try {
            openConnection();
            commandStatement = prepareQuery(BakeryMenuCommands.INSERT.getCommand());
            commandStatement.setString(1, dessert.getName());
            commandStatement.setString(2, dessert.getDescription());
            commandStatement.setDouble(3, dessert.getPrice());
            commandStatement.setDouble(4, dessert.getCost());
            commandStatement.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    //how the cashier get the key?
    //works with key...
    public void removeDessertFromMenu(int dessertKey) {
        try {
            openConnection();
            commandStatement = actualConnection.getConnection().prepareStatement(BakeryMenuCommands.DELETE.getCommand());
            commandStatement.setInt(1, dessertKey);
            commandStatement.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public ArrayList<Dessert> getDesserstFromMenu() {
        ArrayList<Dessert> dessertList = new ArrayList<>();
        try {
            openConnection();
            commandStatement = actualConnection.getConnection().prepareStatement(BakeryMenuCommands.SELECT.getCommand());
            ResultSet results = commandStatement.executeQuery();
            while (results.next()) {
                dessertList.add(getNexDessertFromMenu(results));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        } finally {
            return dessertList;
        }
    }

    protected static Dessert getNexDessertFromMenu(ResultSet results) throws SQLException {
        String name = results.getString(BakeryMenuLabels.NAME.getColumName());
        String description = results.getString(BakeryMenuLabels.DESCRIPTION.getColumName());
        double cost = results.getDouble(BakeryMenuLabels.COST.getColumName());
        double price = results.getDouble(BakeryMenuLabels.PRICE.getColumName());
        int stock = results.getInt(StorageLabels.STOCK.getColumName());
        return new Dessert(name, description, price, cost, stock);
    }
}
