/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import java.time.LocalDate;

/**
 *
 * @author antonialoy
 */
public class Venta {
    private Article producte;
    private int quantitat;
    private LocalDate data;

    public Article getProducte() {
        return producte;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venta{" + "producte=" + producte + ", quantitat=" + quantitat + ", data=" + data + '}';
    }
    
}
