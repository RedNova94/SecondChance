package EnumInventory;

/**
 *
 * @author Mariana Rocha
 */
public enum StorageLabels {
DESSERT_KEY("DessertKey"), STOCK("Stock");

private final String columName;

    StorageLabels(String columName) {
        this.columName = columName;
    }

    public String getColumName() {
        return columName;
    }
}
