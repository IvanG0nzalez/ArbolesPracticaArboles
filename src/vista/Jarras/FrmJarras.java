/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Jarras;

import controlador.jarra.ArbolJarras;
import controlador.jarra.NodoJarra;
import controlador.utiles.Utilidades;

/**
 *
 * @author Usuario iTC
 */
public class FrmJarras extends javax.swing.JFrame {

    private ArbolJarras arbolJarras;
    private NodoJarra ei = new NodoJarra();
    private NodoJarra ef = new NodoJarra();
    private NodoJarra respuesta;

    /**
     * Creates new form FrmJarras
     */
    public FrmJarras() {
        initComponents();
        ei.crearJarras(4, 3);
        cargarCombos();
        setLocationRelativeTo(this);
    }

    private void cargarCombos() {
        try {
            Utilidades.cargarComboEstado(cbxEiJGrande, ei.getjGrande());
            Utilidades.cargarComboEstado(cbxEFJGrande, ei.getjGrande());
            Utilidades.cargarComboEstado(cbxEiJPequenia, ei.getjPequenia());
            Utilidades.cargarComboEstado(cbxEFJPequenia, ei.getjPequenia());
        } catch (Exception e) {
        }
    }

    private void ejecutar() {
        Integer eijg = cbxEiJGrande.getSelectedIndex();
        Integer efjg = cbxEFJGrande.getSelectedIndex();
        Integer eijp = cbxEiJPequenia.getSelectedIndex();
        Integer efjp = cbxEFJPequenia.getSelectedIndex();
        ei.fijarEstadoJarras(eijg, eijp);
        ef.fijarEstadoJarras(efjg, efjp);
        arbolJarras = new ArbolJarras(ei, ef);
        try {
            respuesta = arbolJarras.busqueda_anchura();
            if (respuesta != null) {
                System.out.println("EL camino es");
                arbolJarras.camino(respuesta).imprimir();
            } else {
                System.out.println("No hay camino");
            }
        } catch (Exception e) {
            System.out.println(e);
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
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxEiJGrande = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxEFJGrande = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxEiJPequenia = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxEFJPequenia = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estados"));
        jPanel2.setLayout(null);

        jButton1.setText("Buscar Camino");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(434, 220, 150, 29);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Jarra Grande"));
        jPanel3.setLayout(null);

        jLabel1.setText("Estado Inicial");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(20, 40, 110, 30);

        cbxEiJGrande.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEiJGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEiJGrandeActionPerformed(evt);
            }
        });
        jPanel3.add(cbxEiJGrande);
        cbxEiJGrande.setBounds(130, 40, 120, 29);

        jLabel2.setText("Estado Final");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 90, 110, 30);

        cbxEFJGrande.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEFJGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEFJGrandeActionPerformed(evt);
            }
        });
        jPanel3.add(cbxEFJGrande);
        cbxEFJGrande.setBounds(130, 90, 120, 29);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 30, 270, 170);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Jarra Pequeña"));
        jPanel4.setLayout(null);

        jLabel3.setText("Estado Inicial");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(30, 40, 110, 30);

        cbxEiJPequenia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEiJPequenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEiJPequeniaActionPerformed(evt);
            }
        });
        jPanel4.add(cbxEiJPequenia);
        cbxEiJPequenia.setBounds(140, 40, 120, 29);

        jLabel4.setText("Estado Final");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(30, 90, 110, 30);

        cbxEFJPequenia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxEFJPequenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEFJPequeniaActionPerformed(evt);
            }
        });
        jPanel4.add(cbxEFJPequenia);
        cbxEFJPequenia.setBounds(140, 90, 120, 29);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(300, 30, 290, 170);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxEiJGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEiJGrandeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEiJGrandeActionPerformed

    private void cbxEFJGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEFJGrandeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEFJGrandeActionPerformed

    private void cbxEiJPequeniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEiJPequeniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEiJPequeniaActionPerformed

    private void cbxEFJPequeniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEFJPequeniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEFJPequeniaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ejecutar();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmJarras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmJarras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmJarras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmJarras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmJarras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxEFJGrande;
    private javax.swing.JComboBox<String> cbxEFJPequenia;
    private javax.swing.JComboBox<String> cbxEiJGrande;
    private javax.swing.JComboBox<String> cbxEiJPequenia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}