/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canf.empresa;

import com.canf.excepcions.EmpresaPrincipalException;
import com.canf.utilitats.Validacions;
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

    public void setNom(String nom) throws EmpresaPrincipalException {
        if(!Validacions.validaCadena(nom)) {
            throw new EmpresaPrincipalException("El nom de l'empresa principal no pot ser null ni estar buit");
        }
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
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
    
    public void validaReferencia(int codi) throws EmpresaPrincipalException {
        for (Magatzem x : magatzems) {
            if (x.getCodi() == codi) {
                throw new EmpresaPrincipalException("El codi del magatzem està repetit");
            }
        }
    }
    

    @Override
    public String toString() {
        return "Principal{" + "nom=" + nom + ", codi=" + codi + ", magatzems=" + magatzems + '}';
    }
    
    
}
