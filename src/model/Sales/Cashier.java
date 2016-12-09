/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Sales;

import model.Sales.CashMoves;
import model.Sales.CashRegister;
import Exceptions.InsufficientAmountException;
import Exceptions.NotEnoughStockException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Inventory.Dessert;
import model.Inventory.StorageDAO;
import model.Inventory.SalesDAO;

/**
 *
 * @author Gerry
 */
public class Cashier {

    private CashRegister cashReg;
    private SalesDAO historicalSales;
    private StorageDAO inventory;
    private static final int PRODUCT_UNIT = 1;

    public Cashier(CashRegister cashReg) { // **** IMPLEMENTAR SINGLETON
        this.cashReg = cashReg;
        historicalSales = new SalesDAO();
        this.inventory = new StorageDAO();
    }

    public CashRegister getCashReg() {
        return cashReg;
    }
    
    public void sellDesserts(ArrayList<Dessert> buyerList, double amountPaid){
        Dessert[] dessertList = new Dessert[buyerList.size()];
        dessertList = buyerList.toArray(dessertList);
        try {
            double saleTotal = obtainTotalPrice(dessertList);
            double customerMoney = receivePayment(saleTotal,amountPaid);
            double change = calcChange(saleTotal, customerMoney);

            Sale sale = new Sale(dessertList, saleTotal, customerMoney, change);

            depositMoney(sale.getSaleTotal());
            removeTheDessertsFromInventory(dessertList);
            
            addSaleToSaleHistory(sale);
        } catch (InsufficientAmountException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        } 
    }
    
    public double receivePayment(double totalToPay, double customerMoney) throws InsufficientAmountException {
        double amountPaid = customerMoney;
        

        if (amountPaid >= totalToPay) {
            return amountPaid;
        } else {
            String reason = "Introduzca una cantidad mayor o igual al total a pagar";
            throw new InsufficientAmountException(reason);
        }
    }

    public double obtainTotalPrice(Dessert[] buyList) {
        double total = 0;
        for (int productIndex = 0; productIndex < buyList.length; productIndex++) {
            total += buyList[productIndex].getPrice();
        }
        return total;
    }

    public void depositMoney(double amount, String reason) {
        this.cashReg.setMoneyInCashier(cashReg.getMoneyInCashier() + amount);

        addCashMove(reason, 0 - amount);

    }

    public void depositMoney(double amount) {
        this.cashReg.setMoneyInCashier(cashReg.getMoneyInCashier() + amount);

    }

    public void withdrawMoney(double amount, String reason) {
        this.cashReg.setMoneyInCashier(cashReg.getMoneyInCashier() - amount);
        addCashMove(reason, 0 - amount);

    }

    public void addCashMove(String reason, double amountMoney) {
        this.cashReg.getCurrentReport().getCashRegMoves().add(new CashMoves(reason, amountMoney));

    }

    public double calcChange(double totalToPay, double custmerAmount) {
        double change = 0;
        change = totalToPay - custmerAmount;
        return change;
    }

    private void removeDessertFromInventory(Dessert dessert)  {
        inventory.removeStockFromDessert(dessert, PRODUCT_UNIT);
    }

    public void addSaleToSaleHistory(Sale sale) {
        historicalSales.addNewSale(sale);
    }
    
    public ArrayList<Dessert> retrieveMenuWithStock(){
        return inventory.getTotalProducts();
    
    }
    
    public void addDessertToBuyerList(ArrayList buyerList, Dessert newDessert){
        buyerList.add(newDessert);
    }

    private void removeTheDessertsFromInventory(Dessert[] dessertList) {
        for (int listIndex = 0; listIndex < dessertList.length; listIndex++) {
            removeDessertFromInventory(dessertList[ listIndex ]);
        }
    }
    
    
}
