/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.jarra;

import controlador.Listas.ListaEnlazada;
import modelo.jarra.Jarra;

/**
 *
 * @author Usuario iTC
 */
public class NodoJarra {
    
    private Jarra jGrande;
    private Jarra jPequenia;
    private NodoJarra padre;
    private ListaEnlazada<NodoJarra> sucesores = new ListaEnlazada<>();

    public NodoJarra(){
        jGrande = new Jarra();
        jPequenia = new Jarra();
        jGrande.setCapacidad(4);
        jPequenia.setCapacidad(3);
        jGrande.setCapacidadActual(0);
        jPequenia.setCapacidadActual(0);
    }
    
    public NodoJarra(Integer capacidadJarraGrande, Integer capacidadJarraPequenia){
        this();
        jGrande.setCapacidadActual(capacidadJarraGrande);
        jPequenia.setCapacidadActual(capacidadJarraPequenia);
    }
    
    public static Boolean comparar(NodoJarra i, NodoJarra f) {
        if(i != null && f != null) {
            if(i.getjGrande().getCapacidadActual().intValue() == f.getjGrande().getCapacidadActual().intValue()
                && i.getjPequenia().getCapacidadActual().intValue() == f.getjPequenia().getCapacidadActual().intValue()) {
            return true;
            }
        }
        return false;
    }
    
    
    public void aplicarReglas(ListaEnlazada<NodoJarra> reglas) {
        sucesores = new ListaEnlazada<>();
        if(reglas.getSize() > 0) {
            NodoJarra[] reglasArreglo = reglas.toArray();
            for(int i = 0; i < reglasArreglo.length; i++){
                NodoJarra aux = reglasArreglo[i];
                aux.setPadre(this);
                sucesores.insertarCabecera(aux);
            }
        }
    }
    public void crearJarras(Integer cjg, Integer cjp) {
        jGrande.setCapacidad(cjg);
        jPequenia.setCapacidad(cjp);
    }
    
    public void fijarEstadoJarras(Integer cjg, Integer cjp) {
        jGrande.setCapacidadActual(cjg);
        jPequenia.setCapacidadActual(cjp);
    }
    
    public Jarra getjGrande() {
        return jGrande;
    }

    public void setjGrande(Jarra jGrande) {
        this.jGrande = jGrande;
    }

    public Jarra getjPequenia() {
        return jPequenia;
    }

    public void setjPequenia(Jarra jPequenia) {
        this.jPequenia = jPequenia;
    }

    public NodoJarra getPadre() {
        return padre;
    }

    public void setPadre(NodoJarra padre) {
        this.padre = padre;
    }

    @Override
    public String toString() {
        return "(" + jGrande + " - " + jPequenia + ")";
    }
    
    
}
