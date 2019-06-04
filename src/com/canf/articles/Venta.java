package com.canf.articles;

import com.canf.excepcions.ComandaException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {

    private int codi;    
    private static int numCodi = 0;
    private ArrayList<Comanda> llistaComandes;
    private LocalDate data;

    public Venta(ArrayList<Comanda> comanda) throws ComandaException {
        this.codi = numCodi++;
        this.validarLlistaComandes(comanda);
        this.data = LocalDate.now();
    }

    public int getCodi() {
        return codi;
    }

    public ArrayList<Comanda> getLlistaComandes() {
        return llistaComandes;
    }
    
    private void validarLlistaComandes(ArrayList<Comanda> llistaComandes) throws ComandaException {
        if(llistaComandes==null) {
            throw new ComandaException("La llista de comandes no pot estar buida");
        }
        this.llistaComandes = llistaComandes;
    }
    
    public void addComanda(Comanda e) throws ComandaException {
        if (e.getQuantitat() <= 0) {
            throw new ComandaException("La venta no s'ha pogut realitzar.");
        } else {
        this.llistaComandes.add(e);
        }
    }
    
    public void removeComanda(Comanda e) {
        this.llistaComandes.remove(e);
    }

    public LocalDate getData() {
        return data;
    }

    public double getTotalPreu() {
        double preu = 0;
        for(Comanda comanda : this.llistaComandes) {
            preu = preu + comanda.getQuantitat()*comanda.getPreu();
        }
        return preu;
    }
    
    public int getNumeroItems() {
        int numero = 0;
        for(Comanda comanda : this.llistaComandes) {
            numero = numero + comanda.getQuantitat();
        }
        return numero;
    }
    
    public ArrayList<Article> getLlistaArticles() {
        ArrayList<Article> llistaArticles = new ArrayList<>();
        for(Comanda comanda : this.llistaComandes) {
            llistaArticles.add(comanda.getArticle());
        }
        return llistaArticles;
    }
    
    public void imprimirTicket() {
        System.out.println("\n");
        System.out.println("-------------------------");
        System.out.println("Venta: " + codi + "\t"+ data);
        System.out.println("-------------------------");
        for(Comanda comanda : this.llistaComandes) {
            System.out.println("\t"+comanda.getNumeroComanda()+"\t"+
                comanda.getArticle().getNom()+"\t"+comanda.getQuantitat()+"\t"
                    +comanda.getPreu()+"\t"+comanda.getImportTotal());
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\tTOTAL: \t\t" +getTotalPreu());
        System.out.println("\t\t\t\t\t\tÍTEMS: \t\t" +getNumeroItems());
    }

    @Override
    public String toString() {
        return "Venta{" + "codi=" + codi + ", llistaComandes=" + llistaComandes + ", data=" + data +'}';
    }
    
}