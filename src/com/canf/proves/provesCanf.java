package com.canf.proves;

import com.canf.articles.Article;
import com.canf.articles.Pelicula;
import com.canf.articles.Comanda;
import com.canf.articles.Disc;
import com.canf.articles.Venta;
import static com.canf.articles.tipusArticle.DISC;
import static com.canf.articles.tipusArticle.PELICULA;
import com.canf.empresa.Magatzem;
import com.canf.excepcions.ArticleException;
import com.canf.excepcions.ComandaException;
import com.canf.excepcions.DiscException;
import com.canf.excepcions.PeliculaException;
import java.util.ArrayList;

public class provesCanf {

    public void inicialitza() throws ArticleException, PeliculaException, ComandaException {
        //Afegim Magatzem
        Magatzem canf1 = new Magatzem(1, "Canf");
        Pelicula p;
        
        //Afegim Pel·lícules
        p = canf1.addPelicula("Mark Neveldine, Brian Taylor", "Professional assassin Chev Chelios "
                + "learns his rival has injected him with a poison that will "
                + "kill him if his heart rate drops.",
                "Crank: Veneno en la sangre", "Película d'acció", PELICULA, 17, 15);
        p.addActor("Jason Statham");
        p.addActor("Amy Smart");
        canf1.obtenirPelicula(0).addActor("Carlos Sanz");
        canf1.obtenirPelicula(0).addActor("Jose Cantillo");

        p = canf1.addPelicula("Chad Stahelski, David Leitch", "An ex-hit-man comes "
                + "out of retirement to track down the gangsters that killed his"
                + " dog and took everything from him.", "John Wick (Otro día para matar)", "Película d'acció", PELICULA, 12, 10);
        p.addActor("Keanu Reeves");
        p.addActor("Michael Nyqvist");
        p.addActor("Alfie Allen");
        p.addActor("Willem Dafoe");
        
        p = canf1.addPelicula("Chad Stahelski", "After returning to the criminal "
                + "underworld to repay a debt, John Wick discovers that a "
                + "large bounty has been put on his life.", 
                "John Wick: Pacto de sangre", "Película d'acció", PELICULA, 25, 20);
        p.addActor("Keanu Reeves");
        p.addActor("Ruby Rose");

        ArrayList<Pelicula> cerca = canf1.cercaPelicules("Allen");
        canf1.imprimirLlistaPelicules(cerca);
        p = canf1.obtenirPelicula(1);
        
        //Venta
        canf1.imprimirLlistaPelicules(false);
        Venta venta = new Venta();
        
        Comanda c = new Comanda(p, 1);
        venta.addComanda(c);
        
        p = canf1.obtenirPelicula(2);
        c = new Comanda(p, 2);
        venta.addComanda(c);
        venta.imprimirVenta();
        
        //Segona venta
        Venta venta2 = new Venta();
        
        p = canf1.obtenirPelicula(0);
        c = new Comanda(p, 3);
        venta2.addComanda(c);
        venta2.imprimirVenta();
        canf1.efectuarVenta(venta2);
        
        canf1.imprimirLlistaPelicules(false);
        canf1.imprimirHistorialVentes();
    }

    public static void main(String[] args) {
        provesCanf p = new provesCanf();
        try {
            p.inicialitza();
        } catch (ComandaException ex) {
            System.out.println(ex.getMessage());
        } catch (ArticleException ex) {
            System.out.println(ex.getMessage());
        } catch (PeliculaException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
