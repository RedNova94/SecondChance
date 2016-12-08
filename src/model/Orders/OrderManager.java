package model.Orders;

import java.util.ArrayList;
import java.util.Calendar;
import model.Inventory.OrdersDAO;

/**
 *
 * @author Alberto Vásquez
 */

public class OrderManager {

    private OrdersDAO orderList = null;

    public OrderManager() {
        orderList = new OrdersDAO();
    }

    public void takeOrder(String customerName, String description, Calendar dueDate, String customerTelephone) {
        Order currentOrder = new Order(customerName, description, dueDate, customerTelephone);
        addOrderToReport(currentOrder);
    }

    private void addOrderToReport(Order order) {
        orderList.addNewOrder(order);
    }

    public void markOrderAsDone(Order order) {
        orderList.markThisOrderAsDone(order);
    }

    public void cancelOrder(Order order) {
        orderList.deleteOrder(order);
    }

    public ArrayList<Order> searchOrdersUndelivered() {
        return orderList.getTotalOrdersUndelivered();
    }
}
