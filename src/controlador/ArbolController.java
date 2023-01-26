/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.Listas.ListaEnlazada;
import modelo.Arbol;

/**
 *
 * @author Iván González
 */
public class ArbolController {
    
    ListaEnlazada<Arbol> lista = new ListaEnlazada<>();

    public ArbolController() {
    }
    
    public ListaEnlazada<Arbol> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Arbol> lista) {
        this.lista = lista;
    }
    
    
}
