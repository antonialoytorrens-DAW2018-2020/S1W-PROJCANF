/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import com.canf.excepcions.LlibreException;
import com.canf.excepcions.ArticleException;
import com.canf.utilitats.Validacions;

/**
 *
 * @author antonialoy
 */
public class Llibre extends Article {
private String isbn;
    private String nomAutor;
    private String nomEditorial;
    private int numPagines;

    public Llibre(String isbn, String nomAutor, String nomEditorial, int numPagines, String nom, String descripcio, tipusArticle tipusArticle, double preuUnitari, int quantitat) throws ArticleException, LlibreException {
        super(nom, descripcio, tipusArticle, preuUnitari, quantitat);
        this.setIsbn(isbn);
        this.setNomAutor(nomAutor);
        this.setNomEditorial(nomEditorial);
        this.setNumPagines(numPagines);
    }   

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws LlibreException {
         if(!Validacions.validaCadena(isbn)){
            throw new LlibreException("L'ISBN del llibre no pot ser null ni pot estar buit");
        }
        this.isbn = isbn;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) throws LlibreException {
        if(!Validacions.validaCadena(nomAutor)){
            throw new LlibreException("El nom de l'autor no pot ser null ni pot estar buit");
        }
        this.nomAutor = nomAutor;
    }

    public String getNomEditorial() {
        return nomEditorial;
    }

    public void setNomEditorial(String nomEditorial) throws LlibreException {
        if(!Validacions.validaCadena(nomEditorial)){
           throw new LlibreException("El nom de l'editorial no pot ser null ni pot estar buit");
        }
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
        return "Llibre{" +super.toString()+ ", isbn=" + isbn + ", nomAutor=" + nomAutor + ", nomEditorial=" + nomEditorial + ", numPagines=" + numPagines + '}';
    }
}