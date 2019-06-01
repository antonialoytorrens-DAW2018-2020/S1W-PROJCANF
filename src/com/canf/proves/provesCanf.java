package com.canf.proves;

import com.canf.articles.Article;
import com.canf.articles.Pelicula;
import com.canf.articles.Comanda;
import com.canf.articles.Venta;
import static com.canf.articles.tipusArticle.PELÍCULA;
import com.canf.empresa.Magatzem;
import com.canf.excepcions.ArticleException;
import com.canf.excepcions.ComandaException;
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
            Pelicula pelicula2 = new Pelicula("Joselito2", actors, "sinopsi2", "La vida de Joselito2", "descripcio2", PELÍCULA, 2, 0);
            //Llista articles
            ArrayList<Article> llistaArticles = new ArrayList<>();
            //Llista ventes
            ArrayList<Venta> historialVentes = new ArrayList<>();
            //Crear magatzem
            Magatzem canf = new Magatzem(1, "Canf", llistaArticles, historialVentes);
            canf.addArticle(pelicula);
            canf.addArticle(pelicula2);
            System.out.println(canf);

            //Venta
            Comanda comanda1 = new Comanda(pelicula,-3);
            Comanda comanda2 = new Comanda(pelicula,3);
            ArrayList<Comanda> llistaComanda = new ArrayList<>();
            Venta venta = new Venta(llistaComanda);
            venta.addComanda(comanda1);
            venta.addComanda(comanda2);
            System.out.println(venta);
            
            canf.afegirStock(comanda1);
            System.out.println(canf);
            
            //Historial
            canf.addVenta(venta);
            System.out.println(canf);

        } catch (ArticleException | PeliculaException | ComandaException  e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        provesCanf p = new provesCanf();
        p.inicialitza();
    }

}