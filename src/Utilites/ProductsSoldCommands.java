package Utilites;

/**
 *
 * @author Mariana Rocha
 */
public enum ProductsSoldCommands {

    SELECT_PRODUCTS_SOLD("SELECT DessertName, [Desc], Price, Cost, stock "
            + "FROM ProductsSold p JOIN BakeryMenu b ON p.ProductIndex = b.DessertKey "
            + "JOIN Storage s ON b.DessertKey = s.DessertKey WHERE PurchaseDate = datetime('?');"),
    INSERT_PRODUCTS_SOLD("INSERT INTO ProductsSold (PurchaseDate,ProductKey)VALUES (?,?);");

    private final String command;

    ProductsSoldCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
