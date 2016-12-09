package model;

import java.util.ArrayList;
import model.Inventory.Dessert;
import model.Inventory.BakeryMenuDAO;
import model.Inventory.StorageDAO;

/**
 *
 * @author Alberto Vásquez
 */

public class BakeryOwner {

    private BakeryMenuDAO productList = null;
    private StorageDAO stockList = null;

    public BakeryOwner() {
        productList = new BakeryMenuDAO();
        stockList = new StorageDAO();
    }

    public void createNewDessert(String name, String description, double price, double cost) {
        Dessert newDessert = new Dessert(name, description, price, cost);
        addNewDessertToMenu(newDessert);
    }

    public void addNewDessertToMenu(Dessert currentDessert) {
        productList.addDessertToMenu(currentDessert);
        
        
    }

    public void removeDessertFromMenu(int productKey) {
        productList.removeDessertFromMenu(productKey);
    }

    public ArrayList<Dessert> seeDessertFromMenu() {
        return productList.getDesserstFromMenu();
    }
}
