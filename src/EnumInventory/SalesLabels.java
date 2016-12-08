package EnumInventory;

/**
 *
 * @author Mariana Rocha
 */
public enum SalesLabels {

    PURCHASE_DATE("PurchaseDate"), SALE_TOTAL("SaleTotal"), 
    CUSTOMER_MONEY("CustomerMoney"), CHANGE("Change");
    
    private final String columName;

    SalesLabels(String columName) {
        this.columName = columName;
    }

    public String getColumName() {
        return columName;
    }
}
