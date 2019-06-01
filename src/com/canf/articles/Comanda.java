package com.canf.articles;

import com.canf.excepcions.ComandaException;

public class Comanda {

    private Article producte;

    private int numeroComanda;
    private static int comanda = 0;

    private int referenciaProducte;
    private int quantitat;
    private double preu;

    public Comanda(Article producte, int quantitat) throws ComandaException {
        this.numeroComanda = comanda++;
        this.producte = producte;
        this.quantitat = quantitat;
        this.preu = producte.getPreuUnitari();
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public Article getProducte() {
        return producte;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    public double getImportTotal() {
        return producte.getPreuUnitari() * quantitat;
    }

    public void canviStock() throws ComandaException {
        if ((producte.getQuantitat() - quantitat) > 0 && quantitat < producte.getQuantitat()) {
            producte.setQuantitat(producte.getQuantitat() - quantitat);
        } else {
            throw new ComandaException("La venta no s'ha pogut realitzar.");
        }
    }

    @Override
    public String toString() {
        return "Comanda{" + "producte=" + producte + ", quantitat=" + quantitat + ", preu=" + preu + '}';
    }

}
