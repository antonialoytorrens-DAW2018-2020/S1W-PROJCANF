package com.canf.articles;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    private ArrayList<Article> productes;
    private int quantitat = 0;
    private LocalDate data;
    private int totalVentes;

    public Venta(ArrayList<Article> productes) {
        this.productes = productes;
        this.setQuantitat(quantitat);
        this.data = LocalDate.now();
        this.totalVentes += totalVentes + quantitat;
        disminuirQuantitat(productes);
    }
    
    public ArrayList<Article> getProductes() {
        return productes;
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

    public int getTotalVentes() {
        return totalVentes;
    }    
    
    public void disminuirQuantitat(ArrayList<Article> productes) {
        for (Article producte : productes) {
            producte.setQuantitat(producte.getQuantitat() - 1);
        }
    }

    @Override
    public String toString() {
        return "Venta{" + "productes=" + productes + ", quantitat=" + quantitat + ", data=" + data + ", totalVentes=" + totalVentes + '}';
    }
    
}
