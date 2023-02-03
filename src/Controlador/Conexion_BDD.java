/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EDWARD
 */
public class Conexion_BDD {
    
   private static String fichero =   "configuracion.properties";
   private static FileInputStream f;
   private static Properties propiedades;
   
   
   private static Connection cn = null;

    public Conexion_BDD(Properties propiedades) {
        this.propiedades = propiedades;
    }

    public Conexion_BDD() {
    }
    
    // funcion para obtener la conexion
    private static Connection getConexion(){
        try {
            //Cargar el archivo de propiedades           
           propiedades = new Properties();
           InputStream propertiesStream = ClassLoader.getSystemResourceAsStream("configuracion/configuracion.properties");
           propiedades.load(propertiesStream);
           //f.close();
           propertiesStream.close();
           // Obtenemos el controlador de conexion
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url = "jdbc:mysql://"+propiedades.getProperty("server")+":"+propiedades.getProperty("puerto")+"/"+propiedades.getProperty("bdd");
           //String url = "jdbc:mysql://"+"192.168.1.68"+":"+"3307"+"/"+"bdd_cambio";
           cn= DriverManager.getConnection(url,propiedades.getProperty("user"),propiedades.getProperty("password"));
           //cn= DriverManager.getConnection(url,"admin","rolomen23");
        } catch (Exception e) {
            System.out.println("Error:"+e);
            JOptionPane.showMessageDialog(null,"Error:"+e);
            
        }
        return cn;      
    }
   public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
      return getConexion();
    }
}
