package com.canf.articles;

<<<<<<< HEAD
import com.canf.excepcions.ComandaException;
=======
import com.canf.excepcions.ArticleException;
import com.canf.excepcions.ValidacioException;
import com.canf.utilitats.Validacions;
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106
import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
<<<<<<< HEAD

    private int codi = 0;
    private ArrayList<Comanda> comanda;
    private LocalDate data;
    private double totalPreu;

    public Venta(ArrayList<Comanda> comanda) {
        this.codi = codi++;
        this.comanda = new ArrayList<>();
        this.data = LocalDate.now();
    }

    public int getCodi() {
        return codi;
    }

    public ArrayList<Comanda> getComanda() {
        return comanda;
    }
    
    public void addComanda(Comanda e) throws ComandaException {
        if (e.getQuantitat() < 0) {
            throw new ComandaException("La venta no s'ha pogut realitzar.");
        } else {
        this.totalPreu += e.getPreu();
        this.comanda.add(e);
        }
    }
    
    public void removeComanda(Comanda e) {
        this.totalPreu -= e.getPreu();
        this.comanda.remove(e);
    }
=======
    private ArrayList<Article> productes;
    private int quantitat = 0;
    private LocalDate data;
    private int totalVentes;

    public Venta(ArrayList<Article> productes) throws ValidacioException, ArticleException {
        this.productes = productes;
        this.setQuantitat(quantitat);
        this.data = LocalDate.now();
        this.totalVentes += totalVentes + quantitat;
        disminuirQuantitat(productes);
    }
    
    public ArrayList<Article> getProductes() {
        return productes;
    }
    
    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) throws ValidacioException {
        if (Validacions.validaInt(quantitat)) {
            this.quantitat = quantitat;
        } else {
            throw new ValidacioException("La quantitat no pot esser inferior a 0.");
        }
    }
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106

    public LocalDate getData() {
        return data;
    }

<<<<<<< HEAD
    public double getTotalPreu() {
        return totalPreu;
=======
    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getTotalVentes() {
        return totalVentes;
    }    
    
    public void disminuirQuantitat(ArrayList<Article> productes) throws ArticleException {
        for (Article producte : productes) {
            producte.setQuantitat(producte.getQuantitat() - 1);
        }
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Venta{" + "codi=" + codi + ", comanda=" + comanda + ", data=" + data + ", totalPreu=" + totalPreu + '}';
=======
        return "Venta{" + "productes=" + productes + ", quantitat=" + quantitat + ", data=" + data + ", totalVentes=" + totalVentes + '}';
>>>>>>> 9c1ad16be3e4f42029240aa83cffac873307b106
    }
    
}
