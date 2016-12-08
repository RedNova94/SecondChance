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
public class InsufficientAmountException extends Exception {

    /**
     * Creates a new instance of <code>InsufficientAmountException</code> without detail message.
     */
    public InsufficientAmountException() {
    }


    /**
     * Constructs an instance of <code>InsufficientAmountException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InsufficientAmountException(String msg) {
        super(msg);
    }
}
