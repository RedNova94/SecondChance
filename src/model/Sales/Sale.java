package model.Sales;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import model.Inventory.Dessert;

/**
 *
 * @author Gerardo Hernández
 */

public class Sale  {
    
    private Dessert[] productsSold;
    private Calendar purchaseDate;
    private double saleTotal;
    private double customerMoney;
    private double change;
    private static String formatTime = "yyyy-MM-dd HH:mm:ss";

    public Sale(Dessert[] products, double saleTotal, double customerMoney, double change) {
        this.purchaseDate = Calendar.getInstance();
        this.productsSold = products;
        this.saleTotal = saleTotal;
        this.customerMoney = customerMoney;
        this.change = change;
    }

    public Sale(Dessert[] productsSold, Calendar purchaseDate, double saleTotal, double customerMoney, double change) {
        this.productsSold = productsSold;
        this.purchaseDate = purchaseDate;
        this.saleTotal = saleTotal;
        this.customerMoney = customerMoney;
        this.change = change;
    }
    
    //Getters and Setters for fields

    public Dessert[] getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(Dessert[] productsSold) {
        this.productsSold = productsSold;
    }

    public Calendar getPurchaseDate() {
//        SimpleDateFormat formatDate = new SimpleDateFormat(formatTime);
//        String date = formatDate.format(purchaseDate.getTime());
//        return date;
        return purchaseDate;
    }

    public void setPurchaseDate(Calendar purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public double getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(double customerMoney) {
        this.customerMoney = customerMoney;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
    
    
}