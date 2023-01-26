/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.Listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Arbol;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaArboles extends AbstractTableModel {
    ListaEnlazada<Arbol> lista = new ListaEnlazada<>();

    public ListaEnlazada<Arbol> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Arbol> lista) {
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
            case 1: return "Nombre";
            case 2: return "Nombre Científico";
            case 3: return "Descripción";
            default: return null;   
        }
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Arbol a = null;
        try {
            a = lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println(e);
        }
        switch(columnIndex){
            case 0: return (a != null) ? a.getId(): "NO DEFINIDO";
            case 1: return (a != null) ? a.getNombre(): "NO DEFINIDO";
            case 2: return (a != null) ? a.getNombreCientifico(): "NO DEFINIDO";
            case 3: return (a != null) ? a.getDescripcion(): "NO DEFINIDO";
            default: return null;
                
        }
    }
}
