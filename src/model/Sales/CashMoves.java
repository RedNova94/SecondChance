package model.Sales;

/**
 *
 * @author Gerardo Hernández
 */

public class CashMoves {

    private String reason;
    private double amount;

    public CashMoves(String reason, double amount) {
        this.reason = reason;
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public double getAmount() {
        return amount;
    }

}
