/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Reports;

import model.Sales.Sale;
import model.Sales.CashMoves;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Gerardo Hernández
 */

public class Report {

    private ArrayList<Sale> sales;
    private Calendar date;
    private ArrayList<CashMoves> cashRegMoves;

    public Report() {
        this.sales = new ArrayList<Sale>();
        this.date = Calendar.getInstance();
    }

    public Report(ArrayList<Sale> sales) {
        this.sales = new ArrayList<Sale>();
        this.date = Calendar.getInstance();
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public ArrayList<CashMoves> getCashRegMoves(){
        return cashRegMoves;
    }
    
    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
    
    public void displayReport() {
        System.out.println("Reporte del " + date.getTime() + "\n ");
        for (int salesIndex = 0; salesIndex < sales.size(); salesIndex++) {

            sales.get(salesIndex).toString();

        }
    }

    


}
