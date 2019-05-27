/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import com.canf.excepcions.ArticleException;
import com.canf.utilitats.Validacions;
import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public abstract class Article {
    private int referencia;
    private static int numReferencia = 0;
    
    private String nom;
    private String descripcio;
    private double preuUnitari;
    private int quantitat;

    public Article(String nom, String descripcio, double preuUnitari, int quantitat) throws ArticleException {
        referencia = numReferencia++;
        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPreuUnitari(preuUnitari);
        this.setQuantitat(quantitat);
    }
    
    public int getReferencia() {
        return referencia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ArticleException {
        if(!Validacions.validaCadena(nom)) {
            throw new ArticleException("El nom no pot ser null ni pot estar buit");
        }
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) throws ArticleException {
        if(!Validacions.validaCadena(descripcio)) {
            throw new ArticleException("La descripció no pot ser null ni pot estar buida");
        }
        this.descripcio = descripcio;
    }

    public double getPreuUnitari() {
        return preuUnitari;
    }

    public void setPreuUnitari(double preuUnitari) {
        this.preuUnitari = preuUnitari;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public void mostraXML(ArrayList<Article> x) {
        String s = "<articles>\n";
        for(Article article : x) {
            s = s+"<article>"+article.toString()+"<article/>\n";
        }
        s=s+"</articles>";
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "Article{" + "referencia=" + referencia + ", nom=" + nom + ", descripcio=" + descripcio + ", preuUnitari=" + preuUnitari + ", quantitat=" + quantitat + '}';
    }
    
}
