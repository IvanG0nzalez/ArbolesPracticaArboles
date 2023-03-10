/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.enums.Orientacion;

/**
 *
 * @author Usuario iTC
 */
public class Posicion {
    
    private Integer id;
    private Double latitud;
    private Double longitud;
    private Orientacion orientacion;

    public Posicion() {
    }
    
    public Posicion(Double latitud, Double altitud, Orientacion orientacion) {
        this.latitud = latitud;
        this.longitud = altitud;
        this.orientacion = orientacion;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    @Override
    public String toString() {
        return latitud + " / " + longitud + " - " + orientacion;
    }
    
}
