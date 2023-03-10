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
import controlador.PosicionController;
import controlador.grafo.Adyacencia;
import controlador.grafo.Grafo;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author Iván González
 */
public class FrmGrafoArbol extends javax.swing.JDialog {

    private PosicionController posicionController = new PosicionController();
    private Grafo grafo;
    
    /**
     * Creates new form FrmGrafoArbol
     */
    public FrmGrafoArbol(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        posicionController.crearGrafoLista();
//        posicionController.getGrafo();
    }
    
    public FrmGrafoArbol(java.awt.Frame parent, boolean modal, PosicionController posicionController) {
        super(parent, modal);
        this.posicionController = posicionController;
        this.grafo = posicionController.getGrafo();
        System.out.println(grafo.toString());
        initComponents();
        setLocationRelativeTo(this);
        cargarDatos();
        
    }

    public PosicionController getPosicionController() {
        return posicionController;
    }

    public void setPosicionController(PosicionController posicionController) {
        this.posicionController = posicionController;
    }
    
    private void cargarDatos() {
        mxGraph graph = new mxGraph();
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setSize(new Dimension(800, 400));
        jPanel1.add(graphComponent, BorderLayout.CENTER);
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            for (int i = 0; i <= grafo.numVertices(); i++) {
                Object start = graph.insertVertex(parent, String.valueOf(posicionController.getPosiciones().obtener(i)), String.valueOf(posicionController.getPosiciones().obtener(i)), 100, 100, 80, 30);
                ListaEnlazada<Adyacencia> lista = grafo.adyacentes(i+1);
                for (int j = 0; j < lista.getSize(); j++) {
                    Adyacencia a = lista.obtener(j);
                    Object dest = graph.insertVertex(parent, String.valueOf(posicionController.getPosiciones().obtener(j)), String.valueOf(posicionController.getPosiciones().obtener(j)), 100, 100, 80, 30);
                        graph.insertEdge(parent, null, String.valueOf(a.getPeso()), start, dest);
                }
            }
        } catch (Exception e) {
        } finally {
            graph.getModel().endUpdate();
        }
        morphGraph(graph, graphComponent);
        new mxHierarchicalLayout(graph).execute(graph.getDefaultParent());
    }
    
    private static void morphGraph(mxGraph graph, mxGraphComponent graphComponent) {
        mxIGraphLayout layout = new mxFastOrganicLayout(graph);
        graph.getModel().beginUpdate();
        try {
            layout.execute(graph.getDefaultParent());
        } catch (Exception e) {
        } finally {
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

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 400));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(FrmGrafoArbol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGrafoArbol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGrafoArbol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGrafoArbol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmGrafoArbol dialog = new FrmGrafoArbol(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
