/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public class Article {
    private int referencia;
    private String nom;
    private String descripcio;
    private double preuUnitari;
    private int quantitat;

    public Article(int referencia, String nom, String descripcio, double preuUnitari, int quantitat) {
        this.setReferencia(referencia);
        this.setNom(nom);
        this.setDescripcio(descripcio);
        this.setPreuUnitari(preuUnitari);
        this.setQuantitat(quantitat);
    }
    
    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
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
