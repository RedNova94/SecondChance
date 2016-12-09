package Utilites;

/**
 *
 * @author Mariana Rocha
 */
public enum BakeryMenuCommands {

    INSERT("INSERT INTO BakeryMenu (DessertName, DESCRIPTION,PRICE,COST) VALUES (?,?,?,?)"),
    DELETE("DELETE FROM BakeryMenu WHERE DessertKey= ?"),
    UPDATE_ATRIBUTES("UPDATE BakeryMenu SET DessertName, Description = ?, Cost = ?, Price = ? where DessertKey=?;"),
    SELECT("SELECT * FROM BakeryMenu b join Storage s on b.DessertKey=s.DessertKey;");

    private final String command;

    BakeryMenuCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
