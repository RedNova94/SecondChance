package model.Inventory;

import Utilites.OrdersCommands;
import Utilites.OrdersLabels;
import model.Orders.Order;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Mariana Rocha
 */
public class OrdersDAO extends DAOGeneralizer {

    public static void main(String[] args) {
        Order o= new Order("Mariana", "Pastel de Bodas $600",Calendar.getInstance(), "999999999");
        OrdersDAO dao = new OrdersDAO();
        dao.addNewOrder(o);
        System.out.println("Orden añadida");
    }
    
    public void addNewOrder(Order order) {
        try {
            openConnection();
            commandStatement = prepareQuery(OrdersCommands.INSERT.getCommand());
            commandStatement.setString(1, order.getDueDate());
            commandStatement.setString(2, order.getDescription());
            commandStatement.setString(3, order.getCustomerName());
            commandStatement.setString(4, order.getTelephone());
            commandStatement.setBoolean(5, order.isDelivered());
            commandStatement.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public ArrayList<Order> getTotalOrdersUndelivered() {
        ArrayList<Order> itemsList = new ArrayList<>();
        try {
            openConnection();
            commandStatement = prepareQuery(OrdersCommands.SELECT_ORDERS_UNDELIVERED.getCommand());
            ResultSet results = commandStatement.executeQuery();
            while (results.next()) {
                itemsList.add(getNextOrderFromRegister(results));
            }
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        } finally {
            return itemsList;
        }
    }

    private Order getNextOrderFromRegister(ResultSet results) throws SQLException {
        Date dueDate = results.getDate(OrdersLabels.DUE_DATE.getColumName());
        Calendar correctDate = SalesDAO.getCompleteDate(dueDate);
        String customerName = results.getString(OrdersLabels.CUSTOMER_NAME.getColumName());
        boolean deliveryStatus = results.getBoolean(OrdersLabels.DELIVERY_STATUS.getColumName());
        String description = results.getString(OrdersLabels.DESCRIPTION.getColumName());
        String telephone = results.getString(OrdersLabels.CUSTOMER_TEL.getColumName());

        return new Order(customerName, description, correctDate, telephone, deliveryStatus);
    }

   /**
     * Sets the order as finished on the register.
     *
     * @param order the order to add
     * @param orderNumber
     */
    public void markThisOrderAsDone(Order order) {
        try {
            openConnection();
            commandStatement = prepareQuery(OrdersCommands.UPDATE_ORDER_STATUS.getCommand());
            commandStatement.setBoolean(1, true);
            commandStatement.setString(2, order.getDueDate());
            commandStatement.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    public void deleteOrder(Order order) {
        try {
            openConnection();
            commandStatement = prepareQuery(OrdersCommands.DELETE_ORDER.getCommand());
            Date dueDate = new Date(order.getDueDateAsCalendar().getTimeInMillis());
            commandStatement.setDate(1, dueDate);
            commandStatement.setString(2, order.getCustomerName());
            commandStatement.setBoolean(3, order.isDelivered());
            commandStatement.setString(4, order.getDescription());
            commandStatement.executeUpdate();
            closeConnection();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }

    }
}
