/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.excepcions;

/**
 *
 * @author antonialoy
 */
public class MagatzemException extends Exception {

    /**
     * Creates a new instance of <code>MagatzemException</code> without detail
     * message.
     */
    public MagatzemException() {
    }

    /**
     * Constructs an instance of <code>MagatzemException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MagatzemException(String msg) {
        super(msg);
    }
}
