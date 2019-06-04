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

    public Llibre(int referencia, String isbn, String nomAutor, String nomEditorial, int numPagines, String nom, String descripcio, tipusArticle tipusArticle, double preuUnitari, int stock) throws ArticleException, LlibreException {
        super(referencia, nom, descripcio, tipusArticle, preuUnitari, stock);
        validaIsbn(isbn);
        this.setNomAutor(nomAutor);
        this.setNomEditorial(nomEditorial);
        this.setNumPagines(numPagines);
    }

    public String getIsbn() {
        return isbn;
    }

    //L'ISBN té 13 xifres
    public String validaIsbn(String isbn) throws LlibreException {
        /*if(isbn.length()!=13) {
            throw new LlibreException("L'ISBN ha de tenir 13 xifres");
        }*/
        if(!Validacions.validaCadena(isbn)) {
            throw new LlibreException("L'ISBN no pot ser null ni pot estar buit");
        }
        return this.isbn;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) throws LlibreException {
        if (!Validacions.validaCadena(nomAutor)) {
            throw new LlibreException("El nom de l'autor no pot ser null ni pot estar buit");
        }
        this.nomAutor = nomAutor;
    }

    public String getNomEditorial() {
        return nomEditorial;
    }

    public void setNomEditorial(String nomEditorial) throws LlibreException {
        if (!Validacions.validaCadena(nomEditorial)) {
            throw new LlibreException("El nom de l'editorial no pot ser null ni pot estar buit");
        }
        this.nomEditorial = nomEditorial;
    }

    public int getNumPagines() {
        return numPagines;
    }

    public void setNumPagines(int numPagines) throws LlibreException {
        if (numPagines <= 0) {
            throw new LlibreException("El número de pàgines no pot ser zero o negatiu");
        }
    }
    
    @Override
    public String toXML(boolean complet) {
        String xml = "";
        if (complet) {
            xml =   "\t<article>\n"
                    + "\t\t<llibre>\n"
                    +"\t\t\t<referencia>"+this.getReferencia()+"</referencia>\n"
                    +"\t\t\t<nom>"+this.getNom()+"</nom>\n"
                    +"\t\t\t<descripcio>"+this.getDescripcio()+"</descripcio>\n"
                    +"\t\t\t<tipusArticle>"+this.getTipusArticle()+"</tipusArticle>\n"
                    +"\t\t\t<preuUnitari>"+this.getPreuUnitari()+"</preuUnitari>\n"
                    +"\t\t\t<stock>"+this.getStock()+"</stock>\n"
                    +"\t\t\t<autor>"+this.getNomAutor()+"</autor>\n"
                    +"\t\t\t<editorial>"+this.getNomEditorial()+"</editorial>\n"
                    +"\t\t\t<numeroPagines>"+this.getNumPagines()+"</numeroPagines>\n"
                    +"\t\t</llibre>\n"
                    +"\t</article>\n";
            return xml;
        } else {
            xml =   "\t<article>\n"
                    + "\t\t<llibre>\n"
                    +"\t\t\t<referencia>"+this.getReferencia()+"</referencia>\n"
                    +"\t\t\t<nom>"+this.getNom()+"</nom>\n"
                    +"\t\t\t<descripcio>"+this.getDescripcio()+"</descripcio>\n"
                    +"\t\t\t<tipusArticle>"+this.getTipusArticle()+"</tipusArticle>\n"
                    +"\t\t\t<preuUnitari>"+this.getPreuUnitari()+"</preuUnitari>\n"
                    +"\t\t\t<stock>"+this.getStock()+"</stock>\n"
                    +"\t\t</llibre>\n"
                    +"\t</article>\n";
            return xml;
        }
    }

    @Override
    public String toString() {
        return "Llibre{" + super.toString() + ", isbn=" + isbn + ", nomAutor=" + nomAutor + ", nomEditorial=" + nomEditorial + ", numPagines=" + numPagines + '}';
    }
}
