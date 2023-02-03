/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_exchange;

import Controlador.CRUD_Caja;
import Controlador.CRUD_Sucursal;
import Controlador.CRUD_USUARIO;
import Controlador.Conexion_BDD;
import Entidades.Caja;
import Entidades.Sucursal;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



/**
 *
 * @author rolomen
 */
public class digReporteTransacciones extends javax.swing.JDialog {

    /**
     * Creates new form digReporteTransacciones
     */
    private Conexion_BDD con = new Conexion_BDD();
    
    public digReporteTransacciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarComboSucursal();
        cargarComboCaja();
    }
    
    private void cargarComboSucursal(){
        try {
                cmbSucursal.removeAllItems();
                for (Sucursal suc : CRUD_Sucursal.ListaSucursales()) {
                cmbSucursal.addItem(suc.getNombre());
                }
        } catch (Exception e) {
        } 
    }
    
    private void cargarComboCaja(){
        try {
            cmbCaja.removeAllItems();
            for (Caja c : CRUD_Caja.ListaCajas()) {
                cmbCaja.addItem(c.getDescripcion());
            }
        } catch (Exception e) {
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

        btngrbtn = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        datFecha = new datechooser.beans.DateChooserCombo();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbCaja = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        rbtnTransaccion = new javax.swing.JRadioButton();
        rbtnArqueo = new javax.swing.JRadioButton();
        rbtnUtilidad = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte por fecha");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese los parametros del reporte"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setText("Fecha:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(datFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setText("Sucursal:");

        cmbSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setText("Caja:");

        cmbCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de reporte"));

        btngrbtn.add(rbtnTransaccion);
        rbtnTransaccion.setSelected(true);
        rbtnTransaccion.setText("Transaciones compra/venta");

        btngrbtn.add(rbtnArqueo);
        rbtnArqueo.setText("Arqueo de Caja");
        rbtnArqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnArqueoActionPerformed(evt);
            }
        });

        btngrbtn.add(rbtnUtilidad);
        rbtnUtilidad.setText("Utilidad Homogeniedad");
        rbtnUtilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnUtilidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(rbtnTransaccion)
                .addGap(44, 44, 44)
                .addComponent(rbtnArqueo)
                .addGap(39, 39, 39)
                .addComponent(rbtnUtilidad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnTransaccion)
                    .addComponent(rbtnArqueo)
                    .addComponent(rbtnUtilidad))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        Date fecha;

        int idcaja=FORM_PRINCIPAL.idcaja;
        String vNameReporte="";
        
        fecha = new java.sql.Date(datFecha.getSelectedDate().getTimeInMillis());
        System.out.println("La fecha:"+fecha.toString());
        
        this.dispose();
        
        try {
            //ncaja=CRUD_Caja.getidCaja(cmbCaja.getSelectedItem().toString());
            //sucursal = CRUD_Sucursal.getidSucursal(cmbSucursal.getSelectedItem().toString());
            //System.out.println("Sucursal:"+sucursal+"Caja"+idcaja);
            if (rbtnTransaccion.isSelected())
                 vNameReporte = "InformeOpercionesDia.jasper";
             if (rbtnArqueo.isSelected()) 
                 vNameReporte = "ArqueoCajaDia.jasper";
             if(rbtnUtilidad.isSelected())
                 vNameReporte = "UtilidadHomogeniedad.jasper";
                 
              verReporte(idcaja, fecha.toString(), CRUD_Caja.getNombreCaja(idcaja), CRUD_USUARIO.ObtenerUser(Ingreso.idusuario),vNameReporte);   
                 
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void rbtnArqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnArqueoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnArqueoActionPerformed

    private void rbtnUtilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnUtilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnUtilidadActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(digReporteTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(digReporteTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(digReporteTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(digReporteTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
      //  java.awt.EventQueue.invokeLater(new Runnable() {
        //    public void run() {
          //      digReporteTransacciones dialog = new digReporteTransacciones(new javax.swing.JFrame(), false);
            //    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
              //      @Override
                //    public void windowClosing(java.awt.event.WindowEvent e) {
                  //      System.exit(0);
                    //}
               // });
               // dialog.setVisible(true);
            //}
        //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btngrbtn;
    private javax.swing.JComboBox<String> cmbCaja;
    private javax.swing.JComboBox<String> cmbSucursal;
    private datechooser.beans.DateChooserCombo datFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton rbtnArqueo;
    private javax.swing.JRadioButton rbtnTransaccion;
    private javax.swing.JRadioButton rbtnUtilidad;
    // End of variables declaration//GEN-END:variables

   
    // Funcion que genera el reporte solicitado
    private void verReporte(int codcaja, String fecha,String nameCaja, String user,String docreporte) {
              //Variables de inicio del reporte
        JasperReport reporte;
        JasperPrint reporte_view;
        try{
         //direccion del archivo JASPER
          URL  in = this.getClass().getResource("/Reportes/"+docreporte);
          //instancia del reporte
          reporte = (JasperReport) JRLoader.loadObject( in );
          //Se crea un objeto HashMap
          Map <String,Object> parametros = new HashMap<String,Object>();
          // se borrran los parametros.
          parametros.clear();
          //parametros de entrada
          // Se verifica el contenido de los parametros.
          
            if (fecha.equals("") || nameCaja.equals("") || user.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Debe ingresar los datos solicitados","Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (docreporte.equals("UtilidadHomogeniedad.jasper")) {
                    
                    parametros.put( "pFecha", fecha);
                    parametros.put( "pIdCaja", codcaja );
                    
                }else{
                    parametros.put( "pFecha", fecha);
                    parametros.put( "pidCaja", codcaja );
                    parametros.put("pCaja", nameCaja);
                    parametros.put("pCajero", user);
                  
                } 
                reporte_view= JasperFillManager.fillReport(reporte, parametros, con.getConnection());
                JasperViewer.viewReport( reporte_view , false);
                
                
            }
          // Se almacena en la instancia del reporte y se muestra el reporte


	  }catch (JRException ex){
              ex.printStackTrace();
          } catch (ClassNotFoundException ex) {
              ex.printStackTrace();
            Logger.getLogger(digReporteTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(digReporteTransacciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}