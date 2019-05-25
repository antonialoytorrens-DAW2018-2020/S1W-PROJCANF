/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.empresa;

import com.canf.articles.Article;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author antonialoy
 */
public class Principal {
    private String nom;
    private int codi;
    private ArrayList<Article> llistaArticles;
    private HashSet<Magatzem> magatzems;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public ArrayList<Article> getLlistaArticles() {
        return llistaArticles;
    }

    public void setLlistaArticles(ArrayList<Article> llistaArticles) {
        this.llistaArticles = llistaArticles;
    }

    public HashSet<Magatzem> getMagatzems() {
        return magatzems;
    }

    public void setMagatzems(HashSet<Magatzem> magatzems) {
        this.magatzems = magatzems;
    }

    @Override
    public String toString() {
        return "Principal{" + "nom=" + nom + ", codi=" + codi + ", llistaArticles=" + llistaArticles + ", magatzems=" + magatzems + '}';
    }
    
    
}
