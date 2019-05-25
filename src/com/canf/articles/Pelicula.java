/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import static com.canf.articles.tipusArticle.PELÍCULA;
import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public class Pelicula extends Article {
    private final tipusArticle tipus = PELÍCULA;
    private String nomDirector;
    private ArrayList<String> llistaActors;
    private String sinopsi;

    public Pelicula(String nomDirector, ArrayList<String> llistaActors, String sinopsi, int referencia, String nom, String descripcio, double preuUnitari, int quantitat) {
        super(referencia, nom, descripcio, preuUnitari, quantitat);
        this.nomDirector = nomDirector;
        this.llistaActors = llistaActors;
        this.sinopsi = sinopsi;
    }

    public String getNomDirector() {
        return nomDirector;
    }

    public void setNomDirector(String nomDirector) {
        this.nomDirector = nomDirector;
    }

    public ArrayList<String> getLlistaActors() {
        return llistaActors;
    }

    public void setLlistaActors(ArrayList<String> llistaActors) {
        this.llistaActors = llistaActors;
    }

    public String getSinopsi() {
        return sinopsi;
    }

    public void setSinopsi(String sinopsi) {
        this.sinopsi = sinopsi;
    }

    @Override
    public String toString() {
        return "Pelicula{" + super.toString() + "tipusArticle= "+ tipus +"nomDirector=" + nomDirector + ", llistaActors=" + llistaActors + ", sinopsi=" + sinopsi + '}';
    }
    
}
