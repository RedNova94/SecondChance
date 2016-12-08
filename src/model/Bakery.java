package model;


import model.Inventory.Baker;
import model.BakeryOwner;
import model.Orders.OrderManager;
import model.Sales.CashRegister;
import model.Sales.Cashier;

/**
 *
 * @author Alberto Vásquez
 */
public class Bakery {
    private static Bakery instance;
    private Cashier cashier;
    private OrderManager orderManager;
    private Baker baker;
    private BakeryOwner bakeryOwner;
   
    
    
    private Bakery(){
        this.cashier = new Cashier(new CashRegister());
        this.orderManager = new OrderManager();
        this.baker = new Baker();
        this.bakeryOwner = new BakeryOwner();
    }
    
    public static Bakery getInstance(){
        if(instance == null){
            instance = new Bakery();
        }
        
        return instance;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }

    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public Baker getBaker() {
        return baker;
    }

    public void setBaker(Baker baker) {
        this.baker = baker;
    }

    public BakeryOwner getBakeryOwner() {
        return bakeryOwner;
    }

    public void setBakeryOwner(BakeryOwner bakeryOwner) {
        this.bakeryOwner = bakeryOwner;
    }
    
    
    
    
}
