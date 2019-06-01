package com.canf.articles;

import com.canf.excepcions.ComandaException;

public class Comanda {

    private Article producte;
    private int quantitat;
    private boolean opcio;
    private double preu;

    public Comanda(Article producte, int quantitat) throws ComandaException {
        this.producte = producte;
        this.quantitat = quantitat;
        this.opcio = true;
        canviStock(producte, quantitat, opcio);
        this.setPreu();
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

    public void setPreu() {
        this.preu = producte.getPreuUnitari() * quantitat;
    }

    public void canviStock(Article producte, int quantitat, boolean opcio) throws ComandaException {
        if (opcio) {
            if ((producte.getQuantitat() - quantitat) > 0 && quantitat < producte.getQuantitat()) {
                producte.setQuantitat(producte.getQuantitat() - quantitat);
            } else {
                throw new ComandaException("La venta no s'ha pogut realitzar.");
            }
        } else {
            if (quantitat < 0) {
                throw new ComandaException("La compra no s'ha pogut realitzar.");
            } else {
                producte.setQuantitat(producte.getQuantitat() + quantitat);
            }
        }
    }

    @Override
    public String toString() {
        return "Comanda{" + "producte=" + producte + ", quantitat=" + quantitat + ", opcio=" + opcio + ", preu=" + preu + '}';
    }

}