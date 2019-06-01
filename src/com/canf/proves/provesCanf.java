package com.canf.proves;

import com.canf.articles.Article;
import com.canf.articles.Pelicula;
<<<<<<< HEAD
import com.canf.articles.Comanda;
=======
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106
import com.canf.articles.Venta;
import static com.canf.articles.tipusArticle.PELÍCULA;
import com.canf.empresa.Magatzem;
import com.canf.excepcions.ArticleException;
<<<<<<< HEAD
import com.canf.excepcions.ComandaException;
=======
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106
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
<<<<<<< HEAD
            Pelicula pelicula2 = new Pelicula("Joselito2", actors, "sinopsi2", "La vida de Joselito2", "descripcio2", PELÍCULA, 2, 0);
            //Llista articles
            ArrayList<Article> llistaArticles = new ArrayList<>();
            //Llista ventes
            ArrayList<Venta> historialVentes = new ArrayList<>();
=======
            Pelicula pelicula2 = new Pelicula("Joselito2", actors, "sinopsi2", "La vida de Joselito2", "descripcio2", PELÍCULA, 2, 2);
            //Llista articles
            ArrayList<Article> llistaArticles = new ArrayList<>();
            //Llista ventes
             ArrayList<Venta> historialVentes = new ArrayList<>();
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106
            //Crear magatzem
            Magatzem canf = new Magatzem(1, "Canf", llistaArticles, historialVentes);
            canf.addArticle(pelicula);
            canf.addArticle(pelicula2);
            System.out.println(canf);
<<<<<<< HEAD

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
=======
            
            Venta ticket = new Venta(canf.getLlistaArticles());
            System.out.println(ticket);         
            
            System.out.println();
            System.out.println("Venta");
            System.out.println(canf);

        } catch (ArticleException | PeliculaException e) {
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        provesCanf p = new provesCanf();
<<<<<<< HEAD
        p.inicialitza();
    }
=======
        //p.provesXMLArticles();
        p.inicialitza();
    }    
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106

}
