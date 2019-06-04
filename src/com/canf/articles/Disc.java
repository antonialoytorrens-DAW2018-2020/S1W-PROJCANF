/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import com.canf.excepcions.DiscException;
import com.canf.excepcions.ArticleException;
import com.canf.utilitats.Validacions;
import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public class Disc extends Article {

    private String interpret;
    private ArrayList<String> llistaCansons;
    private String discografica;

    public Disc(int referencia, String interpret, ArrayList<String> llistaCansons, String discografica, String nom, String descripcio, tipusArticle tipusArticle, double preuUnitari, int stock) throws ArticleException, DiscException {
        super(referencia, nom, descripcio, tipusArticle, preuUnitari, stock);
        this.setInterpret(interpret);
        this.setDiscografica(discografica);
        this.llistaCansons = llistaCansons;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) throws DiscException {
        if (!Validacions.validaCadena(interpret)) {
            throw new DiscException("El nom de l'intèrpret no pot ser null ni pot estar buit");
        }
        this.interpret = interpret;
    }

    public ArrayList<String> getLlistaCansons() {
        return llistaCansons;
    }

    public void addCanso(String e) {
        this.llistaCansons.add(e);
    }

    public void removeCanso(String e) {
        this.llistaCansons.remove(e);
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) throws DiscException {
        if (!Validacions.validaCadena(discografica)) {
            throw new DiscException("El nom de la discogràfica no pot ser null ni pot estar buit");
        }
        this.discografica = discografica;
    }

    @Override
    public String toXML(boolean complet) {
        String xml = "";
        if (complet) {
            xml = " \t<article>\n"
                    + "\t\t<disc>\n"
                    +"\t\t\t<referencia>"+this.getReferencia()+"</referencia>\n"
                    +"\t\t\t<nom>"+this.getNom()+"</nom>\n"
                    +"\t\t\t<descripcio>"+this.getDescripcio()+"</descripcio>\n"
                    +"\t\t\t<tipusArticle>"+this.getTipusArticle()+"</tipusArticle>\n"
                    +"\t\t\t<preuUnitari>"+this.getPreuUnitari()+"</preuUnitari>\n"
                    +"\t\t\t<stock>"+this.getStock()+"</stock>\n"
                    +"\t\t\t<interpret>"+this.getInterpret()+"</interpret>\n"
                    +"\t\t\t<discografica>"+this.getDiscografica()+"</discografica>\n"
                    +"\t\t\t<cançons>"+this.getLlistaCansons()+"</cançons>\n"
                    +"\t\t</disc>\n"
                    +"\t</article>\n";
            return xml;
        } else {
            xml =   "\t<article>\n"
                    + "\t\t<disc>\n"
                    +"\t\t\t<referencia>"+this.getReferencia()+"</referencia>\n"
                    +"\t\t\t<nom>"+this.getNom()+"</nom>\n"
                    +"\t\t\t<descripcio>"+this.getDescripcio()+"</descripcio>\n"
                    +"\t\t\t<tipusArticle>"+this.getTipusArticle()+"</tipusArticle>\n"
                    +"\t\t\t<preuUnitari>"+this.getPreuUnitari()+"</preuUnitari>\n"
                    +"\t\t\t<stock>"+this.getStock()+"</stock>\n"
                    +"\t\t</disc>\n"
                    +"\t</article>\n";
            return xml;
        }
    }
    
    @Override
    public String toString() {
        return "Disc{" + super.toString() + ", interpret=" + interpret + ", llistaCansons=" + llistaCansons + ", discografica=" + discografica + '}';
    }

}
