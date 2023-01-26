/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.Listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Arbol;
import modelo.Posicion;

/**
 *
 * @author Iván González
 */
public class ModeloTablaPosiciones extends AbstractTableModel{
    
    ListaEnlazada<Posicion> lista = new ListaEnlazada<>();

    public ListaEnlazada<Posicion> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Posicion> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "id";
            case 1: return "Latitud";
            case 2: return "Altitud";
            case 3: return "Orientacion";
            default: return null;   
        }
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Posicion p = null;
        try {
            p = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println(e);
        }
        switch(columnIndex){
            case 0: return (p != null) ? p.getId(): "NO DEFINIDO";
            case 1: return (p != null) ? p.getLatitud(): "NO DEFINIDO";
            case 2: return (p != null) ? p.getLongitud(): "NO DEFINIDO";
            case 3: return (p != null) ? p.getOrientacion(): "NO DEFINIDO";
            default: return null;
                
        }
    }
}
