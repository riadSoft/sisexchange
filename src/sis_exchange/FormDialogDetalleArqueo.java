/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_exchange;

import Controlador.CRUD_Arqueo;
import Controlador.CRUD_Moneda;
import Entidades.Arqueo;
import Utilidades.CellRenderer;
import Utilidades.FullSelectorListener;
import Utilidades.HeaderCellRenderer;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author rolomen
 */
public final class FormDialogDetalleArqueo extends javax.swing.JDialog {

    /**
     * Creates new form FormDialogDetalleArqueo
     */
    public DefaultTableModel dtmarq = null;
    public static double suma=0;
    
    public FormDialogDetalleArqueo(java.awt.Frame parent, boolean modal,String moneda) {
        super(parent, modal);
        initComponents();
        centerComponent(this);
        dtmarq = (DefaultTableModel) tblArqueo.getModel();
        getModeloTablaArqueo();
        try {
            VerDatosArqueo(moneda);
        }catch(ClassNotFoundException | SQLException e){
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblArqueo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle Arqueo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Arqueo Moneda:"));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 200));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        tblArqueo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DENOMINACION", "TIPO", "VALOR", "CANTIDAD", "IDMONEDA", "TOTAL"
            }
        ));
        tblArqueo.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                tblArqueoAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        tblArqueo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArqueoMouseClicked(evt);
            }
        });
        tblArqueo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblArqueoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblArqueoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblArqueoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblArqueo);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total:");
        jPanel3.add(jLabel1);

        txtTotal.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0.0");
        jPanel3.add(txtTotal);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblArqueoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArqueoMouseClicked
        // TODO add your handling code here:
        tblArqueo.editCellAt(tblArqueo.getSelectedRow(),4);
        Component aComp=tblArqueo.getEditorComponent();
        aComp.addFocusListener(new FullSelectorListener());
        aComp.requestFocus();
        getTotal();
    }//GEN-LAST:event_tblArqueoMouseClicked

    private void tblArqueoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblArqueoKeyTyped
        // TODO add your handling code here:
        getTotal();
        sumaTotal();
    }//GEN-LAST:event_tblArqueoKeyTyped

    private void tblArqueoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblArqueoKeyReleased
        // TODO add your handling code here:
        getTotal();
        sumaTotal();
    }//GEN-LAST:event_tblArqueoKeyReleased

    private void tblArqueoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblArqueoKeyPressed
        // TODO add your handling code here:
        getTotal();
        sumaTotal();
    }//GEN-LAST:event_tblArqueoKeyPressed

    private void tblArqueoAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_tblArqueoAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblArqueoAncestorMoved

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        FormCierreCajaOptativo.tblDetalleCaja.setValueAt(txtTotal.getText(), FormCierreCajaOptativo.tblDetalleCaja.getSelectedRow(), 4);
        System.out.println("Total:"+txtTotal.getText());
        //this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    public void VerDatosArqueo(String moneda) throws ClassNotFoundException, SQLException {
        try {
            int nf = tblArqueo.getRowCount();
            for (int i = 0; i < nf; i++) {
                dtmarq.removeRow(0);
            }
            for (Arqueo arq : CRUD_Arqueo.ListaporMoneda(CRUD_Moneda.ObtenerId(moneda))) {
                dtmarq.addRow(arq.DatostoArray());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            //JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }
    public void getModeloTablaArqueo(){
         tblArqueo.setModel(dtmarq);        
        //color de los bordes de las celdas
         tblArqueo.setGridColor(new java.awt.Color(214, 213, 208)); 
        //tamaño de columnas
        /*Oculta la primera columna

        //---*/
         ocultarcolumna(0, tblArqueo);
         tblArqueo.getColumnModel().getColumn(1).setPreferredWidth(30);
         ocultarcolumna(2, tblArqueo);
         ocultarcolumna(3, tblArqueo);
         tblArqueo.getColumnModel().getColumn(4).setPreferredWidth(30);
         ocultarcolumna(5, tblArqueo);
         tblArqueo.getColumnModel().getColumn(6).setPreferredWidth(30);
        //altura de filas
         tblArqueo.setRowHeight(20);
        //se asigna el nuevo CellRenderer a cada columna segun su contenido
         tblArqueo.getColumnModel().getColumn( 0 ).setCellRenderer( new CellRenderer("text") );
         tblArqueo.getColumnModel().getColumn( 1 ).setCellRenderer( new CellRenderer("text center") );
         tblArqueo.getColumnModel().getColumn( 2 ).setCellRenderer( new CellRenderer("text") );
         tblArqueo.getColumnModel().getColumn( 3 ).setCellRenderer( new CellRenderer("text") );
         tblArqueo.getColumnModel().getColumn( 4 ).setCellRenderer( new CellRenderer("text center") );
         tblArqueo.getColumnModel().getColumn( 5 ).setCellRenderer( new CellRenderer("text") );
         tblArqueo.getColumnModel().getColumn( 6 ).setCellRenderer( new CellRenderer("money") );
        //Se asigna nuevo header a la tabla
        JTableHeader jtableHeader =  tblArqueo.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
         tblArqueo.setTableHeader(  jtableHeader );
        
    }
    public void ocultarcolumna(int columna, JTable tabla){
         tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
         tabla.getColumnModel().getColumn(columna).setMinWidth(0);
         tabla.getColumnModel().getColumn(columna).setPreferredWidth(0);
         tabla.getColumnModel().getColumn(columna).setResizable(false);
    }
    public void getTotal (){
        double total=0;
        double valor =0;
        int cantidad=0;
        int row = tblArqueo.getSelectedRow();
        String estado = "";
        if (row != -1) {
            valor = Double.parseDouble( (String) tblArqueo.getValueAt(row, 3));
            cantidad = Integer.parseInt( (String) tblArqueo.getValueAt(row, 4));
            total = valor*cantidad;
            sumaTotal();
            tblArqueo.setValueAt(String.valueOf(total), row, 6);           
        }
    }
    public void sumaTotal(){
        double monto = 0;
        suma=0;
        
        for (int i = 0; i < tblArqueo.getRowCount(); i++) {
            if ((String) tblArqueo.getValueAt(i, 6)==null) {
                monto = 0;
            } else {
                monto= Double.parseDouble((String) tblArqueo.getValueAt(i, 6));
            }
            suma+=monto;
        }
        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formatea = new DecimalFormat("###,###.##",simbolo);
        formatea.setMinimumFractionDigits(2);
        txtTotal.setText(""+formatea.format(suma)); 
    }
    public static void centerComponent(Component c) { 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        Dimension frameSize = c.getSize(); 

        if (frameSize.height > screenSize.height) { 
        frameSize.height = screenSize.height; 
        } 

        if (frameSize.width > screenSize.width) { 
        frameSize.width = screenSize.width; 
        } 
        c.setLocation( ( screenSize.width - frameSize.width ) / 2, 
        ( screenSize.height - frameSize.height) / 2 ); 
    } 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblArqueo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
