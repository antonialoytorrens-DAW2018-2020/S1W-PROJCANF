package com.canf.proves;

import com.canf.articles.Article;
import com.canf.articles.Pelicula;
import com.canf.articles.Venta;
import static com.canf.articles.tipusArticle.PELÍCULA;
import com.canf.empresa.Magatzem;
import com.canf.excepcions.ArticleException;
import com.canf.excepcions.PeliculaException;
import java.util.ArrayList;

public class provesCanf {

    public void inicialitza() {
        try {
            //Llista actors
            ArrayList<String> actors = new ArrayList<>();
            actors.add("Marta");
            //Articles
            Pelicula pelicula = new Pelicula("Joselito", actors, "sinopsi", "La vida de Joselito", "descripcio", PELÍCULA, 2, 12);
            Pelicula pelicula2 = new Pelicula("Joselito2", actors, "sinopsi2", "La vida de Joselito2", "descripcio2", PELÍCULA, 2, 2);
            //Llista articles
            ArrayList<Article> llistaArticles = new ArrayList<>();
            //Llista ventes
             ArrayList<Venta> historialVentes = new ArrayList<>();
            //Crear magatzem
            Magatzem canf = new Magatzem(1, "Canf", llistaArticles, historialVentes);
            canf.addArticle(pelicula);
            canf.addArticle(pelicula2);
            System.out.println(canf);
            
            Venta ticket = new Venta(canf.getLlistaArticles());
            System.out.println(ticket);         
            
            System.out.println();
            System.out.println("Venta");
            System.out.println(canf);

        } catch (ArticleException | PeliculaException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        provesCanf p = new provesCanf();
        //p.provesXMLArticles();
        p.inicialitza();
    }    

}
