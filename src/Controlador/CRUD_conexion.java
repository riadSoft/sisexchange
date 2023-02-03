/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.Conexion_bdd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_conexion {
    private static boolean Nuevo(Conexion_bdd c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO SIS_CONEXION_BDD VALUES (null,?,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,c.getIpserver());
                ps.setInt(2,c.getPuerto());
                ps.setString(3,c.getBdd());
                ps.setString(4,c.getUser());
                ps.setString(5, c.getPassword());
                ps.setInt(6, c.getEstado());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(Conexion_bdd c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE BDD_CAMBIO.SIS_CONEXION_BDD " +
                            "SET " +
                            "IP_SERVER = ?, " +
                            "PUERTO = ?, " +
                            "BASE_DE_DATOS = ?, " +
                            "USER = ?, " +
                            "PASSWORD = ?, " +
                            "ESTADO = ? " +
                            "WHERE ID = ?; ";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,c.getIpserver());
                ps.setInt(2,c.getPuerto());
                ps.setString(3,c.getBdd());
                ps.setString(4,c.getUser());
                ps.setString(5, c.getPassword());
                ps.setInt(6, c.getEstado());
                
                ps.setInt(7,c.getId());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(Conexion_bdd c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID),0) FROM SIS_CONEXION_BDD WHERE ID = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,c.getId());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(Conexion_bdd c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM SIS_CONEXION_BDD WHERE ID = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,c.getId());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    // Obtiene la conexion que se encuentra en estado 1
    private static LinkedList<Object []> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Object []> Lista = new LinkedList<>();
        String sql="SELECT * FROM BDD_CAMBIO.SIS_CONEXION_BDD " +
                        "WHERE ESTADO=1;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   //Lista.add(new Object(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7)));
               }
            }
        }
        return Lista;
    }
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(Conexion_bdd c) throws ClassNotFoundException, SQLException
    {
        if (Existe(c)) {
            return Actualizar(c);
        }else
        {
            return Nuevo(c);
        }
    }
    public static boolean Eliminar(Conexion_bdd c) throws ClassNotFoundException, SQLException
    {
        return DarBaja(c);
    }
    
    public static LinkedList<Object []> ListaCajas() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
}
