package model.Inventory;

/**
 *
 * @author Alberto Vásquez
 */

public class Dessert {

    private String name;
    private String description;
    private double price;
    private double cost;
    private int stock;

    public Dessert(String name, String description, double price, double cost, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.cost = cost;
    }
    
    //Getters and Setters for fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
