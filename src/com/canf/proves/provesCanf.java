package com.canf.proves;

import com.canf.excepcions.PeliculaException;
import com.canf.articles.Article;
import com.canf.articles.Disc;
import com.canf.articles.Venta;
import static com.canf.articles.tipusArticle.DISC;
import com.canf.empresa.Magatzem;
import com.canf.excepcions.DiscException;
import com.canf.excepcions.ArticleException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antonialoy
 */
public class provesCanf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        provesCanf p = new provesCanf();
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<Venta> ventes = new ArrayList<>();
        ArrayList<String> discExclusiuBeatles = new ArrayList<>();  
        Magatzem magatzem = new Magatzem(1846, "Magatzem CANF 1", articles, ventes);
        try {
         Article x = new Disc("Beatles", discExclusiuBeatles,"desconeguda",
                    "Disc de Vinil dels Beatles", "Disc de Vinil exclusiu dels Beatles",
                    DISC, 500.0, 2);     
        magatzem.addArticle(x);
        System.out.println(magatzem);
        } catch (ArticleException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DiscException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
