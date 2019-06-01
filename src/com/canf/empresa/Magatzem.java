package com.canf.empresa;

import com.canf.articles.Article;
import com.canf.articles.Disc;
import com.canf.articles.Llibre;
import com.canf.articles.Pelicula;
import com.canf.articles.Comanda;
import com.canf.articles.Venta;
import static com.canf.articles.tipusArticle.DISC;
import static com.canf.articles.tipusArticle.LLIBRE;
import static com.canf.articles.tipusArticle.PELÍCULA;
import com.canf.excepcions.ComandaException;
import java.util.ArrayList;

/**
 *
 * @author antonialoy
 */
public class Magatzem {

    private int codi;
    private String nom;
    private ArrayList<Article> llistaArticles;
    private ArrayList<Venta> historialVentes;
    private int totalVenta = 0;

    public Magatzem(int codi, String nom, ArrayList<Article> llistaArticles, ArrayList<Venta> historialVentes) {
        this.setNom(nom);
        this.codi = codi;
        this.llistaArticles = new ArrayList<>();
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

    public ArrayList<Article> getLlistaArticles() {
        return llistaArticles;
    }

    public ArrayList<Venta> getHistorialVentes() {
        return historialVentes;
    }
    

    public Disc obtenirDisc(String interpret) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == DISC) {
                Disc y = (Disc) x;
                if (y.getInterpret().equals(interpret)) {
                    return y;
                }
            }
        }
        return null;
    }

    public Pelicula obtenirPelicula(Object participant) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == PELÍCULA) {
                Pelicula y = (Pelicula) x;
                if (y.getLlistaActors().contains(participant)) {
                    return y;
                }
            }
        }
        return null;
    }

    public Llibre obtenirLlibre(String autor) {
        for (Article x : llistaArticles) {
            if (x.getTipusArticle() == LLIBRE) {
                Llibre y = (Llibre) x;
                if (y.getNomAutor().equals(autor)) {
                    return y;
                }
            }
        }
        return null;
    }

    public Article obtenirArticle(int referencia) {
        for (Article x : llistaArticles) {
            if (x.getReferencia() == referencia) {
                return x;
            }
        }
        return null;
    }
    
     public Article obtenirArticle(String titol) {
        for (Article x : llistaArticles) {
            if (x.getNom().equals(titol)) {
                return x;
            }
        }
        return null;
    }

    public void addArticle(Article article) {
        llistaArticles.add(article);
    }

    public void removeArticle(Article article) {
       llistaArticles.remove(article);
    }
    
    public void addVenta(Venta venta) {
        historialVentes.add(venta);
        this.totalVenta++;
    }
    
    public void removeVenta(Venta venta) {
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
    
    public void afegirStock(Comanda comanda) throws ComandaException {
        comanda.canviStock(comanda.getProducte(), comanda.getQuantitat(), false);
    }

    @Override
    public String toString() {
        return "Magatzem{" + "codi=" + codi + ", nom=" + nom + ", llistaArticles=" + llistaArticles + ", historialVentes=" + historialVentes + ", totalVenta=" + totalVenta + '}';
    }

    
}