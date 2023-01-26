/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;


import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.view.mxGraph;
import controlador.Listas.ListaEnlazada;
import controlador.grafo.Adyacencia;
import controlador.grafo.Grafo;
import controlador.grafo.GrafoDirigidoEtiquetado;
import controlador.grafo.GrafoNoDirigido;
import controlador.grafo.GrafoNoDirigidoEtiquetado;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author Victor
 */
public class frmGrafo extends javax.swing.JDialog {

    /**
     * Creates new form frmPrincipal1
     */
    private Grafo grafo;

    public frmGrafo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public frmGrafo(java.awt.Frame parent, boolean modal, Grafo grafo) {
//        super(parent, modal);
        this.grafo = grafo;
        initComponents();
        cargarDatos();
    }

    private void cargarDatos() {
        
        mxGraph graph = new mxGraph();
        
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        
        graphComponent.setSize(new Dimension(1000, 500));
        
        GrafoNoDirigido gnd = new GrafoNoDirigido(1);
        GrafoNoDirigidoEtiquetado gnde = new GrafoNoDirigidoEtiquetado(1, String.class);
        GrafoDirigidoEtiquetado gde = new GrafoDirigidoEtiquetado(1, String.class);
        
        panelGrafos.add(graphComponent, BorderLayout.CENTER);

        Object parent = graph.getDefaultParent();
        
        graph.getModel().beginUpdate();
        
//        graph.getModel().endUpdate();
        
        try {
            for (int i = 1; i <= grafo.numVertices(); i++) {
                Object Inicio;
                
                if (grafo.getClass() == gnde.getClass() || grafo.getClass() == gde.getClass()) {
                    
                    if (grafo.getClass() == gnde.getClass()) {
                        
                        gnde = (GrafoNoDirigidoEtiquetado) grafo;
                        Inicio = graph.insertVertex(parent, String.valueOf(gnde.obtenerEtiqueta(i)), String.valueOf(gnde.obtenerEtiqueta(i)), 100, 100, 80, 30);
                    } 
                    else {
                        gde = (GrafoDirigidoEtiquetado) grafo;
                        Inicio = graph.insertVertex(parent,String.valueOf(gde.obtenerEtiqueta(i)), String.valueOf(gde.obtenerEtiqueta(i)), 100, 100, 80, 30);
                    }
                }
                else{
                     Inicio = graph.insertVertex(parent, String.valueOf(gnde.obtenerEtiqueta(i)), String.valueOf(gnde.obtenerEtiqueta(i)), 100, 100, 80, 30);
                }
                ListaEnlazada<Adyacencia> lista = grafo.adyacentes(i);

                for (int j = 0; j < lista.getSize(); j++) {
                    
                    Adyacencia a = lista.obtener(j);

                    Object Destino = graph.insertVertex(parent, String.valueOf(gnde.obtenerEtiqueta(i)), String.valueOf(gnde.obtenerEtiqueta(i)), 100, 100, 80, 30);
                    graph.insertEdge(parent, null, String.valueOf(a.getPeso()), Inicio, Destino);

                    if (grafo.getClass() == gnd.getClass() || grafo.getClass() == gnde.getClass()) {
                        
                        graph.insertEdge(parent, null, String.valueOf(a.getPeso()), Destino, Inicio);
//                        Destino = graph.insertVertex(parent, (String.valueOf(gnde.obtenerEtiqueta(i))), String.valueOf(j), 100, 100, 80, 30);
                    }
                    if (grafo.getClass() == gnde.getClass() || grafo.getClass() == gde.getClass()) {
                        
                        if (grafo.getClass() == gnde.getClass()) {
                            gnde = (GrafoNoDirigidoEtiquetado) grafo;
//                            Destino = graph.insertVertex(parent, String.valueOf(gnde.obtenerEtiqueta(j)), String.valueOf(gnde.obtenerEtiqueta(j)), 100, 100, 80, 30);
                        } 
                        else {
                            gde = (GrafoDirigidoEtiquetado) grafo;
//                            Destino = graph.insertVertex(parent, String.valueOf(gde.obtenerEtiqueta(i)), String.valueOf(gde.obtenerEtiqueta(i)), 100, 100, 80, 30);
                        }
                    }

//                    start = graph.insertVertex(parent, String.valueOf(j), String.valueOf(j), 100, 100, 80, 30);
//                    System.out.println("a " + a);
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Error en cargar datos " + e);
        } 
        finally {
            graph.getModel().endUpdate();
        }
        morphGraph(graph, graphComponent);
        new mxHierarchicalLayout(graph).execute(graph.getDefaultParent());
        }
            
//            for (int i = 1; i <= grafo.numVertcies(); i++) {
//                
//                Object Inicio = graph.insertVertex(parent, "", i, 100, 100, 80, 30);
//                
//                ListaEnlazada<Adycencia> lista = grafo.adyacentes(i);
//                
//                for (int j = 0; j < lista.getSize(); j++) {
//                    
//                    Adycencia a = lista.obtener(j);
//                    
//                    Object Destino = graph.insertVertex(parent, "", String.valueOf(a.getDestino()), 100, 100, 80, 30);
//                    
////                    graph.insertEdge(parent, null, "d", Inicio, Destino);
//                    
//                    graph.insertEdge(parent, null, String.valueOf(a.getPeso()), Inicio, Destino);
////                    graph.insertEdge(parent, null, String.valueOf(a.getPeso()), Inicio, Destino);
////                    graph.insertEdge(parent, null, String.valueOf(a.getPeso()), Inicio, Destino);
////                    graph.insertEdge(parent, null, "hola", 1, 2);
////                    graph.insertEdge(parent, null, String.valueOf(a.getPeso()), start, dest);
//                }
//            }
//        } 
//        catch (Exception e) {
//        } 
//        finally {
//            graph.getModel().endUpdate();
//        }
//        morphGraph(graph, graphComponent);
//        
//        new mxHierarchicalLayout(graph).execute(graph.getDefaultParent());
//    }

    private static void morphGraph(mxGraph graph, mxGraphComponent graphComponent) {
        
        mxIGraphLayout layout = new mxFastOrganicLayout(graph);
        
        graph.getModel().beginUpdate();
        
        try {
            layout.execute(graph.getDefaultParent());
        } 
        catch (Exception e) {
            
        } 
        finally {
            
            mxMorphing morph = new mxMorphing(graphComponent, 20, 1.5, 20);
            
            morph.addListener(mxEvent.DONE, new mxEventSource.mxIEventListener() {
                
                @Override
                public void invoke(Object o, mxEventObject eo) {
                    
                    graph.getModel().endUpdate();
                }
            });
            morph.startAnimation();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelGrafos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        panelGrafos.setLayout(null);
        jScrollPane1.setViewportView(panelGrafos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 980, 510);

        setSize(new java.awt.Dimension(1016, 542));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmGrafo dialog = new frmGrafo(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelGrafos;
    // End of variables declaration//GEN-END:variables
}
