/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_Documento {
    private static boolean Nuevo(Documento d) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO CAJ_DOCUMENTOS VALUES (null,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,d.getNombre());
                ps.setDouble(2,d.getEstado());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(Documento d) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE CAJ_DOCUMENTOS " +
                    "SET " +
                    "NOMBRE = ?, " +
                    "ESTADO = ? " +
                    "WHERE ID_DOCUMENTO = ?;";
        
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,d.getNombre());
                ps.setDouble(2,d.getEstado());
                
                ps.setInt(3,d.getIdDocumento());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(Documento d) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_DOCUMENTO),0) FROM CAJ_DOCUMENTOS WHERE ID_DOCUMENTO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,d.getIdDocumento());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(Documento d) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM CAJ_DOCUMENTOS WHERE ID_DOCUMENTO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,d.getIdDocumento());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<Documento> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Documento> Lista = new LinkedList<>();
        String sql="SELECT * FROM CAJ_DOCUMENTOS";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Documento(rs.getInt(1), rs.getString(2), rs.getInt(3)));
               }
            }
        }
        return Lista;
    }
    // retornamos el id del documento seleccionado
    private static int ObtenerId(String nombre) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT ID_DOCUMENTO FROM CAJ_DOCUMENTOS WHERE NOMBRE = ?";
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
    public static boolean Guardar(Documento d) throws ClassNotFoundException, SQLException
    {
        if (Existe(d)) {
            return Actualizar(d);
        }else
        {
            return Nuevo(d);
        }
    }
    public static boolean Eliminar(Documento d) throws ClassNotFoundException, SQLException
    {
        return DarBaja(d);
    }
    
    public static LinkedList<Documento> ListaDocumentos() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    public static int ObtenerIdDocumento(String nombre) throws ClassNotFoundException, SQLException
    {
        return ObtenerId(nombre);
    }
    
}
