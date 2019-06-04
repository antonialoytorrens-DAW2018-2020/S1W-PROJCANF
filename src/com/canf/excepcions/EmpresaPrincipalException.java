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
public class EmpresaPrincipalException extends Exception {

    /**
     * Creates a new instance of <code>EmpresaPrincipalException</code> without
     * detail message.
     */
    public EmpresaPrincipalException() {
    }

    /**
     * Constructs an instance of <code>EmpresaPrincipalException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmpresaPrincipalException(String msg) {
        super(msg);
    }
}
