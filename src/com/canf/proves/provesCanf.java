package com.canf.proves;

import com.canf.articles.*;
import static com.canf.articles.tipusArticle.*;
import static com.canf.articles.tipusExtensio.*;
import com.canf.empresa.Magatzem;
import com.canf.excepcions.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class provesCanf {

    private static String DIRECTORI = "/";

    public void guardarContingut(Magatzem mag) throws FileNotFoundException, IOException {
        String desti = "/home/antonialoy/Escriptori/prova1.dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)))) {
            out.writeObject(mag);
        }
    }

    public Magatzem recuperarContingut() throws ClassNotFoundException, FileNotFoundException, IOException {
        Magatzem mag = null;
        String url = "/home/antonialoy/Escriptori/prova1.dat";
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(url)))) {
            try {
                while (true) {
                    mag = (Magatzem) in.readObject();
                }
            } catch (EOFException e) {
                System.out.println("Error a l'input");
            }
        }
        return mag;
    }

    public void inicialitza() throws ArticleException, PeliculaException, ComandaException, DiscException, NullArticleException, MagatzemException, IOException, LlibreException, VentaException, OutOfStockException {
        //Afegim Magatzem       
        Magatzem canf1 = new Magatzem(1, "Canf");
        Pelicula p;
        Disc d;
        Llibre l;

        //Afegim Discos        
        ArrayList<String> llistaCansons = new ArrayList<>();
        llistaCansons.add("Only the Strong Survive");
        d = new Disc(3, "Jerry Butler", llistaCansons, "U.S. Discographics",
                "Motown Disco Version nº3", "Música disco del 1969", DISC, 10, 30);
        canf1.addDisc(d);

        llistaCansons = new ArrayList<>();
        llistaCansons.add("Never Say Goodbye");
        d = new Disc(4, "The Jackson 5", llistaCansons, "Epic Records, Motown, Steeltown Records",
                "The Jackson 5 Hits", "Rythm and blues", DISC, 30, 60);
        canf1.addDisc(d);

        llistaCansons = new ArrayList<>();
        llistaCansons.add("Stayin' Alive");
        llistaCansons.add("You should be dancing");
        d = new Disc(5, "Bee Gees", llistaCansons, "Festival, RSO, Warner Bros., Rhino",
                "The Best of Bee Gees", "Música disco del 1977", DISC, 20, 10);
        canf1.addDisc(d);

        llistaCansons = new ArrayList<>();
        llistaCansons.add("Saved by the bell");
        d = new Disc(6, "Bee Gees", llistaCansons, "Festival, RSO, Warner Bros., Rhino",
                "The Best of Bee Gees v.2", "Música disco del 1977", DISC, 29, 70);
        canf1.addDisc(d);
//        
//        canf1.imprimirLlistaDiscos(false);
//        ArrayList<Disc> cercaDiscos = canf1.cercaDiscos("Bee Gees");
//        canf1.imprimirLlistaDiscos(cercaDiscos);

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

//
//        canf1.imprimirLlistaLlibres(false);
//        ArrayList<Llibre> cercaLlibres = canf1.cercaLlibres("Carlos");
//        canf1.imprimirLlistaLlibres(cercaLlibres);
        //Afegim Pel·lícules
        ArrayList<String> llistaActors = new ArrayList<>();
        llistaActors.add("Carlos Sanz");
        llistaActors.add("Jose Cantillo");
        llistaActors.add("Jason Statham");
        llistaActors.add("Amy Smart");
        p = new Pelicula(0, "Mark Neveldine, Brian Taylor", llistaActors, "Professional assassin Chev Chelios "
                + "learns his rival has injected him with a poison that will "
                + "kill him if his heart rate drops.",
                "Crank: Veneno en la sangre", "Película d'acció", PELICULA, 17, 15);
        canf1.addPelicula(p);

        llistaActors = new ArrayList<>();
        llistaActors.add("Keanu Reeves");
        llistaActors.add("Michael Nyqvist");
        llistaActors.add("Alfie Allen");
        llistaActors.add("Willem Dafoe");
        p = new Pelicula(1, "Chad Stahelski, David Leitch", llistaActors, "An ex-hit-man comes "
                + "out of retirement to track down the gangsters that killed his"
                + " dog and took everything from him.", "John Wick (Otro día para matar)", "Película d'acció", PELICULA, 12, 10);
        canf1.addPelicula(p);

        llistaActors = new ArrayList<>();
        llistaActors.add("Keanu Reeves");
        llistaActors.add("Ruby Rose");
        p = new Pelicula(2, "Chad Stahelski", llistaActors, "After returning to the criminal "
                + "underworld to repay a debt, John Wick discovers that a "
                + "large bounty has been put on his life.",
                "John Wick: Pacto de sangre", "Película d'acció", PELICULA, 25, 20);
        canf1.addPelicula(p);

//
//        ArrayList<Pelicula> cerca = canf1.cercaPelicules("Allen");
//        canf1.imprimirLlistaPelicules(cerca);
//        p = canf1.obtenirPelicula(1);
        //Venta
//        canf1.imprimirLlistaPelicules(false);
        ArrayList<Comanda> comandes = new ArrayList<>();
        Venta venta = null;

        venta = new Venta(comandes, "Miquel");

        Comanda c = new Comanda(p, 1);
        venta.addComanda(c);

        p = canf1.obtenirPelicula(2);
        c = new Comanda(p, 2);
        venta.addComanda(c);
        venta.imprimirTicket();

        //Segona venta
        ArrayList<Comanda> comandes2 = new ArrayList<>();
        Venta venta2 = null;

        venta2 = new Venta(comandes2, "Joana");

        p = canf1.obtenirPelicula(0);
        c = new Comanda(p, 3);
        venta2.addComanda(c);
        venta2.imprimirTicket();

        canf1.efectuarVenta(venta2);

        //Tercera venta
        ArrayList<Comanda> comandes3 = new ArrayList<>();
        Venta venta3 = null;

        venta3 = new Venta(comandes3, "Pere");

        p = canf1.obtenirPelicula(0);
        c = new Comanda(p, 20);
        venta3.addComanda(c);
        venta3.imprimirTicket();
        canf1.efectuarVenta(venta3);

//        canf1.imprimirLlistaPelicules(false);
//        canf1.imprimirHistorialVentes();

        //Quarta venta
        ArrayList<Comanda> comandes4 = new ArrayList<>();
        Venta venta4 = null;

        venta4 = new Venta(comandes4, "Antònia");
        d = canf1.obtenirDisc(3);
        p = canf1.obtenirPelicula(1);

        c = new Comanda(p, 2);
        Comanda c1 = new Comanda(d, 3);
        venta4.addComanda(c);
        venta4.addComanda(c1);
        venta4.imprimirTicket();

        canf1.efectuarVenta(venta4);
//        canf1.imprimirLlistaDiscos(false);
//        canf1.imprimirLlistaPelicules(false);

        //Cinquena venta
        ArrayList<Comanda> comandes5 = new ArrayList<>();
        Venta venta5 = null;
        venta5 = new Venta(comandes5, "Tomeu");

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

        canf1.efectuarVenta(venta5);
//        canf1.imprimirHistorialVentes();
//        canf1.imprimirTot(false, false, false);
        canf1.actualitzarSumaStock(canf1.obtenirLlibre(7), 9);
//        canf1.imprimirLlistaLlibres(false);

        //Guardar contingut
        guardarContingut(canf1);

    }

    public void magatzem() throws ClassNotFoundException, IOException {
        Magatzem canf = recuperarContingut();

        System.out.println(canf.totToXML(SENZILL));
        System.out.println(canf.ventesToXML(SENZILL));
    }

    public static void main(String[] args) {
            try {
                provesCanf p = new provesCanf();
                
                try {
                    p.inicialitza();
                } catch (ArticleException | PeliculaException | ComandaException
                        | DiscException | NullArticleException | MagatzemException
                        | IOException | LlibreException | VentaException | OutOfStockException ex) {
                    System.out.println(ex.getMessage());
                }
                p.recuperarContingut();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(provesCanf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
