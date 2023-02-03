/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.ConceptoCaja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_ConceptoCaja {
    private static boolean Nuevo(ConceptoCaja cc) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO CAJ_CONCEPTO VALUES (null,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,cc.getNombre());
                ps.setDouble(2,cc.getEstado());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(ConceptoCaja cc) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE CAJ_CONCEPTO " +
                    "SET " +
                    "NOMBRE = ?, " +
                    "ESTADO = ? " +
                    "WHERE ID_CONCEPTO = ?;";
        
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,cc.getNombre());
                ps.setDouble(2,cc.getEstado());
                
                ps.setInt(3,cc.getIdconcepto());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(ConceptoCaja cc) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_CONCEPTO),0) FROM CAJ_CONCEPTO WHERE ID_CONCEPTO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,cc.getIdconcepto());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(ConceptoCaja cc) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM CAJ_CONCEPTO WHERE ID_CONCEPTO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,cc.getIdconcepto());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<ConceptoCaja> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<ConceptoCaja> Lista = new LinkedList<>();
        String sql="SELECT * FROM CAJ_CONCEPTO ";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new ConceptoCaja(rs.getInt(1), rs.getString(2), rs.getInt(3)));
               }
            }
        }
        return Lista;
    }
    //Obtenemos el id seun el nombre del concepto
    private static int ObtenerID(String nombre) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT ID_CONCEPTO FROM CAJ_CONCEPTO WHERE NOMBRE = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                    ps.setString(1, nombre);
            try (ResultSet rs= ps.executeQuery()){
                    rs.next();
                    r=rs.getInt(1);
            }
        }
        return r;
    }
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(ConceptoCaja cc) throws ClassNotFoundException, SQLException
    {
        if (Existe(cc)) {
            return Actualizar(cc);
        }else
        {
            return Nuevo(cc);
        }
    }
    public static boolean Eliminar(ConceptoCaja cc) throws ClassNotFoundException, SQLException
    {
        return DarBaja(cc);
    }
    
    public static LinkedList<ConceptoCaja> ListaConceptoCajas() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    public static int ObtenerIdConcepto(String nombre) throws ClassNotFoundException, SQLException
    {
        return ObtenerID(nombre);
    }
    
}
