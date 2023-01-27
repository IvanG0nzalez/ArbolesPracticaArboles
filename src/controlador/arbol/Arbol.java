/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.arbol;

import controlador.Listas.ListaEnlazada;

/**
 *
 * @author Usuario iTC
 */
public class Arbol {

    private NodoArbol raiz;
    private ListaEnlazada<ListaEnlazada<NodoArbol>> niveles;
    private ListaEnlazada<NodoArbol> orden;
    private Integer altura;
    private Integer nro_nodos;

    public Arbol() {
        raiz = null;
        altura = 0;
        nro_nodos = 0;
        niveles = new ListaEnlazada<>();
        orden = new ListaEnlazada<>();
    }

    private Integer calcularAltura(NodoArbol arbol) throws Exception {
        if (arbol == null) {
            return 0;
        } else {
            Integer izquierda = calcularAltura(arbol.getIzquierda());
            Integer derecha = calcularAltura(arbol.getDerecha());
            if (izquierda > derecha) {
                return izquierda + 1;
            } else {
                return derecha + 1;
            }
        }
    }

    private void calcularNivel(NodoArbol arbol, Integer nivel) throws Exception {
        if (arbol != null) {
            niveles.obtener(nivel).insertar(arbol);
            nivel++;
            calcularNivel(arbol.getIzquierda(), nivel);
            calcularNivel(arbol.getDerecha(), nivel);
        } else if (nivel.intValue() != getAltura().intValue()) {
            niveles.obtener(nivel).insertar(null);
            nivel++;
            calcularNivel(null, nivel);
            calcularNivel(null, nivel);
        }
    }

    private void nivel() throws Exception {
        niveles = new ListaEnlazada<>();
        this.altura = calcularAltura(raiz);
        for (int i = 0; i <= altura; i++) {
            niveles.insertar(new ListaEnlazada<>());
        }
        calcularNivel(raiz, 0);
        try {
            niveles.eliminar(niveles.getSize() - 1);
        } catch (Exception e) {
        }
    }

    public Boolean insertar(Integer valor) throws Exception {
        if (raiz == null) {
            raiz = new NodoArbol(valor);
            nro_nodos++;
            nivel();
            return true;
        } else {
            NodoArbol nuevo = new NodoArbol(valor);
            NodoArbol actual = raiz;
            NodoArbol padre;
            while (true) {
                padre = actual;
                if (valor.intValue() == actual.getDato().intValue()) {
                    return false;
                } else if (valor.intValue() < actual.getDato().intValue()) {
                    actual = actual.getIzquierda();
                    if (actual == null) {
                        nuevo.setPadre(padre);
                        padre.setIzquierda(nuevo);
                        nro_nodos++;
                        nivel();
                        return true;
                    }
                } else {
                    actual = actual.getDerecha();
                    if (actual == null) {
                        nuevo.setPadre(padre);
                        padre.setDerecha(nuevo);
                        nro_nodos++;
                        nivel();
                        return true;
                    }
                }
            }
//           return true;
        }
    }

    public ListaEnlazada<NodoArbol> preOrden() throws Exception {
        orden = new ListaEnlazada<>();
        preOrden(raiz);
        return orden;
    }

    private void preOrden(NodoArbol arbol) throws Exception {
        if (arbol != null) {
            orden.insertar(arbol);
            preOrden(arbol.getIzquierda());
            preOrden(arbol.getDerecha());
        }
    }

    public ListaEnlazada<NodoArbol> postOrden() throws Exception {
        orden = new ListaEnlazada<>();
        postOrden(raiz);
        return orden;
    }

    private void postOrden(NodoArbol arbol) throws Exception {
        if (arbol != null) {
            postOrden(arbol.getIzquierda());
            postOrden(arbol.getDerecha());
            orden.insertar(arbol);
        }
    }

    public ListaEnlazada<NodoArbol> inOrden() throws Exception {
        orden = new ListaEnlazada<>();
        inOrden(raiz);
        return orden;
    }

    private void inOrden(NodoArbol arbol) throws Exception {
        if (arbol != null) {
            inOrden(arbol.getIzquierda());
            orden.insertar(arbol);
            inOrden(arbol.getDerecha());
        }
    }

    public static void main(String[] args) {
        Arbol a = new Arbol();

        try {
            a.insertar(56);
            a.insertar(34);
            a.insertar(78);
            a.insertar(24);
            a.insertar(35);
            a.insertar(60);
            a.insertar(90);
            System.out.println("Numero de nodos: " + a.nro_nodos);
            System.out.println("Altura: " + a.getAltura());
            System.out.println("Niveles: " + a.getNiveles().obtener(2).getSize());
            a.getNiveles().obtener(2).imprimir();
            System.out.println("PRE ORDEN");
            a.preOrden().imprimir();
            System.out.println("POS ORDEN");
            a.postOrden().imprimir();
            System.out.println("IN ORDEN");
            a.inOrden().imprimir();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public ListaEnlazada<ListaEnlazada<NodoArbol>> getNiveles() {
        return niveles;
    }

    public void setNiveles(ListaEnlazada<ListaEnlazada<NodoArbol>> niveles) {
        this.niveles = niveles;
    }

    public ListaEnlazada<NodoArbol> getOrden() {
        return orden;
    }

    public void setOrden(ListaEnlazada<NodoArbol> orden) {
        this.orden = orden;
    }

    public Integer getAltura() throws Exception {
//        altura = calcularAltura(raiz);
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getNro_nodos() {
        return nro_nodos;
    }

    public void setNro_nodos(Integer nro_nodos) {
        this.nro_nodos = nro_nodos;
    }

}
