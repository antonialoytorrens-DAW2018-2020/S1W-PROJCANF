package com.canf.proves;

import com.canf.articles.Article;
import com.canf.articles.Pelicula;
import com.canf.articles.Comanda;
import com.canf.articles.Disc;
import com.canf.articles.Venta;
import com.canf.articles.tipusArticle;
import static com.canf.articles.tipusArticle.DISC;
import static com.canf.articles.tipusArticle.PELICULA;
import com.canf.empresa.Magatzem;
import com.canf.excepcions.ArticleException;
import com.canf.excepcions.ComandaException;
import com.canf.excepcions.DiscException;
import com.canf.excepcions.OutOfStockException;
import com.canf.excepcions.PeliculaException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class provesCanf {

    public void inicialitza() throws ArticleException, PeliculaException, ComandaException, DiscException {
        //Afegim Magatzem
        Magatzem canf1 = new Magatzem(1, "Canf");
        Pelicula p;
        Disc d;
        
        //Afegim Discos
        d = new Disc(3, "Jerry Butler", "U.S. Discographics", 
                "Motown Disco Version nº3", "Música disco del 1969", DISC, 10, 30);
        canf1.addDisc(d);
        canf1.obtenirDisc(3).addCanso("Only the Strong Survive");
        d = new Disc(4, "The Jackson 5", "Epic Records, Motown, Steeltown Records",
                "The Jackson 5 Hits", "Rythm and blues", DISC, 30, 60);
        canf1.addDisc(d);
        canf1.obtenirDisc(4).addCanso("Never Say Goodbye");
        d = new Disc(5, "Bee Gees", "Festival, RSO, Warner Bros., Rhino", 
                "The Best of Bee Gees", "Música disco del 1977", DISC, 20, 10);
        canf1.addDisc(d);
        canf1.obtenirDisc(5).addCanso("Stayin' Alive");
        canf1.obtenirDisc(5).addCanso("You should be dancing");
        d = new Disc(6, "Bee Gees", "Festival, RSO, Warner Bros., Rhino", 
                "The Best of Bee Gees", "Música disco del 1977", DISC, 29, 70);
        canf1.addDisc(d);
        
        canf1.imprimirLlistaDiscos(false);
        ArrayList<Disc> cercaDiscos = canf1.cercaDiscos("Bee Gees");
        canf1.imprimirLlistaDiscos(cercaDiscos);
      
        //Afegim Pel·lícules
        p = canf1.addPelicula(0, "Mark Neveldine, Brian Taylor", "Professional assassin Chev Chelios "
                + "learns his rival has injected him with a poison that will "
                + "kill him if his heart rate drops.",
                "Crank: Veneno en la sangre", "Película d'acció", 17, 15);
        p.addActor("Jason Statham");
        p.addActor("Amy Smart");
        canf1.obtenirPelicula(0).addActor("Carlos Sanz");
        canf1.obtenirPelicula(0).addActor("Jose Cantillo");

        p = canf1.addPelicula(1, "Chad Stahelski, David Leitch", "An ex-hit-man comes "
                + "out of retirement to track down the gangsters that killed his"
                + " dog and took everything from him.", "John Wick (Otro día para matar)", "Película d'acció", 12, 10);
        p.addActor("Keanu Reeves");
        p.addActor("Michael Nyqvist");
        p.addActor("Alfie Allen");
        p.addActor("Willem Dafoe");
        
        p = canf1.addPelicula(2, "Chad Stahelski", "After returning to the criminal "
                + "underworld to repay a debt, John Wick discovers that a "
                + "large bounty has been put on his life.", 
                "John Wick: Pacto de sangre", "Película d'acció", 25, 20);
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
        venta.imprimirTicket();
        
        //Segona venta
        Venta venta2 = new Venta();
        
        p = canf1.obtenirPelicula(0);
        c = new Comanda(p, 3);
        venta2.addComanda(c);
        venta2.imprimirTicket();
        try {
            canf1.efectuarVenta(venta2);
        } catch (OutOfStockException ex) {
            System.out.println(ex.getMessage());
        }
        //Tercera venta
        Venta venta3 = new Venta();
        
        p = canf1.obtenirPelicula(0);
        c = new Comanda(p, 20);
        venta3.addComanda(c);
        venta3.imprimirTicket();
        try {
            canf1.efectuarVenta(venta3);
        } catch (OutOfStockException ex) {
            System.out.println(ex.getMessage());
        }
        
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
        } catch (DiscException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
