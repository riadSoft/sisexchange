/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_Empresa {
    private static boolean Nuevo(Empresa e) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO SIS_EMPRESA VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,e.getNombre());
                ps.setString(2, e.getDireccion());
                ps.setString(3, e.getCiudad());
                ps.setString(4, e.getPais());
                ps.setString(5, e.getNit());
                ps.setString(6, e.getAct_ec());
                ps.setString(7, e.getTelefono());
                ps.setString(8, e.getCorreo());
                ps.setString(9, e.getPropietario());
                ps.setString(10, e.getLogo());
                ps.setInt(11, e.getNum_reg());
                ps.setString(12, e.getDescripcion());
                ps.setInt(13, e.getEstado());
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(Empresa e) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE SIS_EMPRESA " +
                            "SET " +
                            "NOMBRE = ?, " +
                            "DIRECCION = ?, " +
                            "CIUDAD = ?, " +
                            "PAIS = ?, " +
                            "NIT = ?, " +
                            "ACT_ECON = ?, " +
                            "TELEFONO = ?, " +
                            "CORREO = ?, " +
                            "PROPIETARIO = ?, " +
                            "LOGO = ?, " +
                            "N_REGISTRO = ?, " +
                            "DESCRIPCION = ?, " +
                            "ESTADO = ? " +
                            "WHERE ID_EMPRESA = ?";
        
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,e.getNombre());
                ps.setString(2, e.getDireccion());
                ps.setString(3, e.getCiudad());
                ps.setString(4, e.getPais());
                ps.setString(5, e.getNit());
                ps.setString(6, e.getAct_ec());
                ps.setString(7, e.getTelefono());
                ps.setString(8, e.getCorreo());
                ps.setString(9, e.getPropietario());
                ps.setString(10, e.getLogo());
                ps.setInt(11, e.getNum_reg());
                ps.setString(12, e.getDescripcion());
                ps.setInt(13, e.getEstado());
                
                ps.setInt(14,e.getId_empresa());
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(Empresa e) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_EMPRESA),0) FROM SIS_EMPRESA WHERE ID_EMPRESA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,e.getId_empresa());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(Empresa e) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM SIS_EMPRESA WHERE ID_EMPRESA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,e.getId_empresa());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<Empresa> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Empresa> Lista = new LinkedList<>();
        String sql="SELECT * FROM SIS_EMPRESA";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Empresa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12),rs.getString(13),rs.getInt(14)));
               }
            }
        }
        return Lista;
    }
    
    public static boolean Guardar(Empresa e) throws ClassNotFoundException, SQLException
    {
        if (Existe(e)) {
            return Actualizar(e);
        }else
        {
            return Nuevo(e);
        }
    }
    public static boolean Eliminar(Empresa e) throws ClassNotFoundException, SQLException
    {
        return DarBaja(e);
    }
    
    public static LinkedList<Empresa> ListaEmpresas() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
   
}
