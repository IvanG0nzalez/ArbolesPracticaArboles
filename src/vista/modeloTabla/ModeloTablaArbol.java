/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.Listas.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import controlador.arbol.Arbol;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaArbol extends AbstractTableModel {

    private Arbol arbol;

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    @Override
    public int getRowCount() {
        try {
            return arbol.getAltura();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return arbol.getNro_nodos();
    }

    @Override
    public String getColumnName(int column) {
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Arbol a = arbol;
//        for(int i = 0; i <= a.getNiveles().getSize()-1; i++){
//            for(int j = 0; j <= a.getNro_nodos(); j++){
//                
//            }
//        }
        try {
            if (arbol.getNiveles().obtener(rowIndex).obtener(columnIndex).getDato() == null) {
                return "---";
            } else {
                return arbol.getNiveles().obtener(rowIndex).obtener(columnIndex).getDato();
            }
        } catch (Exception e) {
        }
        return "";
    }

}
