/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.jarra;

/**
 *
 * @author Usuario iTC
 */
public class Jarra {
    
    private Integer capacidad;
    private Integer capacidadActual;

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(Integer capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    @Override
    public String toString() {
        return "J[" + capacidad + "L] = " + capacidadActual + "L";
    }
    
    
}
