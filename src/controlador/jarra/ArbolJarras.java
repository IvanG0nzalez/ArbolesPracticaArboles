/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.jarra;

import controlador.Listas.ListaEnlazada;

/**
 *
 * @author Usuario iTC
 */
public class ArbolJarras {
    //0 0
    //4 3
    private NodoJarra estadoInicial;
    private NodoJarra estadoFinal;
    private ListaEnlazada<NodoJarra> nodos;
    private ListaEnlazada<NodoJarra> listaNodos;

    public ArbolJarras(NodoJarra estadoInicial, NodoJarra estadoFinal) {
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
        nodos = new ListaEnlazada<>();
        listaNodos = new ListaEnlazada<>();
    }
    
    public NodoJarra busqueda_anchura() throws Exception{
        if(estadoInicial != null && estadoFinal != null) {
            if(NodoJarra.comparar(estadoInicial, estadoFinal)) {
                nodos = new ListaEnlazada<>();
                nodos.insertarCabecera(estadoFinal);
                return estadoFinal;
            } else {
                nodos = new ListaEnlazada<>();
                listaNodos = new ListaEnlazada<>();
                listaNodos.insertar(estadoInicial);
                nodos.insertar(estadoInicial);
                while(listaNodos.getSize() > 0) {
                    NodoJarra actual = listaNodos.eliminar(0);
                    if(NodoJarra.comparar(actual, estadoFinal)) {
                        return actual;
                    } else {
                        ListaEnlazada<NodoJarra> reglas = Regla.reglas(actual.getjGrande(), actual.getjPequenia());
                        reglas = this.eliminarReglasRepetidas(reglas);
                        actual.aplicarReglas(reglas);
                        for (int i = 0; i < reglas.getSize(); i++) {
                            NodoJarra auxR = reglas.obtener(i);
                            nodos.insertar(auxR);
                            listaNodos.insertar(auxR);
                            if(NodoJarra.comparar(auxR, estadoFinal)) {
                                return auxR;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    private ListaEnlazada<NodoJarra> eliminarReglasRepetidas(ListaEnlazada<NodoJarra> reglas) throws Exception {
        ListaEnlazada<NodoJarra> listaRes = new ListaEnlazada<>();
        if(reglas.getSize() > 0) {
            NodoJarra[] reglasA = reglas.toArray();
            for(int i = 0; i < reglasA.length; i++) {
                NodoJarra auxRegla = reglasA[i];
                Boolean band = true;
                for(int j = 0; j < nodos.getSize(); j++) {
                    NodoJarra aux = nodos.obtener(j);
                    if(NodoJarra.comparar(auxRegla, aux)) {
                       band = false;
                       break;
                    }
                }
                if (band) {
                    listaRes.insertarCabecera(auxRegla);
                }
            }
        }
        return listaRes;
    }

    public ListaEnlazada<NodoJarra> camino(NodoJarra nodo) throws Exception {
        ListaEnlazada<NodoJarra> camino = new ListaEnlazada<>();
        NodoJarra n = nodo;
        while (n != null) {
            camino.insertarCabecera(n);
            n = n.getPadre();
        }
        return camino;
    }
    
    public static void main(String[] args) {
        NodoJarra inicial = new NodoJarra(0, 0);
        NodoJarra finall = new NodoJarra(4, 2);
        ArbolJarras arbolJarras = new ArbolJarras(inicial, finall);
        try {
            NodoJarra busqueda = arbolJarras.busqueda_anchura();
            if(busqueda != null) {
                System.out.println("EL CAMINO ES ");
                arbolJarras.camino(busqueda).imprimir();
            } else {
                System.out.println("NO HAY CAMINO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
