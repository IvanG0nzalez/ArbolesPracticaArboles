/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.Listas.ListaEnlazada;
import controlador.grafo.GrafoNoDirigidoEtiquetado;
import controlador.utiles.Utilidades;
import modelo.Arbol;
import modelo.Posicion;

/**
 *
 * @author Usuario iTC
 */
public class PosicionController {

//    private Arbol arbol;
    private ListaEnlazada<Posicion> posiciones = new ListaEnlazada<>();
    private GrafoNoDirigidoEtiquetado<Posicion> grafo;

    private void crearGrafoLista() {
        grafo = new GrafoNoDirigidoEtiquetado<>(posiciones.getSize(), Posicion.class);
        //Etiquetar el grafo
//        for(int i = 0; i <= arbol.getPosiciones().getSize(); i++){
//            grafo.etiquetarVertice(arbol.getPosiciones().obtener(i).getId(),  arbol.getPosiciones().obtener(i));
//        }
        try {
//            for (int i = 0; i <= posiciones.getSize(); i++) {
//                grafo.etiquetarVertice(posiciones.obtener(i).getId(), posiciones.obtener(i));
//            }
            for (int i = 0; i < posiciones.getSize(); i++) {
                grafo.etiquetarVertice((i+1), posiciones.obtener(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Double calcularDistancia(Integer or, Integer de) throws Exception{
        Posicion origen = getGrafo().obtenerEtiqueta(or);
        Posicion destino = getGrafo().obtenerEtiqueta(de);
//        Double latitud = origen.getLatitud() - destino.getLatitud();
//        Double altitud = origen.getLongitud() - destino.getLongitud();
        return Utilidades.calcularDistancia(origen.getLatitud(), destino.getLatitud(), origen.getLongitud(), destino.getLongitud());
    }

    public ListaEnlazada<Posicion> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ListaEnlazada<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

    public GrafoNoDirigidoEtiquetado<Posicion> getGrafo() {
        if (grafo == null) {
            crearGrafoLista();
        }
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<Posicion> grafo) {
        this.grafo = grafo;
    }

    @Override
    public String toString() {
        return "PosicionController{" + "grafo=" + grafo + '}';
    }

    
}
