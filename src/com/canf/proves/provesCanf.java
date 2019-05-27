package com.canf.proves;

import com.canf.articles.Article;
import com.canf.articles.Disc;
import com.canf.articles.Pelicula;
import com.canf.articles.Venta;
import com.canf.excepcions.DiscException;
import com.canf.excepcions.ArticleException;
import com.canf.excepcions.PeliculaException;
import java.util.ArrayList;

public class provesCanf {

    public void marta() {
        try {
            //Llista actors
            ArrayList<String> actors = new ArrayList<>();
            actors.add("Marta");
            //Articles
            Pelicula pelicula = new Pelicula("Joselito", actors, "sinopsi", "La vida de Joselito", "descripcio", 2, 12);
            Pelicula pelicula2 = new Pelicula("Joselito2", actors, "sinopsi2", "La vida de Joselito2", "descripcio2", 2, 2);
            //Llista articles
            ArrayList<Article> ticket = new ArrayList<>();
            ticket.add(pelicula);
            ticket.add(pelicula2);
            pelicula.mostraXML(ticket);
            Venta venta = new Venta(ticket);            
            System.out.println(venta);
            
        } catch (ArticleException | PeliculaException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        provesCanf p = new provesCanf();
         //p.provesXMLArticles();
        p.marta();
    }

    public void provesXMLArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<String> discExclusiuBeatles = new ArrayList<>();
        try {
            discExclusiuBeatles.add("Love me Do");
            Article x = new Disc("Beatles", discExclusiuBeatles, "desconeguda",
                    "Disc de Vinil dels Beatles", "Disc de Vinil exclusiu dels Beatles",
                    500.0, 2);

            articles.add(x);
            x.mostraXML(articles);
        } catch (ArticleException | DiscException e) {
            System.out.println(e.getMessage());
        }

    }

}
