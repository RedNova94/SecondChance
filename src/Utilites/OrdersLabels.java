package Utilites;

/**
 *
 * @author Mariana Rocha
 */
public enum OrdersLabels {

    DUE_DATE("OrderDate"), CUSTOMER_NAME("CustomerName"), DELIVERY_STATUS("DeliveryStatus"),
    DESCRIPTION("Description"), ORDER_DESC("OrderDesc"), CUSTOMER_TEL("CustomerTel");

    private final String columName;

    OrdersLabels(String columName) {
        this.columName = columName;
    }

    public String getColumName() {
        return columName;
    }
}
