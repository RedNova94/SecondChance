package model;

import java.util.ArrayList;
import model.Inventory.Dessert;
import model.Inventory.BakeryMenuDAO;

/**
 *
 * @author Alberto Vásquez
 */

public class BakeryOwner {

    private BakeryMenuDAO productList = null;

    public BakeryOwner() {
        productList = new BakeryMenuDAO();
    }

    public void createNewDessert(String name, String description, double price, double cost, int stock) {
        Dessert newDessert = new Dessert(name, description, price, cost, stock);
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
