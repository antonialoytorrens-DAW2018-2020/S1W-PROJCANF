package com.canf.proves;

import com.canf.excepcions.PeliculaException;
import com.canf.articles.Article;
import com.canf.articles.Disc;
import com.canf.excepcions.DiscException;
import com.canf.excepcions.ArticleException;
import java.util.ArrayList;

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
        p.provesXMLArticles();
    }

    public void provesXMLArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<String> discExclusiuBeatles = new ArrayList<>();      
        try {
            discExclusiuBeatles.add("Love me Do");
            Article x = new Disc("Beatles", discExclusiuBeatles,"desconeguda", 
            "Disc de Vinil dels Beatles", "Disc de Vinil exclusiu dels Beatles", 
            500.0, 2);
            
            Article y = new Disc("", discExclusiuBeatles, "", "","", 25.0, 1);
            articles.add(x);
            articles.add(y);
            x.mostraXML(articles);
        } catch (ArticleException | DiscException e) {
            System.out.println(e.getMessage());
        }

    }

}
