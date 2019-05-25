/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import static com.canf.articles.tipusArticle.DISC;
import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public class Disc extends Article{
    private final tipusArticle tipus = DISC;
    private String interpret;
    private ArrayList<String> llistaCansons;
    private String discografica;

    public Disc(String interpret, ArrayList<String> llistaCansons, String discografica, int referencia, String nom, String descripcio, double preuUnitari, int quantitat) {
        super(referencia, nom, descripcio, preuUnitari, quantitat);
        this.interpret = interpret;
        this.llistaCansons = llistaCansons;
        this.discografica = discografica;
    }   

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public ArrayList<String> getLlistaCansons() {
        return llistaCansons;
    }

    public void setLlistaCansons(ArrayList<String> llistaCansons) {
        this.llistaCansons = llistaCansons;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    @Override
    public String toString() {
        return "Disc{" +super.toString()+ "tipus=" + tipus + ", interpret=" + interpret + ", llistaCansons=" + llistaCansons + ", discografica=" + discografica + '}';
    }
    
}
