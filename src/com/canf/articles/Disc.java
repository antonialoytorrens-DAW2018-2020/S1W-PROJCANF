/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.articles;

import com.canf.excepcions.DiscException;
import static com.canf.articles.tipusArticle.DISC;
import com.canf.excepcions.ArticleException;
import com.canf.utilitats.Validacions;
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

    public Disc(String interpret, ArrayList<String> llistaCansons, String discografica, String nom, String descripcio, double preuUnitari, int quantitat) throws ArticleException, DiscException {
        super(nom, descripcio, preuUnitari, quantitat);
        this.setInterpret(interpret);
        this.setDiscografica(discografica);
        this.llistaCansons = new ArrayList<>();
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

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) throws DiscException {
        if(!Validacions.validaCadena(discografica)){
            throw new DiscException("El nom de la discogràfica no pot ser null ni pot estar buit");
        }
        this.discografica = discografica;
    }

    @Override
    public String toString() {
        return "Disc{" +super.toString()+ "tipus=" + tipus + ", interpret=" + interpret + ", llistaCansons=" + llistaCansons + ", discografica=" + discografica + '}';
    }
    
}
