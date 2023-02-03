/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_exchange;

import Controlador.CRUD_USUARIO;
import Entidades.Usuario;
import Utilidades.CellRenderer;
import Utilidades.Encriptacion;
import Utilidades.HeaderCellRenderer;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author EDWARD
 */
public class FormGestionUsuarios extends javax.swing.JDialog {

    public static boolean modif = false;
    DefaultTableModel dtm = null;
    public static int idDetalleCaja = 0;
    public static String desc = "";
    
    public FormGestionUsuarios() {
        try {
            initComponents();
            dtm = (DefaultTableModel) tblUsuarios.getModel();
            VerDatos();
            getModeloTabla();
            HabilitarBotones(true, false, false);
        } catch (Exception e) {
            System.out.println("Error en el objto:" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        panelCentro = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        panelInferior = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setTitle("Gestion de Usuarios");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(800, 250));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        panelCentro.setLayout(new java.awt.BorderLayout());

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "USUARIO", "CONTRASENA", "NOMBRE", "APELLIDO", "CELULAR", "FECHA_REGISTRO"
            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblUsuarios);

        panelCentro.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCentro, java.awt.BorderLayout.CENTER);

        panelInferior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelInferior.add(btnNuevo);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelInferior.add(btnGuardar);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelInferior.add(btnEliminar);

        getContentPane().add(panelInferior, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HabilitarBotones(boolean nue, boolean gua, boolean elim) {
        btnNuevo.setEnabled(nue);
        btnGuardar.setEnabled(gua);
        btnEliminar.setEnabled(elim);
    }

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            HabilitarBotones(true, true, true);
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        try {
            dtm.addRow(new Object[]{0,null,null,null,null,null,null});
        } catch (Exception e) {
        }

        HabilitarBotones(false, true, true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        Usuario u = new Usuario();
        Encriptacion encriptacion = new Encriptacion();
        String password="";
        boolean gua = false, est = false;
        try {
            int row = tblUsuarios.getRowCount();
            for (int i = 0; i < row; i++) {
                u.setId((int) tblUsuarios.getValueAt(i, 0));
                u.setLogin(tblUsuarios.getValueAt(i, 1).toString());
                password = encriptacion.encriptarAES(tblUsuarios.getValueAt(i, 2).toString());
                u.setPassword(password);
                u.setNombre(tblUsuarios.getValueAt(i, 3).toString());
                u.setApellidos(tblUsuarios.getValueAt(i, 4).toString());
                u.setCelular(tblUsuarios.getValueAt(i, 5).toString());
                if (((int) tblUsuarios.getValueAt(i, 0)) > 0) {
                    System.out.println("Fecha:"+tblUsuarios.getValueAt(i, 6).toString());
                    u.setFecha_registro(Timestamp.valueOf(tblUsuarios.getValueAt(i, 6).toString()));
                } else {
                    java.util.Date date = new java.util.Date();
                    java.sql.Timestamp fecha = new java.sql.Timestamp(date.getTime());
                    u.setFecha_registro(fecha);
                }
                gua = CRUD_USUARIO.Guardar(u);
            }
            if (gua) {
                JOptionPane.showMessageDialog(rootPane, "Datos guardados correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al guardar el registro verifique los datos", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Usuario u = new Usuario();
        try {
            int row = tblUsuarios.getSelectedRow();
            u.setId((int) tblUsuarios.getValueAt(row, 0));
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro seleccionado?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == 0) {
                if (CRUD_USUARIO.Eliminar(u)) {
                    JOptionPane.showMessageDialog(rootPane, "Registro elminado exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    dtm.removeRow(row);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        tblUsuarios.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text"));

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables

    public void VerDatos() throws ClassNotFoundException, SQLException {
        try {
            int nf = tblUsuarios.getRowCount();
            for (int i = 0; i < nf; i++) {
                dtm.removeRow(0);
            }
            for (Object[] o : CRUD_USUARIO.ListaUsuarios()) {
                dtm.addRow(o);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString());
        }
    }

    public void getModeloTabla() {
        tblUsuarios.setModel(dtm);
        //color de los bordes de las celdas
        tblUsuarios.setGridColor(new java.awt.Color(135, 206, 250));
        //tamaño de columnas

        ocultarcolumna(0, tblUsuarios);
        tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblUsuarios.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblUsuarios.getColumnModel().getColumn(5).setPreferredWidth(30);
        ocultarcolumna(6, tblUsuarios);
        //altura de filas
        tblUsuarios.setRowHeight(25);
        //se asigna el nuevo CellRenderer a cada columna segun su contenido
        tblUsuarios.getColumnModel().getColumn(0).setCellRenderer(new CellRenderer("text"));
        tblUsuarios.getColumnModel().getColumn(1).setCellRenderer(new CellRenderer("text"));
        tblUsuarios.getColumnModel().getColumn(2).setCellRenderer(new CellRenderer("text"));
        tblUsuarios.getColumnModel().getColumn(3).setCellRenderer(new CellRenderer("text"));
        tblUsuarios.getColumnModel().getColumn(4).setCellRenderer(new CellRenderer("text"));
        tblUsuarios.getColumnModel().getColumn(5).setCellRenderer(new CellRenderer("text"));
        tblUsuarios.getColumnModel().getColumn(6).setCellRenderer(new CellRenderer("text"));

        //Se asigna nuevo header a la tabla
        JTableHeader jtableHeader = tblUsuarios.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        tblUsuarios.setTableHeader(jtableHeader);

    }

    public void ocultarcolumna(int columna, JTable tabla) {
        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);
        tabla.getColumnModel().getColumn(columna).setMinWidth(0);
        tabla.getColumnModel().getColumn(columna).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(columna).setResizable(false);
    }
}
