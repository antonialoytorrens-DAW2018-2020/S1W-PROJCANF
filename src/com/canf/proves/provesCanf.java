package com.canf.proves;

import com.canf.articles.Article;
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
        ArrayList<Article> articles= new ArrayList<>();
        Article x = new Article(1809, "Disc de Vinil dels Beatles", "Disc de Vinil exclusiu amb cites de John Lennon", 500, 2);
        articles.add(x);
        x.mostraXML(articles);
    }
    
}
