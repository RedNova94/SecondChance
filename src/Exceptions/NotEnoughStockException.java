/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

/**
 *
 * @author Alberto Vásquez
 */
public class NotEnoughStockException extends Exception {

    /**
     * Creates a new instance of <code>NotEnoughStockException</code> without detail message.
     */
    public NotEnoughStockException() {
    }


    /**
     * Constructs an instance of <code>NotEnoughStockException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public NotEnoughStockException(String msg) {
        super(msg);
    }
}
