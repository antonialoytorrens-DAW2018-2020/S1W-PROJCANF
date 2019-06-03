package com.canf.articles;

import com.canf.excepcions.NullArticleException;
import com.canf.excepcions.ComandaException;

public class Comanda {

    private Article article;

    private int numeroComanda;
    private static int comanda = 0;
    private int quantitat;
    private double preu;

    public Comanda(Article article, int quantitat) throws ComandaException, NullArticleException {
        this.numeroComanda = comanda++;
        validarArticle(article);
        this.setQuantitat(quantitat);
        this.preu = article.getPreuUnitari();
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) throws ComandaException {
        if(quantitat<=0) {
            throw new ComandaException("La quantitat que es vol demanar a la comanda no pot ser zero o negativa");
        }
        this.quantitat = quantitat;
    }
    
    public void validarArticle(Article article) throws NullArticleException {
        if(article==null) {
            throw new NullArticleException("L'article que es vol comanar no existeix");
        }
        this.article = article;
    }
    
    public Article getArticle() {
        return article;
    }

    public double getPreu() {
        return preu;
    }
    
    public double getImportTotal() {
        return article.getPreuUnitari() * quantitat;
    }

    @Override
    public String toString() {
        return "Comanda{" + "article=" + article + ", quantitat=" + quantitat + ", preu=" + preu + '}';
    }

}
