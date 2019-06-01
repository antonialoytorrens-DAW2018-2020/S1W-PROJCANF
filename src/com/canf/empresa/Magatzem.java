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
    private ArrayList<Venta> ventes;
    private ArrayList<Venta> historialVentes;
    private int totalVenta = 0;

    public Magatzem(int codi, String nom) {
        this.setNom(nom);
        this.codi = codi;
        this.llistaArticles = new ArrayList<>();
        this.ventes = new ArrayList<>();
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

    public void addArticle(Article e) {
        this.llistaArticles.add(e);
    }

    public void removeArticle(Article e) {
        this.llistaArticles.remove(e);
    }

    public void addVentaAHistorial(Venta e) {
        this.historialVentes.add(e);
    }

    public void removeVentaAHistorial(Venta e) {
        this.historialVentes.remove(e);
    }

    public ArrayList<Article> getLlistaArticles() {
        return llistaArticles;
    }

    public ArrayList<Venta> getHistorialVentes() {
        return historialVentes;
    }

    public void addVenta(Venta e) {
        this.ventes.add(e);
    }
    
    public void removeVenta(Venta e) {
        this.ventes.remove(e);
    }
    
    public void efectuarVenta(Venta e) throws ComandaException {
        e.canviarStock();
        removeVenta(e);
        addVentaAHistorial(e);
    }

    public Pelicula addPelicula(String nomDirector, ArrayList<String> llistaActors,
            String sinopsi, String nom, String descripcio, tipusArticle tipusArticle,
            double preuUnitari, int quantitat) throws ArticleException, PeliculaException {
        Pelicula e = new Pelicula(nomDirector, llistaActors, sinopsi, nom, descripcio, tipusArticle, preuUnitari, quantitat);
        this.llistaArticles.add(e);
        return e;
    }

    public Pelicula addPelicula(String nomDirector, String sinopsi, String nom,
            String descripcio, tipusArticle tipusArticle, double preuUnitari,
            int quantitat) throws ArticleException, PeliculaException {
        Pelicula e = new Pelicula(nomDirector, sinopsi, nom, descripcio, tipusArticle, preuUnitari, quantitat);
        this.llistaArticles.add(e);
        return e;
    }

    public int getNumeroComanda(Comanda x) {
        return x.getNumeroComanda();
    }

    public Comanda obtenirComanda(int numero) {
        for (Venta x : ventes) {
            for (Comanda y : x.getLlistaComandes()) {
                if (y.getNumeroComanda() == numero) {
                    return y;
                }
            }
        }
        return null;
    }

    public ArrayList<Disc> obtenirDiscos(String interpret) {
        ArrayList<Disc> discs = new ArrayList<>();
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == DISC) {
                Disc y = (Disc) x;
                if (y.getInterpret().toLowerCase().contains(interpret.toLowerCase())) {
                    discs.add(y);
                    break;
                }
            }
        }
        return discs;
    }

    public ArrayList<Pelicula> cercaPelicules(String x) {
        ArrayList<Pelicula> pelicules = new ArrayList<>();
        for (Article w : llistaArticles) {
            if (w.getTipusArticle() == PELICULA) {
                Pelicula y = (Pelicula) w;
                for (String z : y.getLlistaActors()) {
                    if (z.toLowerCase().contains(x.toLowerCase())) {
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
                    break;
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

    public Article obtenirArticle(String titol) {
        for (Article x : llistaArticles) {
            if (x.getNom().toLowerCase().equals(titol)) {
                return x;
            }
        }
        return null;
    }

    public void addHistorialVenta(Venta venta) {
        historialVentes.add(venta);
        this.totalVenta++;
    }

    public void removeHistorialVenta(Venta venta) {
        historialVentes.remove(venta);
        this.totalVenta--;
    }

    public void disminuirQuantitat(Article y) {
        for (Article x : llistaArticles) {
            if (y.equals(x)) {
                x.setQuantitat(x.getQuantitat() - 1);
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
                System.out.println(x.getReferencia() + "\tStock: " + x.getQuantitat());
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
            System.out.println(x.getReferencia() + "\tStock: " + x.getQuantitat());
            System.out.println(x.getNom());
            for (String actor : x.getLlistaActors()) {
                System.out.println("\t" + actor);
            }
        }
        System.out.println("-----------------------");
    }
    
    public void imprimirHistorialVentes(ArrayList<Venta> llistaHistorial) {
        System.out.println("-----------------------");
        System.out.println("Historial de ventes: ");
        System.out.println("-----------------------");
        for(Venta x : llistaHistorial) {
            System.out.println("Codi: "+x.getCodi()+"\t\tData: "+x.getData()+"\tPreu: "+x.getTotalPreu());
        }
    }
    
        public void imprimirHistorialVentes() {
        System.out.println("-----------------------");
        System.out.println("Historial de ventes: ");
        System.out.println("-----------------------");
        for(Venta x : this.historialVentes) {
            System.out.println("Codi: "+x.getCodi()+"\t\tData: "+x.getData()+"\tPreu: "+x.getTotalPreu());
        }
    }

    @Override
    public String toString() {
        return "Magatzem{" + "codi=" + codi + ", nom=" + nom + ", llistaArticles=" + llistaArticles + ", historialVentes=" + historialVentes + ", totalVenta=" + totalVenta + '}';
    }

}
