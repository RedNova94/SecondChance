package model.Sales;

import model.Reports.Report;

/**
 *
 * @author Gerardo Hernández
 */

public class CashRegister {

    private static CashRegister instance;
    private Report currentReport;
    private double moneyInCashier;

    //Se tratará de un Singleton
    public CashRegister() {

        currentReport = new Report();
        moneyInCashier = 0;

    }

    //Getters and setters 
    public Report getCurrentReport() {
        return currentReport;
    }

    public void setCurrentReport(Report currentReport) {
        this.currentReport = currentReport;
    }

    public double getMoneyInCashier() {
        return moneyInCashier;
    }

    public void setMoneyInCashier(double moneyInCashier) {
        this.moneyInCashier = moneyInCashier;
    }

    //Check for Instance
    /*public static CashRegister getInstance() {

        if (instance == null) {
            instance = new CashRegister();
        }

        return instance;
    }
    */
}
