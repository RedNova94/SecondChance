package EnumInventory;

/**
 *
 * @author Mariana Rocha
 */
public enum OrdersCommands {

    INSERT("INSERT INTO Orders(OrderDate, Description, CustomerName, CustomerTel, DeliveryStatus) VALUES (?,?,?,?,?)"),
    SELECT_ORDERS_UNDELIVERED("SELECT * FROM ORDERS WHERE not DeliveryStatus;"),
    UPDATE_ORDER_STATUS("UPDATE Orders SET DeliveryStatus = ? WHERE OrderDate = ?;"),
    DELETE_ORDER("DELETE FROM Orders WHERE OrderDate = ? AND CustomerName = ? AND DeliveryStatus = ? AND Description = ?;");

    private final String command;

    OrdersCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
