/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import static com.canf.articles.tipusArticle.LLIBRE;

/**
 *
 * @author antonialoy
 */
public class Llibre extends Article {
    private final tipusArticle tipus = LLIBRE;
    private String isbn;
    private String nomAutor;
    private String nomEditorial;
    private int numPagines;

    public Llibre(String isbn, String nomAutor, String nomEditorial, int numPagines, int referencia, String nom, String descripcio, double preuUnitari, int quantitat) {
        super(referencia, nom, descripcio, preuUnitari, quantitat);
        this.isbn = isbn;
        this.nomAutor = nomAutor;
        this.nomEditorial = nomEditorial;
        this.numPagines = numPagines;
    }

    

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getNomEditorial() {
        return nomEditorial;
    }

    public void setNomEditorial(String nomEditorial) {
        this.nomEditorial = nomEditorial;
    }

    public int getNumPagines() {
        return numPagines;
    }

    public void setNumPagines(int numPagines) {
        this.numPagines = numPagines;
    }

    @Override
    public String toString() {
        return "Llibre{" +super.toString()+ "tipus=" + tipus + ", isbn=" + isbn + ", nomAutor=" + nomAutor + ", nomEditorial=" + nomEditorial + ", numPagines=" + numPagines + '}';
    }
    
    
}
