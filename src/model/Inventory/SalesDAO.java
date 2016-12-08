package model.Inventory;

import EnumInventory.ProductsSoldCommands;
import EnumInventory.SalesCommands;
import EnumInventory.SalesLabels;
import model.Sales.Sale;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Mariana Rocha
 */
public class SalesDAO extends DAOGeneralizer {

    public void addNewSale(Sale sale) {
        try {
            openConnection();
            commandStatement = prepareQuery(SalesCommands.INSERT.getCommand());
            Date purchaseDate = new Date(sale.getPurchaseDate().getTimeInMillis());
            commandStatement.setDate(1, purchaseDate);
            commandStatement.setDouble(2, sale.getSaleTotal());
            commandStatement.setDouble(3, sale.getCustomerMoney());
            commandStatement.setDouble(4, sale.getChange());
            commandStatement.executeUpdate();
            
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    /**
     * . Search the sales of the day from the register.
     *
     * @return the sales of the day
     */
    public ArrayList<Sale> getTotalSalesFromToday() {
        ArrayList<Sale> itemsList = null;
        try {
            openConnection();
            commandStatement = prepareQuery(SalesCommands.SELECT_TOTAL_SALES.getCommand());
            ResultSet results = commandStatement.executeQuery();
            while (results.next()) {
                Sale actualSale = getNextSaleFromRegister(results);
                itemsList.add(actualSale);
            }
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        } finally {
            return itemsList;
        }
    }

    private Sale getNextSaleFromRegister(ResultSet result) throws SQLException {
            Date purchaseDate = result.getDate(SalesLabels.PURCHASE_DATE.getColumName());
            Calendar date = getCompleteDate(purchaseDate);
            double saleTotal = result.getDouble(SalesLabels.SALE_TOTAL.getColumName());
            double customerMoney = result.getDouble(SalesLabels.CUSTOMER_MONEY.getColumName());
            double change = result.getDouble(SalesLabels.CHANGE.getColumName());
            Dessert[] productsSold = getProductsSoldFromThisSale(purchaseDate);
            
            return new Sale(productsSold, date, saleTotal, customerMoney, change);
    }

    protected static Calendar getCompleteDate(Date purchaseDate) {
        Calendar completeDate = Calendar.getInstance();
        long previousDate = purchaseDate.getTime();
        completeDate.setTimeInMillis(previousDate);

        return completeDate;
    }

    private Dessert[] getProductsSoldFromThisSale(Date purchaseDate) throws SQLException {
        commandStatement = prepareQuery(ProductsSoldCommands.SELECT_PRODUCTS_SOLD.getCommand());
        commandStatement.setDate(1, purchaseDate);

        ResultSet results = commandStatement.executeQuery();
        Dessert[] dessertList = null;
        ArrayList<Dessert> productsList = new ArrayList<>();

        while (results.next()) {
            productsList.add(BakeryMenuDAO.getNexDessertFromMenu(results));
        }

        dessertList = new Dessert[productsList.size()];
        dessertList = productsList.toArray(dessertList);
        return dessertList;
    }
}
