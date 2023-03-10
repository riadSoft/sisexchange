/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_exchange;


import Controlador.CRUD_Caja;
import Controlador.CRUD_CajaCierre;
import Controlador.CRUD_CajaMovimiento;
import Controlador.CRUD_DetalleCaja;
import Controlador.CRUD_Moneda;
import Entidades.Caja;
import Entidades.CajaCierre;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Utilidades.CellRenderer;
import Utilidades.FullSelectorListener;
import Utilidades.HeaderCellRenderer;
import Utilidades.myeditor;
import Utilidades.myrenderer;
import java.awt.Component;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author EDWARD
 */
public final class FormCierreCaja extends javax.swing.JInternalFrame {
    
    public DefaultTableModel dtm = null;
    public JCheckBox jcheck = new JCheckBox();
    public JButton jButton = new JButton();
    public static int idCaja = 0;
    public static double total = 0;
    private TableRowSorter trsFiltro;
    private String moneda="BOLIVIANOS";
    public int nerror=0;
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /**
     * Creates new form FICursos
     */
    public FormCierreCaja() {
        initComponents();
        dtm = (DefaultTableModel) tblDetalleCaja.getModel();
        getModeloTablaSaldo();
        try {

            VerDatosSaldo(FORM_PRINCIPAL.idcaja, CRUD_Caja.getFechaApertura(FORM_PRINCIPAL.idcaja));
                        
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleCaja = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSaldoIngreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSaldoEgreso = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtTotalArqueo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("CERRAR CAJA");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Saldos en caja por moneda"));

        tblDetalleCaja.setBackground(new java.awt.Color(153, 255, 255));
        tblDetalleCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MONEDA", "SALDO INICIAL", "COMPRAS", "VENTAS", "DEBITO", "CREDITO", "SALDO FINAL", "T/C COMPRA", "SALDO EN BOLIVIANOS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleCajaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetalleCaja);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        btnCancelar.setText("CANCELAR");

        btnCerrar.setText("CERRAR CAJA");
        btnCerrar.setEnabled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("(+) Total Ingresos  realizados en Caja:");

        txtSaldoIngreso.setBackground(new java.awt.Color(0, 0, 102));
        txtSaldoIngreso.setForeground(new java.awt.Color(255, 255, 255));
        txtSaldoIngreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSaldoIngreso.setText("0.0");
        txtSaldoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoIngresoActionPerformed(evt);
            }
        });

        jLabel2.setText("(-) Total Gastos realizados en Caja:");

        txtSaldoEgreso.setBackground(new java.awt.Color(0, 0, 102));
        txtSaldoEgreso.setForeground(new java.awt.Color(255, 255, 255));
        txtSaldoEgreso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSaldoEgreso.setText("0.0");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("TOTAL SALDO EN BOLIVINAOS EN CAJA DEL DIA:");

        txtTotalArqueo.setEditable(false);
        txtTotalArqueo.setBackground(new java.awt.Color(0, 0, 0));
        txtTotalArqueo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtTotalArqueo.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalArqueo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalArqueo.setText("0.0");
        txtTotalArqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalArqueoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Bs.-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalArqueo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                                .addComponent(jSeparator1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSaldoEgreso)
                                    .addComponent(txtSaldoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldoEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalArqueo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       /* try {
            dtm = (DefaultTableModel) tblDetalleCaja.getModel();
            //VerDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }*/
    }//GEN-LAST:event_formInternalFrameOpened

    private void tblDetalleCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleCajaMouseClicked
        // TODO add your handling code here:
        int fila=0;
        tblDetalleCaja.editCellAt(tblDetalleCaja.getSelectedRow(),4);
        Component aComp=tblDetalleCaja.getEditorComponent();
        aComp.addFocusListener(new FullSelectorListener());
        aComp.requestFocus();
        fila= tblDetalleCaja.getSelectedRow();
        myeditor.moneda = (String) tblDetalleCaja.getValueAt(fila, 0);
        System.out.println("Eleccion:"+myeditor.moneda);
    }//GEN-LAST:event_tblDetalleCajaMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
       /* boolean estado;
        System.out.println("Cantidad"+nerror);
        //System.out.println(txtTotalArqueo.getText());
        //System.out.println(txtTotalSistema.getText());
        if (txtTotalArqueo.getText().equals(txtTotalSistema.getText()) && nerror == 0) {
            CajaCierre ccierre = new CajaCierre();
            int resp = JOptionPane.showConfirmDialog(null, "??Esta seguro de cerrar la caja?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (resp==0) {
                
                if (guardarsaldos(ccierre)) {
                    //Actualizamos los valores de la caja
                    try {
                            //Llamamos al procedimiento almacenado y actualizamos los sados
                            estado = CRUD_DetalleCaja.pralmSaldo(FORM_PRINCIPAL.idcaja, 0);
                            //Insertamos los salos en la tabla cierre de caja
                            java.util.Date date = new java.util.Date();
                            java.sql.Timestamp fecha = new java.sql.Timestamp(date.getTime());
                            Caja caj = new Caja();
                            caj.setIdCaja(FORM_PRINCIPAL.idcaja);
                            caj.setSaldoFinal(Double.parseDouble(txtTotalSistema.getText().replace(",", "")));
                            caj.setFechaCierre(fecha);
                            caj.setEstado(0);
                            
                            if (CRUD_Caja.ActualizarCajaCierre(caj)) {
                                dispose();
                                FORM_PRINCIPAL.cerrar();
                        } else {
                                System.err.println("No se actualizo la caja");
                        }
                         this.setClosed(true);
                         
                    } catch (Exception e) {
                    } 
                    
                } else {
                     JOptionPane.showMessageDialog(rootPane, "No se pudo cerrar la caja, contactese con su administrador.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Los saldos no son iguales, verifique", "Aviso", JOptionPane.ERROR_MESSAGE);
        }*/
        
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtSaldoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoIngresoActionPerformed

    private void txtTotalArqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalArqueoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalArqueoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTable tblDetalleCaja;
    private javax.swing.JTextField txtSaldoEgreso;
    private javax.swing.JTextField txtSaldoIngreso;
    private javax.swing.JTextField txtTotalArqueo;
    // End of variables declaration//GEN-END:variables
    
    public void VerDatosSaldo(int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException {
        try {
            int nf = tblDetalleCaja.getRowCount();
            for (int i = 0; i < nf; i++) {
                dtm.removeRow(0);
            }
            for (Object [] lista : CRUD_DetalleCaja.ListaporMontos(idcaja,fecha)) {
                dtm.addRow(lista);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            //JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    
    public void getModeloTablaSaldo(){
        tblDetalleCaja.setModel(dtm);        
        //color de los bordes de las celdas
        tblDetalleCaja.setGridColor(new java.awt.Color(214, 213, 208)); 
        //tama??o de columnas
        /*Oculta la primera columna
        tblDetalleCaja.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDetalleCaja.getColumnModel().getColumn(0).setMinWidth(0);
        tblDetalleCaja.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblDetalleCaja.getColumnModel().getColumn(0).setResizable(false);
        //---*/
        tblDetalleCaja.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblDetalleCaja.getColumnModel().getColumn(1).setPreferredWidth(45);
        tblDetalleCaja.getColumnModel().getColumn(4).setPreferredWidth(45);
        tblDetalleCaja.getColumnModel().getColumn(5).setPreferredWidth(45);
        tblDetalleCaja.getColumnModel().getColumn(6).setPreferredWidth(45);
        tblDetalleCaja.getColumnModel().getColumn(7).setPreferredWidth(30);
        tblDetalleCaja.getColumnModel().getColumn(8).setPreferredWidth(45);

        //altura de filas
        tblDetalleCaja.setRowHeight(20);
        //se asigna el nuevo CellRenderer a cada columna segun su contenido
        tblDetalleCaja.getColumnModel().getColumn( 0 ).setCellRenderer( new CellRenderer("text") );
        tblDetalleCaja.getColumnModel().getColumn( 1 ).setCellRenderer( new CellRenderer("numero") );
        tblDetalleCaja.getColumnModel().getColumn( 2 ).setCellRenderer( new CellRenderer("numero") );
        tblDetalleCaja.getColumnModel().getColumn( 3 ).setCellRenderer( new CellRenderer("numero") );
        tblDetalleCaja.getColumnModel().getColumn( 4 ).setCellRenderer( new CellRenderer("numero") );
        tblDetalleCaja.getColumnModel().getColumn( 5 ).setCellRenderer( new CellRenderer("numero") );
        tblDetalleCaja.getColumnModel().getColumn( 6 ).setCellRenderer( new CellRenderer("numero") ); 
        tblDetalleCaja.getColumnModel().getColumn( 7 ).setCellRenderer( new CellRenderer("numero") );
        tblDetalleCaja.getColumnModel().getColumn( 8 ).setCellRenderer( new CellRenderer("numero") );
        // Agreamos un boton a la comuna 5
        TableColumn agregarColumn;
        //agregarColumn = tblDetalleCaja.getColumnModel().getColumn(5);
        //agregarColumn.setCellEditor(new myeditor(tblDetalleCaja));
        //agregarColumn.setCellRenderer(new myrenderer(true));
        //tblDetalleCaja.getColumnModel().getColumn( 6 ).setCellEditor(new DefaultCellEditor(jcheck));
        //tblDetalleCaja.getColumnModel().getColumn( 5 ).setCellRenderer( new CellRenderer("cheks") );
        //Se asigna nuevo header a la tabla
        JTableHeader jtableHeader = tblDetalleCaja.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        tblDetalleCaja.setTableHeader(  jtableHeader );
        
    }
    
    public void ocultarcolumna(int columna, JTable tabla){
         tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
         tabla.getColumnModel().getColumn(columna).setMinWidth(0);
         tabla.getColumnModel().getColumn(columna).setPreferredWidth(0);
         tabla.getColumnModel().getColumn(columna).setResizable(false);
    }
    public void mostrarcolumna(int columna, JTable tabla, int tamano){
        tabla.getColumnModel().getColumn(columna).setMaxWidth(tamano);
        tabla.getColumnModel().getColumn(columna).setMinWidth(tamano);
        tabla.getColumnModel().getColumn(columna).setPreferredWidth(tamano);
        tabla.getColumnModel().getColumn(columna).setResizable(false);
    }

        private void saldoTotalBs(int columna, JTextField text) {
        double monto=0;
        double tpc=0;
        double saldo=0;
        String mont ="";
        try {
            for (int i = 0; i < tblDetalleCaja.getRowCount(); i++) {
                mont= ""+tblDetalleCaja.getValueAt(i, columna);
                System.out.println("Monto:"+mont);
                if (mont.equals("null")) {
                    monto=0;
                   // System.out.println("Correcto");
                } else {
                    //System.out.println("Incorrecto");
                    monto = Double.parseDouble(mont.replace(",", ""));
                }
                //System.out.println("Tipo de cambio:"+tblDetalleCaja.getValueAt(i, 2));
                tpc = Double.parseDouble((String) tblDetalleCaja.getValueAt(i, 2));
                saldo+=tpc*monto;
            }
            DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
            simbolo.setDecimalSeparator('.');
            simbolo.setGroupingSeparator(',');
            DecimalFormat formatea = new DecimalFormat("###,###.##",simbolo);
            formatea.setMinimumFractionDigits(2);
            text.setText(formatea.format(saldo));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private boolean guardarsaldos(CajaCierre ccierre) {
        int idsucursal,idmoneda;
        String s="",m="";
        double saldo;
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp fecha = new java.sql.Timestamp(date.getTime());
        boolean estado=false;
        try {
            for (int i = 0; i < tblDetalleCaja.getRowCount(); i++) {
                s = (String) tblDetalleCaja.getValueAt(i, 1);
                m = (String) tblDetalleCaja.getValueAt(i, 0);
                saldo = Double.parseDouble(s.replace(",", ""));
                idmoneda = CRUD_Moneda.ObtenerId(m);
                idsucursal = 1;
                
                ccierre.setFecha(fecha);
                ccierre.setSaldo(saldo);
                ccierre.setIdSucursal(idsucursal);
                ccierre.setIdCaja(FORM_PRINCIPAL.idcaja);
                ccierre.setIdMoneda(idmoneda);
                estado = CRUD_CajaCierre.Guardar(ccierre);
            }
        } catch (Exception e) {
        }
        return estado;
    }
}
