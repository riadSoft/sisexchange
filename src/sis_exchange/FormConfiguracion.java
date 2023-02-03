/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_exchange;

import Controlador.CRUD_Caja;
import Controlador.CRUD_Configuracion;
import Entidades.Caja;
import Entidades.Configuracion;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rolo
 */
public class FormConfiguracion extends javax.swing.JDialog {

    private int idconf, est;

    public FormConfiguracion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboCaja();
        verDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNIniOper = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNActOper = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoFactura = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbCaja = new javax.swing.JComboBox<>();
        rbtRegistroLog = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        cmbImprimir = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        btnAbrirFile = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCaneclar = new javax.swing.JButton();

        setTitle("CONFIGURACION DE CAJA");

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 20, 0, 20, 0};
        jPanel1Layout.rowHeights = new int[] {0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel2.setText("Nro Inicio Operacion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(8, 43, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        txtNIniOper.setPreferredSize(new java.awt.Dimension(64, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 2.4;
        jPanel1.add(txtNIniOper, gridBagConstraints);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Nro Actual Operacion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(8, 43, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        txtNActOper.setPreferredSize(new java.awt.Dimension(64, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(txtNActOper, gridBagConstraints);

        jLabel3.setText("Tipo de Facturacion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(8, 43, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        cmbTipoFactura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MANUAL", "COMPUTARIZADA", "HIBRIDA" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(cmbTipoFactura, gridBagConstraints);

        jLabel4.setText("Caja:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(8, 43, 0, 0);
        jPanel1.add(jLabel4, gridBagConstraints);

        cmbCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(cmbCaja, gridBagConstraints);

        rbtRegistroLog.setText("Guardar registro de actividad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        jPanel1.add(rbtRegistroLog, gridBagConstraints);

        jLabel5.setText("Impresion de Comprobante/Factura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 7);
        jPanel1.add(jLabel5, gridBagConstraints);

        cmbImprimir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO IMPRIMIR", "IMPRIMIR" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(cmbImprimir, gridBagConstraints);

        jLabel6.setText("Ruta de configuracion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 2, 0);
        jPanel1.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(txtRuta, gridBagConstraints);

        btnAbrirFile.setText("...");
        btnAbrirFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 37);
        jPanel1.add(btnAbrirFile, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAceptar.setText("Guardar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar);

        btnCaneclar.setText("Cancelar");
        btnCaneclar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaneclarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCaneclar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        Configuracion c = new Configuracion();
        try {
            c.setId(idconf);
            c.setIni_oper(Integer.parseInt(txtNIniOper.getText()));
            c.setAct_oper(Integer.parseInt(txtNActOper.getText()));
            if (rbtRegistroLog.isSelected()) {
                c.setReg_log(1);
            } else {
                c.setReg_log(0);
            }
            c.setTip_fact(cmbTipoFactura.getSelectedIndex());
            c.setLink_conf(txtRuta.getText());
            c.setImpresion(cmbImprimir.getSelectedIndex());
            c.setIdCaja(CRUD_Caja.getidCaja(cmbCaja.getSelectedItem().toString()));
            c.setEstado(est);
            c.setIdUsuario(Ingreso.idusuario);
            if (CRUD_Configuracion.Guardar(c)) {
                JOptionPane.showMessageDialog(this, "Se actualizo correctamente los datos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo guardar la informacion verifique los datos.", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCaneclarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaneclarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCaneclarActionPerformed

    private void btnAbrirFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirFileActionPerformed
        // TODO add your handling code here:

// muestra el cuadro de diálogo de archivos, para que el usuario pueda elegir el archivo a abrir
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de configuracion", "properties");
        selectorArchivos.setFileFilter(filtro);

// indica cual fue la accion de usuario sobre el jfilechooser
        int resultado = selectorArchivos.showOpenDialog(this);
        File archivo = selectorArchivos.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
        } // fin de if

        txtRuta.setText(archivo.getAbsolutePath());

    }//GEN-LAST:event_btnAbrirFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirFile;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCaneclar;
    private javax.swing.JComboBox<String> cmbCaja;
    private javax.swing.JComboBox<String> cmbImprimir;
    private javax.swing.JComboBox<String> cmbTipoFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox rbtRegistroLog;
    private javax.swing.JTextField txtNActOper;
    private javax.swing.JTextField txtNIniOper;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables

    private void cargarComboCaja() {
        try {
            cmbCaja.removeAllItems();
            for (Caja c : CRUD_Caja.ListarporCaja()) {
                cmbCaja.addItem(c.getDescripcion());
            }
        } catch (Exception e) {
        }
    }

    private void verDatos() {
        try {

            for (Configuracion cont : CRUD_Configuracion.ListaConfiguracions()) {
                idconf = cont.getId();
                txtNIniOper.setText(String.valueOf(cont.getIni_oper()));
                txtNActOper.setText(String.valueOf(cont.getAct_oper()));
                cmbTipoFactura.setSelectedIndex(cont.getTip_fact());
                txtRuta.setText(cont.getLink_conf());
                est = cont.getEstado();
                cmbCaja.setSelectedItem(CRUD_Caja.getNombreCaja(cont.getIdCaja()));
                cmbImprimir.setSelectedIndex(cont.getImpresion());
                if (cont.getReg_log() == 1) {
                    rbtRegistroLog.setSelected(true);
                } else {
                    rbtRegistroLog.setSelected(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
}
