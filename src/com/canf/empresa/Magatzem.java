/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.empresa;

import com.canf.articles.Article;
import com.canf.articles.Disc;
import static com.canf.articles.tipusArticle.DISC;
import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public class Magatzem {
    private int codi;
    private String nom;
    private ArrayList<Article> llistaArticles;

    public Magatzem(String nom, int codi, ArrayList<Article> llistaArticles) {
        this.setNom(nom);
        this.codi = codi;
        this.llistaArticles = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public ArrayList<Article> getLlistaArticles() {
        return llistaArticles;
    }
    
    public Disc obtenirDisc(String interpret) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle()==DISC) {
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Magatzem{" + "codi=" + codi + ", nom=" + nom + ", llistaArticles=" + llistaArticles + '}';
    }
    
    
}
