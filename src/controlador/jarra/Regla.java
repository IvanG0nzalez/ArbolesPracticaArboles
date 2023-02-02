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
public class Regla {
    
    public static ListaEnlazada<NodoJarra> reglas(Jarra jarraG, Jarra jarraP) {
        Integer x = jarraG.getCapacidadActual();
        Integer y = jarraP.getCapacidadActual();
        ListaEnlazada<NodoJarra> lista = new ListaEnlazada<>();
        if(x < jarraG.getCapacidad()){
            lista.insertar(new NodoJarra(jarraG.getCapacidad(), y));
        }
        if(y < jarraP.getCapacidad()){
            lista.insertar(new NodoJarra(x, jarraP.getCapacidad()));
        }
        if(x > 0){
            lista.insertar(new NodoJarra(0, y));
        }
        if(y > 0){
            lista.insertar(new NodoJarra(x, 0));
        }
        if(((x+y) >= jarraG.getCapacidad()) && (x < jarraG.getCapacidad() && y > 0)){
            lista.insertar(new NodoJarra(jarraG.getCapacidad(), y - (jarraG.getCapacidad() - x)));
        }
        if(((x+y) >= jarraP.getCapacidad()) && (y < jarraP.getCapacidad() && y > 0)){
            lista.insertar(new NodoJarra(x - (jarraP.getCapacidad() - y), jarraP.getCapacidad()));
        }
        if(((x+y) <= jarraG.getCapacidad()) && y > 0) {
            lista.insertar(new NodoJarra((x+y), 0));
        }
        if(((x+y) <= jarraP.getCapacidad()) && x > 0) {
            lista.insertar(new NodoJarra(0, (x+y)));
        }
        return lista;
    }
}
