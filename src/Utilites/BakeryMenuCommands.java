package Utilites;

/**
 *
 * @author Mariana Rocha
 */
public enum BakeryMenuCommands {

    INSERT("INSERT INTO BakeryMenu (DessertName, DESCRIPTION,PRICE,COST) VALUES (?,?,?,?)"),
    DELETE("DELETE FROM BakeryMenu WHERE DessertKey= ?"),
    UPDATE_ATRIBUTES("UPDATE BakeryMenu SET DessertName, Description = ?, Cost = ?, Price = ? where DessertKey=?;"),
    SELECT("SELECT * FROM BakeryMenu b join Storage s on b.DessertKey=s.DessertKey;"),
    SELECT_KEY_PRODUCT("SELECT DessertKey FROM BakeryMenu WHERE DessertName=? AND Description=?;");

    private final String command;

    BakeryMenuCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
