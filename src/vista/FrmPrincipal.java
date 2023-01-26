/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Listas.ListaEnlazada;
import controlador.utiles.Utilidades;
import javax.swing.JOptionPane;
import modelo.Arbol;
import modelo.Posicion;
import controlador.ArbolController;
import controlador.PosicionController;
import modelo.enums.Orientacion;
import vista.modeloTabla.ModeloTablaArboles;
import vista.modeloTabla.ModeloTablaPosiciones;

/**
 *
 * @author Usuario iTC
 */
public class FrmPrincipal extends javax.swing.JFrame {

//    private ListaEnlazada<Arbol> lista = new ListaEnlazada<>();
    private PosicionController posicionController = new PosicionController();
    private ArbolController arbolController = new ArbolController();
    private ModeloTablaArboles mta = new ModeloTablaArboles();
    private ModeloTablaPosiciones mtp = new ModeloTablaPosiciones();
    private DiaPosicion diaPosicion;
    private Arbol arbol;

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        setLocationRelativeTo(this);
        cargarArboles();
        cargarPosiciones();
//        cargarTablaArboles();
        panelPosiciones.setVisible(false);
    }

    private void habilitarBotones() {
        btnAgregarPosiciones.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }

    private void cargarArboles() {
        if (Utilidades.cargarJson().getLista() != null) {
            this.arbolController.setLista(Utilidades.cargarJson().getLista());
            arbolController.getLista().imprimir();
            habilitarBotones();
            limpiar();
        }
    }

    //lista de posiciones global
    private void cargarPosiciones() {
        if (Utilidades.cargarJsonposicionController().getPosiciones() != null) {
            this.posicionController.setPosiciones(Utilidades.cargarJsonposicionController().getPosiciones());
            posicionController.getPosiciones().imprimir();
        }
    }

    private void cargarTablaArboles() {
        mta.setLista(arbolController.getLista());
        tblArboles.setModel(mta);
        tblArboles.updateUI();
    }

    private void cargarTablaPosiciones() throws Exception {
        mtp.setLista(arbolController.getLista().obtener(tblArboles.getSelectedRow()).getPosiciones());
        tblPosiciones.setModel(mtp);
        tblPosiciones.updateUI();
    }

    private void limpiar() {
        txtNombre.setText("");
        txtNombreCientifico.setText("");
        txtDescripcion.setText("");
        cargarTablaArboles();
    }

    private void agregarArbol() {
        Arbol a = new Arbol();
        if (txtDescripcion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtNombreCientifico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            a.setId(arbolController.getLista().getSize() + 1);
            a.setNombre(txtNombre.getText());
            a.setNombreCientifico(txtNombreCientifico.getText());
            a.setDescripcion(txtDescripcion.getText());
            arbolController.getLista().insertar(a);
            this.arbol = a;
//            arbolController.getLista().imprimir();
            Utilidades.guardarJson(arbolController); //guardarEnJson
            habilitarBotones();
            limpiar();
        }
    }

    private void agregarPosiciones() {
        diaPosicion = new DiaPosicion(this, true);
        diaPosicion.setVisible(true);
        Posicion p = diaPosicion.getPosicion();
        try {
            p.setId(arbolController.getLista().obtener(tblArboles.getSelectedRow()).getPosiciones().getSize() + 1);
            arbolController.getLista().obtener(tblArboles.getSelectedRow()).getPosiciones().insertar(p);
//            arbolController.getLista().obtener(tblArboles.getSelectedRow()).getPosiciones().imprimir();
            posicionController.getPosiciones().insertar(p); //añadir las posiciones de todos los árboles a una lista general
//            posicionController.getPosiciones().imprimir();
            Utilidades.guardarJson(this.arbolController); //guardarEnJson los arboles
            Utilidades.guardarJsonPosiciones(this.posicionController); //guardarEnJson los arboles
            cargarTablaArboles();
            cargarTablaPosiciones();
        } catch (Exception e) {
        }
    }

    private void eliminarArbol() throws Exception {
        arbolController.getLista().eliminar(tblArboles.getSelectedRow());
        arbolController.getLista().imprimir();
        Utilidades.guardarJson(arbolController); //guardarEnJson
        cargarTablaArboles();
        cargarTablaPosiciones();
//        System.out.println(tblArboles.getSelectedRow());
    }

    private void modificarArbol() throws Exception {
//        this.arbol = arbolController.getLista().obtener(tblArboles.getSelectedRow());
        DiaModificarArbol diaModificarArbol = new DiaModificarArbol(this, true, arbolController.getLista().obtener(tblArboles.getSelectedRow()));
//        diaModificarArbol.setArbol(arbol);
        System.out.println(diaModificarArbol.getArbol());
        diaModificarArbol.setVisible(true);
        cargarTablaArboles();
        Utilidades.guardarJson(arbolController);
    }

    private void modificarPosicion() throws Exception {
//        Posicion p = arbolController.getLista().obtener(tblArboles.getSelectedRow()).getPosiciones().obtener(tblPosiciones.getSelectedRow());
//        System.out.println(p);
        DiaModificarPosicion diaModificarPosicion = new DiaModificarPosicion(this, true, arbolController.getLista().obtener(tblArboles.getSelectedRow()).getPosiciones().obtener(tblPosiciones.getSelectedRow()));
        diaModificarPosicion.setVisible(true);
        cargarTablaPosiciones();
        Utilidades.guardarJson(arbolController);
    }

    private void eliminarPOsicion() throws Exception {
        arbolController.getLista().obtener(tblArboles.getSelectedRow()).getPosiciones().eliminar(tblPosiciones.getSelectedRow());
        Utilidades.guardarJson(arbolController); //guardarEnJson
        cargarTablaPosiciones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtNombreCientifico = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArboles = new javax.swing.JTable();
        btnAgregarPosiciones = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVerAdyacencia = new javax.swing.JButton();
        panelPosiciones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPosiciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Árboles");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Arbol"));
        jPanel3.setLayout(null);

        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(40, 20, 130, 30);

        jLabel3.setText("Nombre Cientifico:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(40, 60, 130, 30);
        jPanel3.add(txtDescripcion);
        txtDescripcion.setBounds(170, 100, 290, 30);
        jPanel3.add(txtNombre);
        txtNombre.setBounds(170, 20, 290, 30);
        jPanel3.add(txtNombreCientifico);
        txtNombreCientifico.setBounds(170, 60, 290, 30);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);
        btnCancelar.setBounds(240, 140, 100, 29);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar);
        btnAgregar.setBounds(360, 140, 100, 29);

        jLabel5.setText("Descripcion:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(40, 100, 130, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Arboles"));
        jPanel1.setLayout(null);

        tblArboles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblArboles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArbolesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArboles);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 480, 220);

        btnAgregarPosiciones.setText("Agregar Posiciones");
        btnAgregarPosiciones.setEnabled(false);
        btnAgregarPosiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPosicionesActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPosiciones);
        btnAgregarPosiciones.setBounds(340, 250, 150, 29);

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);
        btnModificar.setBounds(230, 250, 100, 29);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(130, 250, 90, 29);

        btnVerAdyacencia.setText("Ver Adyacencia");
        btnVerAdyacencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAdyacenciaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerAdyacencia);
        btnVerAdyacencia.setBounds(10, 250, 110, 29);

        panelPosiciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Posiciones"));
        panelPosiciones.setLayout(null);

        tblPosiciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblPosiciones);

        panelPosiciones.add(jScrollPane2);
        jScrollPane2.setBounds(10, 22, 480, 160);

        jButton1.setText("Modificar Posición");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelPosiciones.add(jButton1);
        jButton1.setBounds(310, 190, 180, 29);

        jButton2.setText("Eliminar Posición");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelPosiciones.add(jButton2);
        jButton2.setBounds(144, 190, 150, 29);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPosiciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPosiciones, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregarArbol();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblArbolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArbolesMouseClicked
        // TODO add your handling code here:
        try {
            panelPosiciones.setVisible(true);
            cargarTablaPosiciones();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblArbolesMouseClicked

    private void btnAgregarPosicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPosicionesActionPerformed
        // TODO add your handling code here:
        if (tblArboles.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un árbol de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            agregarPosiciones();
        }

    }//GEN-LAST:event_btnAgregarPosicionesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            if (tblArboles.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un árbol de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modificarArbol();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            if (tblArboles.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un árbol de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                eliminarArbol();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (tblPosiciones.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una posición de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                modificarPosicion();

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (tblPosiciones.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una posición de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                eliminarPOsicion();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnVerAdyacenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAdyacenciaActionPerformed
        // TODO add your handling code here:
//        Posicion posicion = arbolController.getLista().obtener(tblArboles.getSelectedRow()).getPosiciones().obtener(tblPosiciones.getSelectedRow());
//        FrmGrafoArbol frmGrafoArbol = new FrmGrafoArbol(this, true, posicion);
//        frmGrafoArbol.setVisible(true);
//        frmGrafoArbol.
        if (posicionController.getGrafo() != null) {
//            FrmGrafoArbol frmGrafoArbol = new FrmGrafoArbol(this, true, this.posicionController);
//            frmGrafoArbol.setVisible(true);
//            this.posicionController = Utilidades.cargarJsonposicionController();
            DiaAdyacencia diaAdyacencia = new DiaAdyacencia(this, true, this.posicionController);
            diaAdyacencia.setVisible(true);
            this.posicionController = Utilidades.cargarJsonposicionController();
        }
//        posicionController.getPosiciones().imprimir();  
    }//GEN-LAST:event_btnVerAdyacenciaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarPosiciones;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVerAdyacencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelPosiciones;
    private javax.swing.JTable tblArboles;
    private javax.swing.JTable tblPosiciones;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCientifico;
    // End of variables declaration//GEN-END:variables
}
