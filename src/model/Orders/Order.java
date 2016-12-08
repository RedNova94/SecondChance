package model.Orders;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Alberto Vásquez
 */

public final class Order {

    private String customerName;
    private String description;
    private String telephone;
    private Calendar dueDate;
    private boolean deliveryStatus;
    private static String formatTime = "yyyy-MM-dd HH:mm:ss";

    public Order(String customerName, String description, Calendar dueDate, String telephone) {
        this.customerName = customerName;
        this.description = description;
        this.dueDate = dueDate;
        setDeliveryStatus(false);
        this.telephone=telephone;
    }

    public Order(String customerName, String description, Calendar dueDate, String telephone, boolean deliveryStatus) {
        this.customerName = customerName;
        this.description = description;
        this.dueDate = dueDate;
        this.deliveryStatus = deliveryStatus;
        this.telephone=telephone;
    }
    
    //Getters and Setters for fields

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public Calendar getDueDateAsCalendar() {
        return dueDate;
    }
    
    //Converts the date from Calendar to the format the Interface uses
    public String getDueDate(){
       SimpleDateFormat formatDate = new SimpleDateFormat(formatTime);
       String dateAsString = formatDate.format(dueDate.getTime());
       return dateAsString;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDelivered() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getTelephone() {
        return telephone;
    }
}
