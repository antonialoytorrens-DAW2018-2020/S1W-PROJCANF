/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.empresa;

import java.util.HashSet;

/**
 *
 * @author antonialoy
 */
public class Principal {
    private String nom;
    private int codi;
    private HashSet<Magatzem> magatzems;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public HashSet<Magatzem> getMagatzems() {
        return magatzems;
    }
    
    public void addMagatzem(Magatzem m) {
        this.magatzems.add(m);
    }
    
    public void removeMagatzem(Magatzem m) {
        this.magatzems.remove(m);
    }

    @Override
    public String toString() {
        return "Principal{" + "nom=" + nom + ", codi=" + codi + ", magatzems=" + magatzems + '}';
    }
    
    
}
