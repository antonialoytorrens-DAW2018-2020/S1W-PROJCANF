package com.canf.articles;

import com.canf.excepcions.ArticleException;
import com.canf.utilitats.Validacions;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Article implements Serializable{

    private int referencia;

    private String nom;
    private String descripcio;
    private tipusArticle tipusArticle;
    private double preuUnitari;
    private int stock;

    public Article(int referencia, String nom, String descripcio, tipusArticle tipusArticle,
            double preuUnitari, int quantitat) throws ArticleException {
        validaReferencia(referencia);
        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPreuUnitari(preuUnitari);
        validaTipusArticle(tipusArticle);
        this.setStock(quantitat);
    }

    public int validaReferencia(int referencia) throws ArticleException {
        if (referencia < 0) {
            throw new ArticleException("El codi de l'article no pot ser negatiu");
        } else {
            return this.referencia = referencia;
        }
    }

    public tipusArticle validaTipusArticle(tipusArticle tipusArticle) throws ArticleException {
        if (tipusArticle == null) {
            throw new ArticleException("El tipus d'article no pot ser null");
        }
        return this.tipusArticle = tipusArticle;
    }

    public int getReferencia() {
        return referencia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ArticleException {
        if (!Validacions.validaCadena(nom)) {
            throw new ArticleException("El nom de l'article no pot ser null ni pot estar buit");
        }
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) throws ArticleException {
        if (!Validacions.validaCadena(descripcio)) {
            throw new ArticleException("La descripció de l'article no pot ser null ni pot estar buida");
        }
        this.descripcio = descripcio;
    }

    public double getPreuUnitari() {
        return preuUnitari;
    }

    public void setPreuUnitari(double preuUnitari) throws ArticleException {
        if (preuUnitari <= 0) {
            throw new ArticleException("El preu per unitat de l'article no pot ser zero o negatiu");
        }
        this.preuUnitari = preuUnitari;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws ArticleException {
        if(stock<0) {
            throw new ArticleException("L'stock de l'article no pot ser negatiu");
        }
        this.stock = stock;
    }

    public tipusArticle getTipusArticle() {
        return tipusArticle;
    }
    public abstract String toXML(tipusExtensio tipus);

    @Override
    public String toString() {
        return "referencia=" + referencia + ", nom=" + nom + ", descripcio=" + descripcio + ", preuUnitari=" + preuUnitari + ", quantitat=" + stock;
    }

}
