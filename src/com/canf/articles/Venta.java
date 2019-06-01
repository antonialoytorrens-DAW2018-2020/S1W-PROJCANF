package com.canf.articles;

import com.canf.excepcions.ComandaException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {

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

    public LocalDate getData() {
        return data;
    }

    public double getTotalPreu() {
        return totalPreu;
    }

    @Override
    public String toString() {
        return "Venta{" + "codi=" + codi + ", comanda=" + comanda + ", data=" + data + ", totalPreu=" + totalPreu + '}';
    }
    
}