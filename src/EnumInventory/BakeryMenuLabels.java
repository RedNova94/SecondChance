package EnumInventory;

/**
 *
 * @author Mariana Rocha
 */
public enum BakeryMenuLabels {

    NAME("DessertName"), DESCRIPTION("Description"), COST("Cost"), PRICE("Price");

    private final String columName;

    BakeryMenuLabels(String columName) {
        this.columName = columName;
    }

    public String getColumName() {
        return columName;
    }
}
