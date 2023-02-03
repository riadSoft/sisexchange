/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_exchange;

import Controlador.CRUD_Moneda;
import Controlador.CRUD_USUARIO;
import Entidades.Moneda;
import Utilidades.CellRenderer;
import Utilidades.HeaderCellRenderer;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author EDWARD
 */
public class FormGesionMoneda extends javax.swing.JInternalFrame {

    /**
     * Creates new form FICursos
     */
    public FormGesionMoneda() {
        initComponents();
    }
    public static boolean modif = false;
    DefaultTableModel dtm = null;
    public static int idmoneda = 0;
    public static String desc = "";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblCaja = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSigla = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtCompra = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtVenta = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtOficial = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        dateFechaVigencia = new datechooser.beans.DateChooserCombo();
        chkEstado = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        txtIdMoneda = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Gestion de Monedas");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        tblCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "SIGLA", "COMPRA", "VENTA", "OFICIAL", "FECHA_VIGENCIA", "ESTADO", "USUARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCajaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCaja);
        if (tblCaja.getColumnModel().getColumnCount() > 0) {
            tblCaja.getColumnModel().getColumn(0).setResizable(false);
            tblCaja.getColumnModel().getColumn(1).setResizable(false);
            tblCaja.getColumnModel().getColumn(2).setResizable(false);
            tblCaja.getColumnModel().getColumn(3).setResizable(false);
            tblCaja.getColumnModel().getColumn(4).setResizable(false);
            tblCaja.getColumnModel().getColumn(5).setResizable(false);
            tblCaja.getColumnModel().getColumn(6).setResizable(false);
            tblCaja.getColumnModel().getColumn(7).setResizable(false);
            tblCaja.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Nombre:");

        txtSigla.setEnabled(false);

        jLabel5.setText("Sigla:");

        txtNombre.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Cambio"));

        jLabel6.setText("Compra:");

        txtCompra.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jLabel7.setText("Venta:");

        txtVenta.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jLabel8.setText("Oficial:");

        txtOficial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtOficial.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOficial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtOficial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formatoTextoNumero();
        formatoTextoNumero();
        formatoTextoNumero();

        jLabel4.setText("Fecha Vigencia:");

        chkEstado.setText("Habilitado");
        chkEstado.setEnabled(false);

        jLabel1.setText("Estado:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIdMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addComponent(dateFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkEstado)
                .addGap(71, 71, 71))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtIdMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(chkEstado))
                    .addComponent(dateFechaVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HabilitarBotones(boolean nue, boolean gua, boolean elim) {
        btnNuevo.setEnabled(nue);
        btnGuardar.setEnabled(gua);
        btnEliminar.setEnabled(elim);
    }
    private void formatoTextoNumero(){
        
        NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.ENGLISH);
        // Para la edición, no queremos separadores de millares
        editFormat.setGroupingUsed(false);
        NumberFormatter enFormat = new NumberFormatter(editFormat);
        DefaultFormatterFactory currFactory = new DefaultFormatterFactory(enFormat);
        // El formateador de edición admite caracteres incorrectos
        enFormat.setAllowsInvalid(true);
        //txtCompra.setFormatterFactory(currFactory);
        //txtVenta.setFormatterFactory(currFactory);
        //txtOficial.setFormatterFactory(currFactory);
    }
    private void habilitar(boolean estado){
            
        txtIdMoneda.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtSigla.setEnabled(estado);
        txtCompra.setEnabled(estado);
        txtVenta.setEnabled(estado);
        txtOficial.setEnabled(estado);
        dateFechaVigencia.setEnabled(estado);
        chkEstado.setEnabled(estado);
    }
    private void limpiar(){
        
        txtIdMoneda.setText("Null");
        txtNombre.setText("");
        txtSigla.setText("");
        txtCompra.setText("");
        txtVenta.setText("");
        txtOficial.setText("");
        
    }
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            dtm = (DefaultTableModel) tblCaja.getModel();
            VerDatos();
            getModeloTabla();
            txtIdMoneda.setVisible(false);
            habilitar(false);
            HabilitarBotones(true, false, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void tblCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCajaMouseClicked
        // TODO add your handling code here:
        habilitar(true);
        txtIdMoneda.setEditable(false);
        HabilitarBotones(true, true, true);
        int row = tblCaja.getSelectedRow();
        String estado = "";
        if (row != -1) {
            
            modif=true;
            idmoneda = Integer.parseInt(dtm.getValueAt(row, 0).toString());
            txtIdMoneda.setText((String)tblCaja.getValueAt(row, 0));
            txtNombre.setText((String) tblCaja.getValueAt(row, 1));
            txtSigla.setText((String)tblCaja.getValueAt(row, 2));
            txtCompra.setText((String) tblCaja.getValueAt(row, 3));
            txtVenta.setText((String) tblCaja.getValueAt(row, 4));
            txtOficial.setText((String) tblCaja.getValueAt(row, 5));
            dateFechaVigencia.setText((String) tblCaja.getValueAt(row, 6));
            
            estado = (String) tblCaja.getValueAt(row, 7);
            
            if (estado.equals("1")) {
                chkEstado.setSelected(true);
            } else {
                chkEstado.setSelected(false);
            }

            
        }
        txtNombre.requestFocus();
    }//GEN-LAST:event_tblCajaMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar(true);
        limpiar();
        HabilitarBotones(false, true, false);
        txtIdMoneda.setEditable(false);  
        txtNombre.requestFocus();
        modif=false;
        idmoneda = 0;
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        int estado;
        try {
            java.sql.Date fecha = new java.sql.Date(dateFechaVigencia.getSelectedDate().getTimeInMillis());
            if (chkEstado.isSelected()) {
                estado=1;
            } else {
                estado=0;
            }
            String user = String.valueOf(Ingreso.idusuario);
            boolean gua = CRUD_Moneda.Guardar(new Moneda(idmoneda, txtNombre.getText(), txtSigla.getText(), 
                         BigDecimal.valueOf(Double.parseDouble(txtCompra.getText())), BigDecimal.valueOf(Double.parseDouble(txtVenta.getText())), 
                    BigDecimal.valueOf(Double.parseDouble(txtOficial.getText())), fecha, estado, user));
            if (gua) {
                if (modif) {
                    JOptionPane.showMessageDialog(rootPane, "Datos actualizados correctamente");
                    // Actualizamos la vista monedas
                    FormViewMonedas.VerDatos();
                    //Actualizamos los componentes de la venta de compra/ venta de moneda
                    FormOperacionCambio.getTipoCambioCompra(txtNombre.getText());
                    FormOperacionCambio.actualizarCombos(txtNombre.getText());
                    FormOperacionCambio.getTipoCambioVenta(txtNombre.getText());
                    modif = false;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Datos guardados correctamente");
                }
                VerDatos();
                limpiar();
                habilitar(false);
                HabilitarBotones(true, false, false);
                
                idmoneda=0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Moneda m = new Moneda();
            m.setIdMoneda(idmoneda);
            
            boolean elim = CRUD_Moneda.Eliminar(m);
            if (elim) {
                
                JOptionPane.showMessageDialog(rootPane, "Registro eliminado");
                
                VerDatos();
                limpiar();
                habilitar(false);
                HabilitarBotones(true, false, false);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chkEstado;
    private datechooser.beans.DateChooserCombo dateFechaVigencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCaja;
    private javax.swing.JFormattedTextField txtCompra;
    private javax.swing.JTextField txtIdMoneda;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtOficial;
    private javax.swing.JTextField txtSigla;
    private javax.swing.JFormattedTextField txtVenta;
    // End of variables declaration//GEN-END:variables

    public void VerDatos() throws ClassNotFoundException, SQLException {
        try {
            int nf = tblCaja.getRowCount();
            for (int i = 0; i < nf; i++) {
                dtm.removeRow(0);
            }
            for (Moneda m : CRUD_Moneda.ListaMonedas()) {
                dtm.addRow(m.DatostoArray());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
     public void getModeloTabla() {
        tblCaja.setModel(dtm);
        //color de los bordes de las celdas
        tblCaja.setGridColor(new java.awt.Color(214, 213, 208));
        //tamaño de columnas
        ocultarcolumna(0, tblCaja);
        tblCaja.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblCaja.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblCaja.getColumnModel().getColumn(3).setPreferredWidth(30);
        tblCaja.getColumnModel().getColumn(4).setPreferredWidth(30);
        tblCaja.getColumnModel().getColumn(5).setPreferredWidth(30);
        ocultarcolumna(6, tblCaja);
        tblCaja.getColumnModel().getColumn(7).setPreferredWidth(20);
        ocultarcolumna(8, tblCaja);
        
        //altura de filas
        tblCaja.setRowHeight(20);
        //se asigna el nuevo CellRenderer a cada columna segun su contenido
        tblCaja.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text"));
        tblCaja.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text center bold"));
        tblCaja.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text center bold"));
        tblCaja.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("numero"));
        tblCaja.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("numero"));
        tblCaja.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("numero"));
        tblCaja.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer("text center bold"));
        tblCaja.getColumnModel().getColumn(7).setCellRenderer(new CellRenderer("text center bold"));
        tblCaja.getColumnModel().getColumn(8).setCellRenderer(new CellRenderer("text center bold"));
        //Se asigna nuevo header a la tabla
        JTableHeader jtableHeader = tblCaja.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        tblCaja.setTableHeader(jtableHeader);

    }
      public void ocultarcolumna(int columna, JTable tabla) {
        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(columna).setMinWidth(0);
        tabla.getColumnModel().getColumn(columna).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(columna).setResizable(false);
    }
}