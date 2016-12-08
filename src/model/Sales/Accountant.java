/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Sales;

import model.Sales.Sale;
import java.util.ArrayList;
import model.Inventory.Dessert;
import model.Reports.Report;
import model.Sales.Sale;

/**
 *
 * @author Gerardo Hernández
 */

public class Accountant {
    
    private Report reportToWork;

    public Accountant(Report reportToWork) {
        this.reportToWork = reportToWork;
        
    }

    public double getEarnings() {
        double earnings = 0;
        
        double totalSales = obtainTotalSales(reportToWork.getSales());
        double totalCost = obtainTotalCosts(reportToWork.getSales());
        
        earnings = totalSales - totalCost;
        
        return earnings;
        
    }
    
    public double obtainTotalSales(ArrayList<Sale> sales){
        double totalSales = 0;
        int numberOfSales = sales.size();
        
        for (int salesIndex = 0; salesIndex < numberOfSales ; salesIndex++) {
            totalSales += sales.get(salesIndex).getSaleTotal();
           
        }
        
        return totalSales;
    }
    
    public double obtainASaleCost(Sale sale){
        double saleCost = 0;
        
        Dessert[] products = sale.getProductsSold();
        
        for (int productsIndex = 0; productsIndex < products.length; productsIndex++) {
            saleCost += products[ productsIndex ].getCost();
        }
        
        return saleCost;
    }
    
    public double obtainTotalCosts(ArrayList<Sale> sales) {
        double totalSales = 0;
        int numberOfSales = sales.size();
        
        for (int salesIndex = 0; salesIndex < numberOfSales ; salesIndex++) {
            totalSales += obtainASaleCost(sales.get(salesIndex));
           
        }
        
        return totalSales;
    }
}
