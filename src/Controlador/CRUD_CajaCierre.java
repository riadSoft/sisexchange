    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.CajaCierre;
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
public class CRUD_CajaCierre{
    private static boolean Nuevo(CajaCierre c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO MC_CIERRE VALUES (null,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                
                ps.setTimestamp(1,c.getFecha());
                ps.setDouble(2,c.getSaldo());
                ps.setInt(3,c.getIdSucursal());
                ps.setInt(4,c.getIdCaja());
                ps.setInt(5, c.getIdMoneda());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(CajaCierre c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE MC_CIERRE" +
                    "SET" +
                    "FECHA = ?," +
                    "SALDO = ?," +
                    "ID_SUCURSAL = ?," +
                    "ID_CAJA = ?," +
                    "ID_MONEDA = ?" +
                    "WHERE ID_CIERRE = ?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                ps.setTimestamp(1,c.getFecha());
                ps.setDouble(2,c.getSaldo());
                ps.setInt(3,c.getIdSucursal());
                ps.setInt(4,c.getIdCaja());
                ps.setInt(5, c.getIdMoneda());
                
                ps.setInt(6,c.getIdCierre());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(CajaCierre c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_CIERRE),0) FROM MC_CIERRE WHERE ID_CIERRE = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,c.getIdCierre());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(CajaCierre c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM MC_CIERRE WHERE ID_CIERRE = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,c.getIdCierre());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<CajaCierre> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<CajaCierre> Lista = new LinkedList<>();
        String sql="SELECT * FROM MC_CIERRE";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new CajaCierre(rs.getInt(1), rs.getTimestamp(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
               }
            }
        }
        return Lista;
    }
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(CajaCierre c) throws ClassNotFoundException, SQLException
    {
        if (Existe(c)) {
            return Actualizar(c);
        }else
        {
            return Nuevo(c);
        }
    }
    public static boolean Eliminar(CajaCierre c) throws ClassNotFoundException, SQLException
    {
        return DarBaja(c);
    }
    
    public static LinkedList<CajaCierre> ListaCajaCierres() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
   
}
