package Utilites;

/**
 *
 * @author Mariana Rocha
 */
public enum SalesCommands {

    INSERT("INSERT INTO Sales(PurchaseDate, SaleTotal, CustomerMoney, Change) VALUES (?,?,?,?)"),
    SELECT_TOTAL_SALES("SELECT * FROM SALES WHERE DATETIME(PurchaseDate)=DATETIME('NOW');");

    private final String command;

    SalesCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
