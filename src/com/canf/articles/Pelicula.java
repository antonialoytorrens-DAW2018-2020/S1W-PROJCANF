/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import static com.canf.articles.tipusExtensio.SENZILL;
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

    public Pelicula(int referencia, String nomDirector, ArrayList<String> llistaActors, String sinopsi,
            String nom, String descripcio, tipusArticle tipusArticle,
            double preuUnitari, int quantitat) throws ArticleException, PeliculaException {
        super(referencia, nom, descripcio, tipusArticle, preuUnitari, quantitat);
        this.nomDirector = nomDirector;
        this.llistaActors = llistaActors;
        this.sinopsi = sinopsi;
    }
    
    public String getNomDirector() {
        return nomDirector;
    }

    public void addActor(String e) {
        this.llistaActors.add(e);
    }

    public void removeActor(String e) {
        this.llistaActors.remove(e);
    }

    public void setNomDirector(String nomDirector) throws PeliculaException {
        if (!Validacions.validaCadena(nomDirector)) {
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
        if (!Validacions.validaCadena(sinopsi)) {
            throw new PeliculaException("La sinopsi no pot ser null ni pot estar buida");
        }
        this.sinopsi = sinopsi;
    }

    @Override
    public String toXML(tipusExtensio tipus) {
        String xml = "";
        if (tipus==SENZILL) {
            xml =   "\t<article>\n"
                    + "\t\t<pelicula>\n"
                    +"\t\t\t<referencia>"+this.getReferencia()+"</referencia>\n"
                    +"\t\t\t<nom>"+this.getNom()+"</nom>\n"
                    +"\t\t\t<descripcio>"+this.getDescripcio()+"</descripcio>\n"
                    +"\t\t\t<tipusArticle>"+this.getTipusArticle()+"</tipusArticle>\n"
                    +"\t\t\t<preuUnitari>"+this.getPreuUnitari()+"</preuUnitari>\n"
                    +"\t\t\t<stock>"+this.getStock()+"</stock>\n"
                    +"\t\t\t<nomDirector>"+this.nomDirector+"</nomDirector>\n"
                    +"\t\t\t<llistaActors>"+this.getLlistaActors()+"</llistaActors>\n"
                    +"\t\t\t<sinopsi>"+this.getSinopsi()+"</sinopsi>\n"
                    +"\t\t</pelicula>\n"
                    +"\t</article>\n";
            return xml;
        } else {
            xml =   "\t<article>\n"
                    + "\t\t<pelicula>\n"
                    +"\t\t\t<referencia>"+this.getReferencia()+"</referencia>\n"
                    +"\t\t\t<nom>"+this.getNom()+"</nom>\n"
                    +"\t\t\t<descripcio>"+this.getDescripcio()+"</descripcio>\n"
                    +"\t\t\t<tipusArticle>"+this.getTipusArticle()+"</tipusArticle>\n"
                    +"\t\t\t<preuUnitari>"+this.getPreuUnitari()+"</preuUnitari>\n"
                    +"\t\t\t<stock>"+this.getStock()+"</stock>\n"
                    +"\t\t</pelicula>\n"
                    +"\t</article>\n";
            return xml;
        }
    }

    @Override
    public String toString() {
        return "Pelicula{" + super.toString() + ", nomDirector=" + nomDirector + ", llistaActors=" + llistaActors + ", sinopsi=" + sinopsi + '}';
    }

}
