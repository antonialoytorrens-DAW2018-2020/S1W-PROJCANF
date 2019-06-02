package com.canf.articles;

import com.canf.excepcions.ComandaException;

public class Comanda {

    private Article article;

    private int numeroComanda;
    private static int comanda = 0;
    private int quantitat;
    private double preu;

    public Comanda(Article article, int quantitat) throws ComandaException {
        this.numeroComanda = comanda++;
        this.article = article;
        this.quantitat = quantitat;
        this.preu = article.getPreuUnitari();
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public Article getArticle() {
        return article;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    public double getImportTotal() {
        return article.getPreuUnitari() * quantitat;
    }

    @Override
    public String toString() {
        return "Comanda{" + "article=" + article + ", quantitat=" + quantitat + ", preu=" + preu + '}';
    }

}
