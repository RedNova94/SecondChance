package Utilites;

/**
 *
 * @author Mariana Rocha
 */
public enum StorageCommands {

    INSERT("INSERT INTO Storage (DessertKey, Stock) VALUES (?,?);"),
    SELECT_STOCK("SELECT * FROM Storage WHERE DESSERTKey=?;"),
    REMOVE_AMOUNT("UPDATE Storage SET Stock=Stock-? WHERE DessertKey=?;"),
    SELECT_DESSERT_AND_STOCK("SELECT * FROM BakeryMenu JOIN Storage WHERE "
            + "(BakeryMenu.DessertKey = STORAGE.DessertKey);");

    private final String command;

    StorageCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
