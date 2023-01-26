/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaenclasearboles;

import controlador.grafo.GrafoNoDirigidoEtiquetado;
import controlador.utiles.Utilidades;
import vista.FrmPrincipal;
import vista.frmGrafo;

/**
 *
 * @author Usuario iTC
 */
public class PracticaEnClaseArboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        GrafoNoDirigidoEtiquetado gnde = new GrafoNoDirigidoEtiquetado(5, String.class);
//
//        System.out.println(gnde.toString());
//
//        gnde.etiquetarVertice(1, "campoverde");
//        gnde.etiquetarVertice(2, "intriago");
//        gnde.etiquetarVertice(3, "piter");
//        gnde.etiquetarVertice(4, "parquer");
//        gnde.etiquetarVertice(5, "nivelo");
//
//        try {
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(5), gnde.obtenerEtiqueta(2), 10.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(1), gnde.obtenerEtiqueta(2), 100.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(1), gnde.obtenerEtiqueta(4), 15.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(5), 15.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(4), 15.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(3), 15.0);
////            gnde.insertarAristaE(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(1), 20.0);
////            gnde.insertarAristaE(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(3), 25.0);
////            gnde.insertarAristaE(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(4), 35.0);
////            gnde.insertarAristaE(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(4), 20.0);
////            new frmPrincipal(null, true, gnde).setVisible(true);
//            System.out.println(gnde.toString());
//            gnde.caminoMinimo(1, 4).imprimir();
//            new frmGrafo(null, true, gnde).setVisible(true);
//            Utilidades.guardarGrafoJson(gnde);
//        } catch (Exception e) {
//            System.out.println("Error en grafo etiquetado " + e);
//        }

        FrmPrincipal frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
    }

}
