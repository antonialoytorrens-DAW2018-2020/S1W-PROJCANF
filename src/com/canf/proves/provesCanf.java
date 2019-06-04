package com.canf.proves;

import com.canf.articles.Pelicula;
import com.canf.articles.Comanda;
import com.canf.articles.Disc;
import com.canf.articles.Llibre;
import com.canf.articles.Venta;
import com.canf.articles.tipusArticle;
import static com.canf.articles.tipusArticle.DISC;
import static com.canf.articles.tipusArticle.PELICULA;
import static com.canf.articles.tipusArticle.LLIBRE;
import com.canf.empresa.Magatzem;
import com.canf.excepcions.ArticleException;
import com.canf.excepcions.NullArticleException;
import com.canf.excepcions.ComandaException;
import com.canf.excepcions.DiscException;
import com.canf.excepcions.LlibreException;
import com.canf.excepcions.MagatzemException;
import com.canf.excepcions.OutOfStockException;
import com.canf.excepcions.PeliculaException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class provesCanf {

    public void inicialitza() throws ArticleException, PeliculaException, ComandaException, DiscException, NullArticleException, MagatzemException {
        //Afegim Magatzem       
        Magatzem canf1 = new Magatzem(1, "Canf");
        Pelicula p;
        Disc d;
        Llibre l;

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
                "The Best of Bee Gees v.2", "Música disco del 1977", DISC, 29, 70);
        canf1.addDisc(d);

        canf1.imprimirLlistaDiscos(false);
        ArrayList<Disc> cercaDiscos = canf1.cercaDiscos("Bee Gees");
        canf1.imprimirLlistaDiscos(cercaDiscos);

        try {
            //Afegim Llibres
            l = new Llibre(7, "66778900WWW", "Carlos Ruiz Zafón", "Boileau",
                    228, "Marina\t\t\t", "Llibre de terror i misteri", LLIBRE, 28, 5);
            canf1.addLlibre(l);
            l = new Llibre(8, "66778900WXW", "Carlos Ruiz Zafón", "AltaMar",
                    325, "El príncipe de la niebla",
                    "Llibre de terror i misteri", LLIBRE, 38, 10);
            canf1.addLlibre(l);
            l = new Llibre(9, "12225666LLL", "Ramón Rubio", "Rubio",
                    328, "Brand Book, H. de Una Marca", "Historia de una Marca", LLIBRE, 8, 50);
            canf1.addLlibre(l);
            l = new Llibre(10, "66778900WXW", "Carlos Ruiz Zafón", "AltaMar",
                    325, "El príncipe de la niebla, Las Luces de Septiembre, Marina",
                    "Fusió de tres llibres de terror i misteri", LLIBRE, 70, 10);
        } catch (LlibreException ex) {
            System.out.println(ex.getMessage());
        }

        canf1.imprimirLlistaLlibres(false);
        ArrayList<Llibre> cercaLlibres = canf1.cercaLlibres("Carlos");
        canf1.imprimirLlistaLlibres(cercaLlibres);

        //Afegim Pel·lícules
        p = new Pelicula(0, "Mark Neveldine, Brian Taylor", "Professional assassin Chev Chelios "
                + "learns his rival has injected him with a poison that will "
                + "kill him if his heart rate drops.",
                "Crank: Veneno en la sangre", "Película d'acció", PELICULA, 17, 15);
        canf1.addPelicula(p);
        p.addActor("Jason Statham");
        p.addActor("Amy Smart");
        canf1.obtenirPelicula(0).addActor("Carlos Sanz");
        canf1.obtenirPelicula(0).addActor("Jose Cantillo");

        p = new Pelicula(1, "Chad Stahelski, David Leitch", "An ex-hit-man comes "
                + "out of retirement to track down the gangsters that killed his"
                + " dog and took everything from him.", "John Wick (Otro día para matar)", "Película d'acció", PELICULA, 12, 10);
        canf1.addPelicula(p);
        p.addActor("Keanu Reeves");
        p.addActor("Michael Nyqvist");
        p.addActor("Alfie Allen");
        p.addActor("Willem Dafoe");

        p = new Pelicula(2, "Chad Stahelski", "After returning to the criminal "
                + "underworld to repay a debt, John Wick discovers that a "
                + "large bounty has been put on his life.",
                "John Wick: Pacto de sangre", "Película d'acció", PELICULA, 25, 20);
        canf1.addPelicula(p);
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

        //Quarta venta
        Venta venta4 = new Venta();
        d = canf1.obtenirDisc(3);
        p = canf1.obtenirPelicula(1);

        c = new Comanda(p, 2);
        Comanda c1 = new Comanda(d, 3);
        venta4.addComanda(c);
        venta4.addComanda(c1);
        venta4.imprimirTicket();
        try {
            canf1.efectuarVenta(venta4);
            canf1.imprimirLlistaDiscos(false);
            canf1.imprimirLlistaPelicules(false);
        } catch (OutOfStockException ex) {
            System.out.println(ex.getMessage());
        }

        //Cinquena venta
        Venta venta5 = new Venta();
        d = canf1.obtenirDisc(3);
        p = canf1.obtenirPelicula(1);
        l = canf1.obtenirLlibre(9);

        Comanda c2 = new Comanda(l, 9);
        l = (Llibre) canf1.obtenirArticle(7);
        Comanda c3 = new Comanda(l, 5);
        c = new Comanda(p, 2);
        c1 = new Comanda(d, 3);
        venta5.addComanda(c);
        venta5.addComanda(c1);
        venta5.addComanda(c2);
        venta5.addComanda(c3);
        venta5.imprimirTicket();
        try {
            canf1.efectuarVenta(venta5);
        } catch (OutOfStockException ex) {
            System.out.println(ex.getMessage());
        }       
        canf1.imprimirHistorialVentes();
        canf1.imprimirTot(false, false, false);
        canf1.actualitzarSumaStock(canf1.obtenirLlibre(7), 9);
        canf1.imprimirLlistaLlibres(false);
    }

    public static void main(String[] args) {
        provesCanf p = new provesCanf();
        try {
            p.inicialitza();
        } catch (ArticleException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PeliculaException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ComandaException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DiscException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullArticleException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MagatzemException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*p.errors();*/
    }

    public void errors() {     
        Magatzem canf1 = new Magatzem(1, "Canf");
        Disc d;
        Pelicula p;
        Llibre l;
        ArrayList<String> cansons = new ArrayList<>();
        try {
            d = new Disc(2, "James Brown", cansons, "U.S. Discographics",
                    "Motown Disco Version nº3", "Música disco del 1969", DISC, 1, 3);
        canf1.addDisc(d);
        } catch (ArticleException | DiscException ex) {
            System.out.println(ex.getMessage());
        } catch (MagatzemException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Una venta efectuada sense comandes
        Venta venta = new Venta();
        try {
            canf1.efectuarVenta(venta);
            canf1.imprimirHistorialVentes();
        } catch (ComandaException ex) {
            System.out.println(ex.getMessage());
        } catch (OutOfStockException ex) {
            System.out.println(ex.getMessage());
        } catch (ArticleException ex) {
            System.out.println(ex.getMessage());
        }       
    }
    
    public void codiNegatiu() {
        //Per un Article que té el codi en negatiu
        Disc d;
        try {
            d = new Disc(-1, "James Brown", "U.S. Discographics",
                    "Motown Disco Version nº3", "Música disco del 1969", DISC, 10, 30);
        } catch (ArticleException | DiscException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void llistaBuidaCansons() {
        Magatzem canf1 = new Magatzem(1, "Canf");
        Disc d;
        Pelicula p;
        Llibre l;
        //Per la venta d'un Disc que té la llista buida de cançons
        ArrayList<String> cansons = new ArrayList<>();
        try {
            d = new Disc(1, "James Brown", cansons, "U.S. Discographics",
                    "Motown Disco Version nº3", "Música disco del 1969", DISC, 1, 3);
            d = new Disc(2, "James Brown", cansons, "U.S. Discographics",
                    "Motown Disco Version nº3", "Música disco del 1969", DISC, 1, 3);
        canf1.addDisc(d);
        } catch (ArticleException | DiscException ex) {
            System.out.println(ex.getMessage());
        } catch (MagatzemException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void articleInexistent() {
        Magatzem canf1 = new Magatzem(1, "Canf");
        Disc d;
        Pelicula p;
        Llibre l;
        ArrayList<String> cansons = new ArrayList<>();
        try {
            d = new Disc(2, "James Brown", cansons, "U.S. Discographics",
                    "Motown Disco Version nº3", "Música disco del 1969", DISC, 1, 3);
        canf1.addDisc(d);
        } catch (ArticleException | DiscException ex) {
            System.out.println(ex.getMessage());
        } catch (MagatzemException ex) {
            System.out.println(ex.getMessage());
        }
        
        //Una comanda que vol comprar algo que no hi és
        Venta venta = new Venta();
        try {
            Comanda c = new Comanda(canf1.obtenirDisc(1), 1);
        } catch (ComandaException ex) {
            System.out.println(ex.getMessage());
        } catch (NullArticleException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void mateixCodiArticles() {
        Magatzem canf1 = new Magatzem(1, "Canf");
        Disc d;
        Pelicula p;
        Llibre l;
        ArrayList<String> cansons = new ArrayList<>();
        try {
            //Dos discos amb el mateix codi de referència.
            d = new Disc(3, "James Brown", cansons, "U.S. Discographics",
                    "Motown Disco Version nº3", "Música disco del 1969", DISC, 1, 3);
        canf1.addDisc(d);
         d = new Disc(3, "James Black", cansons, "François Discografié",
                    "Motown Disco Version nº55", "Música del 69", DISC, 1, 3);
        canf1.addDisc(d);
        canf1.imprimirLlistaDiscos(false);
                } catch (ArticleException ex) {
            System.out.println(ex.getMessage());
        } catch (DiscException ex) {
            System.out.println(ex.getMessage());
        } catch (MagatzemException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
