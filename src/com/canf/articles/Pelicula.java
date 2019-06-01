/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import com.canf.excepcions.PeliculaException;
import com.canf.excepcions.ArticleException;
import com.canf.utilitats.Validacions;
import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public class Pelicula extends Article {
   private String nomDirector;
    private ArrayList<String> llistaActors;
    private String sinopsi;

    public Pelicula(String nomDirector, ArrayList<String> llistaActors, String sinopsi, String nom, String descripcio, tipusArticle tipusArticle, double preuUnitari, int quantitat) throws ArticleException, PeliculaException {
        super(nom, descripcio, tipusArticle, preuUnitari, quantitat);
        this.nomDirector = nomDirector;
        this.llistaActors = llistaActors;
        this.sinopsi = sinopsi;
    }

    public String getNomDirector() {
        return nomDirector;
    }

    public void setNomDirector(String nomDirector) throws PeliculaException {
        if(!Validacions.validaCadena(nomDirector)) {
            throw new PeliculaException("El nom del director/a no pot ser null ni pot estar buit");
        }
        this.nomDirector = nomDirector;
    }

    public ArrayList<String> getLlistaActors() {
        return llistaActors;
    }

    public String getSinopsi() {
        return sinopsi;
    }

    public void setSinopsi(String sinopsi) throws PeliculaException {
        if(!Validacions.validaCadena(sinopsi)) {
            throw new PeliculaException("La sinopsi no pot ser null ni pot estar buida");
        }
        this.sinopsi = sinopsi;
    }

    @Override
    public String toString() {
        return "Pelicula{" + super.toString() + ", nomDirector=" + nomDirector + ", llistaActors=" + llistaActors + ", sinopsi=" + sinopsi + '}';
    }
    
}