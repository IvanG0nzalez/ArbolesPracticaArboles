/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Listas.ListaEnlazada;


/**
 *
 * @author Usuario iTC
 */
public class Arbol {
    
    private Integer id;
    private String nombre;
    private String nombreCientifico;
    private String descripcion;
//    private Posicion posicion;
    private ListaEnlazada<Posicion> posiciones = new ListaEnlazada<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public ListaEnlazada<Posicion> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ListaEnlazada<Posicion> posiciones) {
        this.posiciones = posiciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Arbol{" + "id=" + id + ", nombre=" + nombre + ", nombreCientifico=" + nombreCientifico + ", descripcion=" + descripcion + ", posiciones=" + posiciones + '}';
    }
    
    
}
