package com.canf.articles;

import com.canf.excepcions.DiscException;
import com.canf.excepcions.ArticleException;
import com.canf.utilitats.Validacions;
import java.util.ArrayList;

public class Disc extends Article {

  private String interpret;
    private ArrayList<String> llistaCansons;
    private String discografica;

    public Disc(String interpret, ArrayList<String> llistaCansons, String discografica, String nom, String descripcio, tipusArticle tipusArticle, double preuUnitari, int quantitat) throws ArticleException, DiscException {
        super(nom, descripcio, tipusArticle, preuUnitari, quantitat);
        this.setInterpret(interpret);
        this.setDiscografica(discografica);
        this.llistaCansons = new ArrayList<>();
    }   

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) throws new DiscException {
        if (Validacions.validaCadena(interpret)) {
            this.interpret = interpret;
        } else {
            throw new DiscException("L'interpret no pot esser null ni estar buit.")
        }
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
        return "Disc{" +super.toString()+ ", interpret=" + interpret + ", llistaCansons=" + llistaCansons + ", discografica=" + discografica + '}';
    }

}
