package com.canf.empresa;

import com.canf.articles.*;
import static com.canf.articles.tipusArticle.*;
import com.canf.excepcions.*;
import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public class Magatzem {

    private int codi;
    private String nom;
    private ArrayList<Article> llistaArticles;
    private ArrayList<Venta> cistelles;
    private ArrayList<Venta> historialVentes;

    public Magatzem(int codi, String nom) {
        this.setNom(nom);
        this.codi = codi;
        this.llistaArticles = new ArrayList<>();
        this.cistelles = new ArrayList<>();
        this.historialVentes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public void removeArticle(Article e) {
        this.llistaArticles.remove(e);
    }

    private void addVentaAHistorial(Venta e) throws ComandaException, ArticleException {
        this.historialVentes.add(e);
        for (Comanda comanda : e.getLlistaComandes()) {
            actualitzarStock(comanda.getArticle(), comanda.getQuantitat());
        }

    }

    private void removeVentaAHistorial(Venta e) throws ArticleException {
        this.historialVentes.remove(e);
        for (Comanda comanda : e.getLlistaComandes()) {
            actualitzarStock(comanda.getArticle(), -comanda.getQuantitat());
        }
    }

    public ArrayList<Article> getLlistaArticles() {
        return llistaArticles;
    }

    public ArrayList<Venta> getHistorialVentes() {
        return historialVentes;
    }

    private void addVenta(Venta e) {
        this.cistelles.add(e);
    }

    private void removeVenta(Venta e) {
        this.cistelles.remove(e);
    }

    public void efectuarVenta(Venta e) throws ComandaException, OutOfStockException, ArticleException {
        comprovarStock(e);
        removeVenta(e);
        addVentaAHistorial(e);
    }

    public void cancelarVenta(Venta e) throws ArticleException {
        removeVentaAHistorial(e);
    }

    public Pelicula addPelicula(int referencia, String nomDirector, ArrayList<String> llistaActors,
            String sinopsi, String nom, String descripcio,
            double preuUnitari, int quantitat) throws ArticleException, PeliculaException {
        Pelicula e = new Pelicula(referencia, nomDirector, llistaActors, sinopsi, nom, descripcio, PELICULA, preuUnitari, quantitat);
        this.llistaArticles.add(e);
        return e;
    }

    public Pelicula addPelicula(int referencia, String nomDirector, String sinopsi, String nom,
            String descripcio, double preuUnitari,
            int quantitat) throws ArticleException, PeliculaException {
        Pelicula e = new Pelicula(referencia, nomDirector, sinopsi, nom, descripcio, PELICULA, preuUnitari, quantitat);
        this.llistaArticles.add(e);
        return e;
    }

    public Disc addDisc(Disc x) {
        this.llistaArticles.add(x);
        return x;
    }

    public Llibre addLlibre(Llibre l) {
        this.llistaArticles.add(l);
        return l;
    }

    public ArrayList<Disc> cercaDiscos(String interpret) {
        ArrayList<Disc> discs = new ArrayList<>();
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == DISC) {
                Disc y = (Disc) x;
                if (y.getInterpret().toLowerCase().contains(interpret.toLowerCase())) {
                    discs.add(y);
                }
            }
        }
        return discs;
    }

    public ArrayList<Pelicula> cercaPelicules(String actor) {
        ArrayList<Pelicula> pelicules = new ArrayList<>();
        for (Article w : llistaArticles) {
            if (w.getTipusArticle() == PELICULA) {
                Pelicula y = (Pelicula) w;
                for (String z : y.getLlistaActors()) {
                    if (z.toLowerCase().contains(actor.toLowerCase())) {
                        pelicules.add(y);
                        break;
                    }
                }
            }

        }
        return pelicules;
    }

    public ArrayList<Llibre> cercaLlibres(String autor) {
        ArrayList<Llibre> llibres = new ArrayList<>();
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == LLIBRE) {
                Llibre y = (Llibre) x;
                if (y.getNomAutor().toLowerCase().contains(autor.toLowerCase())) {
                    llibres.add(y);
                }
            }
        }
        return llibres;
    }

    public Article obtenirArticle(int referencia) {
        for (Article x : llistaArticles) {
            if (x.getReferencia() == referencia) {
                return x;
            }
        }
        return null;
    }

    public Article obtenirArticle(String nom) {
        for (Article x : llistaArticles) {
            if (x.getNom().toLowerCase().equals(nom)) {
                return x;
            }
        }
        return null;
    }

    public Pelicula obtenirPelicula(int referencia) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == PELICULA) {
                Pelicula y = (Pelicula) x;
                if (y.getReferencia() == referencia) {
                    return y;
                }
            }

        }
        return null;
    }

    public Llibre obtenirLlibre(int referencia) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == LLIBRE) {
                Llibre y = (Llibre) x;
                if (y.getReferencia() == referencia) {
                    return y;
                }
            }

        }
        return null;
    }

    public Disc obtenirDisc(int referencia) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == DISC) {
                Disc y = (Disc) x;
                if (y.getReferencia() == referencia) {
                    return y;
                }
            }

        }
        return null;
    }

    public int getNumVentesRealitzades() {
        return this.historialVentes.size();
    }

    public void actualitzarStock(Article y, int quantitat) throws ArticleException {
        for (Article x : llistaArticles) {
            if (y.equals(x)) {
                x.setStock(x.getStock() - quantitat);
            }

        }
    }

    private void comprovarStock(Venta e) throws OutOfStockException {
        for (Comanda comanda : e.getLlistaComandes()) {
            if (comanda.getArticle().getStock() < comanda.getQuantitat()) {
                throw new OutOfStockException("No hi ha prou stock de " + comanda.getArticle().getNom());
            }
        }
    }

    public void imprimirLlistaPelicules(boolean actors) {
        System.out.println("-----------------------");
        System.out.println("Llista de pel·lícules: ");
        System.out.println("-----------------------");
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == PELICULA) {
                Pelicula y = (Pelicula) x;
                System.out.println(x.getReferencia() + "\tStock: " + x.getStock());
                System.out.println(x.getNom());
                if (actors) {
                    for (String actor : y.getLlistaActors()) {
                        System.out.println("\t" + actor);
                    }
                }
            }
        }
        System.out.println("-----------------------");
    }

    public void imprimirLlistaPelicules(ArrayList<Pelicula> llista) {
        System.out.println("-----------------------");
        System.out.println("Llista de pel·lícules: ");
        System.out.println("-----------------------");
        for (Pelicula x : llista) {
            System.out.println(x.getReferencia() + "\tStock: " + x.getStock());
            System.out.println(x.getNom());
            for (String actor : x.getLlistaActors()) {
                System.out.println("\t" + actor);
            }
        }
        System.out.println("-----------------------");
    }

    public void imprimirLlistaDiscos(ArrayList<Disc> llista) {
        System.out.println("-----------------------");
        System.out.println("Llista de discos: ");
        System.out.println("-----------------------");
        for (Disc x : llista) {
            System.out.println(x.getReferencia() + "\tStock: " + x.getStock());
            System.out.println(x.getNom());
            for (String canso : x.getLlistaCansons()) {
                System.out.println("\t" + canso);
            }
        }
        System.out.println("-----------------------");
    }

    public void imprimirLlistaDiscos(boolean cansons) {
        System.out.println("-----------------------");
        System.out.println("Llista de discos: ");
        System.out.println("-----------------------");
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == DISC) {
                Disc y = (Disc) x;
                System.out.println(x.getReferencia() + "\tStock: " + x.getStock());
                System.out.println(x.getNom());
                if (cansons) {
                    for (String canso : y.getLlistaCansons()) {
                        System.out.println("\t" + canso);
                    }
                }
            }
        }
        System.out.println("-----------------------");
    }

    public void imprimirLlistaLlibres(ArrayList<Llibre> llista) {
        System.out.println("-----------------------");
        System.out.println("Llista de llibres: ");
        System.out.println("-----------------------");
        for (Llibre x : llista) {
            System.out.println(x.getReferencia() + "\tStock: " + x.getStock());
            System.out.println(x.getNom());
            System.out.println(x.getNomAutor());
        }
        System.out.println("-----------------------");
    }

    public void imprimirLlistaLlibres(boolean autor) {
        System.out.println("-----------------------");
        System.out.println("Llista de llibres: ");
        System.out.println("-----------------------");
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == LLIBRE) {
                Llibre y = (Llibre) x;
                System.out.println(x.getReferencia() + "\tStock: " + x.getStock());
                System.out.println(x.getNom());
                if (autor) {
                    System.out.println("\t" + y.getNomAutor());
                }
            }
        }
        System.out.println("-----------------------");
    }

    public void imprimirTot(boolean actors, boolean cansons, boolean autor) {
        imprimirLlistaPelicules(actors);
        imprimirLlistaDiscos(cansons);
        imprimirLlistaLlibres(autor);
    }

    public void imprimirHistorialVentes(ArrayList<Venta> llistaHistorial) {
        System.out.println("-----------------------");
        System.out.println("Historial de ventes: ");
        System.out.println("-----------------------");
        for (Venta x : llistaHistorial) {
            System.out.println("Codi: " + x.getCodi() + "\t\tData: " + x.getData() + "\tPreu: " + x.getTotalPreu());
        }
    }

    public void imprimirHistorialVentes() {
        System.out.println("-----------------------");
        System.out.println("Historial de ventes: ");
        System.out.println("-----------------------");
        for (Venta x : this.historialVentes) {
            System.out.println("Codi: " + x.getCodi() + "\t\tData: " + x.getData() + "\tPreu: " + x.getTotalPreu());
        }
    }

    @Override
    public String toString() {
        return "Magatzem{" + "codi=" + codi + ", nom=" + nom + ", llistaArticles=" + llistaArticles + ", historialVentes=" + historialVentes + '}';
    }
}
