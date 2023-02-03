
package sis_exchange;

import Utilidades.CellRenderer;
import Utilidades.HeaderCellRenderer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ModeloTabla implements IModeloTabla{

    public ModeloTabla() {
    }
    
    @Override
    public void getModeloTabla(JTable ptabla, DefaultTableModel pdtm){
        
        ptabla.setModel(pdtm);
        ptabla.setGridColor(new java.awt.Color(214, 213, 208)); 
        ptabla.setBackground(new java.awt.Color(200, 100, 30));
        JTableHeader jtableHeader = ptabla.getTableHeader();
        jtableHeader.setDefaultRenderer(new HeaderCellRenderer());
        ptabla.setTableHeader(  jtableHeader );
    }
    public static void formatoColumna(JTable tabla,int pNumColum, int pTamano, String pTipo){
        tabla.getColumnModel().getColumn(pNumColum).setPreferredWidth(pTamano);
        tabla.getColumnModel().getColumn(pNumColum).setCellRenderer(new CellRenderer(pTipo));
        tabla.getColumnModel().getColumn(pNumColum).setResizable(false);
        tabla.getColumnModel().setColumnMargin(2);
    }
    public static void ocultarcolumna(int pColumna, JTable pTabla){
         pTabla.getColumnModel().getColumn(pColumna).setMaxWidth(0);
         pTabla.getColumnModel().getColumn(pColumna).setMinWidth(0);
         pTabla.getColumnModel().getColumn(pColumna).setPreferredWidth(0);
         pTabla.getColumnModel().getColumn(pColumna).setResizable(false);
    }

}
