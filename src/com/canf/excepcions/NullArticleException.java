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
public class NullArticleException extends Exception {

    /**
     * Creates a new instance of <code>ArticleInexistentException</code> without
     * detail message.
     */
    public NullArticleException() {
    }

    /**
     * Constructs an instance of <code>ArticleInexistentException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NullArticleException(String msg) {
        super(msg);
    }
}
