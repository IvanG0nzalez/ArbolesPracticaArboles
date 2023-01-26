/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import controlador.grafo.GrafoNoDirigidoEtiquetado;
import javax.swing.table.AbstractTableModel;
import modelo.Arbol;
import modelo.Posicion;

/**
 *
 * @author Usuario iTC
 */
public class ModeloTablaAdyacencia extends AbstractTableModel {

    private GrafoNoDirigidoEtiquetado<Posicion> gnde;
    private String[] columnas;

    public GrafoNoDirigidoEtiquetado<Posicion> getGnde() {
        return gnde;
    }

    public void setGnde(GrafoNoDirigidoEtiquetado<Posicion> gnde) {
        this.gnde = gnde;
        generarColumnas();
    }

    @Override
    public int getRowCount() {
        return gnde.numVertices();
    }

    @Override
    public int getColumnCount() {
        return gnde.numVertices() + 1;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return columnas[rowIndex+1];
        } else {
            try {
                if (gnde.existeArista(rowIndex+1, columnIndex)) {
                    return gnde.pesoArista(rowIndex+1, columnIndex);
                } else {
                    return "--";
                }
            } catch (Exception e) {
                System.out.println("Error en ver arista");
            }
        }
        return "";
    }

    private String[] generarColumnas(){
        columnas = new String[gnde.numVertices()+1];
        columnas[0] = "--V--";
        for(int i = 1; i < columnas.length; i ++){
            columnas[i] = gnde.obtenerEtiqueta(i).toString();
//            System.out.println(i);
        }
        return columnas;
    }
}
