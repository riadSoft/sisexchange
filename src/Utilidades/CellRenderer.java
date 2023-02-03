/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author rolomen
 */
public class CellRenderer extends DefaultTableCellRenderer {
 
    private String tipo="text";
    private Font courier = new Font( "Courier New",Font.PLAIN ,12 );
    private Font normal = new Font( "Arial",Font.PLAIN ,12 );
    private Font bold = new Font( "Arial",Font.BOLD ,12 );
    private Font strong = new Font("Courier New",Font.BOLD,14);
    private JLabel label = new JLabel();
    private JCheckBox jchbox = new JCheckBox();
    private Image imag = new ImageIcon(getClass().getResource("/imagenes/cash.png")).getImage();
    ImageIcon img2=new ImageIcon(imag.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
    //private ImageIcon entrada = new ImageIcon(getClass().getResource("/com/bolivia/app/images/entrada.jpg"));
    
    /** Constructor de clase
     * @param tipo String
     * Ej.: "text", "text center", "hour" , "num" , "icon"
     */
    public CellRenderer( String tipo )
    {
        this.tipo = tipo;
    }
    
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */

    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {   
        if (selected) {                
            this.setBackground( new Color( 50, 153 , 254) );                        
        }
        else
        {
            this.setBackground(Color.white);
        }
        
        if( tipo.equals("hour"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(courier);            
            return this;
        }
                
        if( tipo.equals("text"))
        {
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(bold);            
            return this;
        }
        
        if( tipo.equals("text center"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(normal);            
            return this;
        }
        if( tipo.equals("text center bold"))
        {
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );
            this.setForeground( (selected)?new Color(255,255,255):new Color(0,0,0) );            
            this.setFont(bold);            
            return this;
        }
                
        if( tipo.equals("num"))
        {
                      
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );           
            this.setForeground( (selected)?new Color(255,255,255):new Color(32,117,32) );            
            this.setFont(bold);            
            return this;   
        }
        if( tipo.equals("money"))
        {
            DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
            simbolo.setDecimalSeparator('.');
            simbolo.setGroupingSeparator(',');
            DecimalFormat formatea = new DecimalFormat("###,###.##",simbolo);
            formatea.setMinimumFractionDigits(2);
            this.setHorizontalAlignment( JLabel.RIGHT );
            if (value == null) {
                this.setText("0.00");
            } else {
                this.setText(formatea.format(Double.parseDouble( (String) value)));            
            }
            
            this.setForeground( (selected)?new Color(255,255,255):new Color(25,25,112) );            
            this.setFont(strong);            
            return this;   
        }  
        if( tipo.equals("numero"))
        {
            DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
            simbolo.setDecimalSeparator('.');
            simbolo.setGroupingSeparator(',');
            DecimalFormat formatea = new DecimalFormat("###,###.##",simbolo);
            formatea.setMinimumFractionDigits(2);
            this.setHorizontalAlignment( JLabel.RIGHT );
            if (value == null) {
                this.setText("0.00");
            } else {
                this.setText(formatea.format(Double.parseDouble(""+value)));            
            }
            
            this.setForeground( (selected)?new Color(255,255,255):new Color(106,90,205) );            
            this.setFont(bold);            
            return this;   
        }    
        
        if( tipo.equals("icon"))
        {
            label.setIcon(img2);
            label.setHorizontalAlignment(CENTER);
            return label;
        }
        
        if (tipo.equals("cheks")) {
            
            //jchbox.setSelected(false);
            jchbox.setHorizontalAlignment(CENTER);
            return jchbox;
        }
        
        return this;
    }
}
