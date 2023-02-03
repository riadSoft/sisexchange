/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.Moneda;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_Moneda {
    private static boolean Nuevo(Moneda m) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO MC_MONEDA VALUES (null,?,?,?,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,m.getNombre());
                ps.setString(2,m.getSigla());
                ps.setBigDecimal(3,m.getCompra());
                ps.setBigDecimal(4,m.getVenta());
                ps.setBigDecimal(5, m.getOficial());
                ps.setDate(6, m.getVigencia());
                ps.setInt(7, m.getEstado());
                ps.setString(8, m.getUsuario());
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(Moneda m) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE MC_MONEDA SET NOM_MONEDA = ?, SIGLA = ?, COMPRA = ?, VENTA = ?, OFICIAL = ?, VIGENCIA = ?,ESTADO = ?, USUARIO = ? WHERE ID_MONEDA = ?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,m.getNombre());
                ps.setString(2,m.getSigla());
                ps.setBigDecimal(3,m.getCompra());
                ps.setBigDecimal(4,m.getVenta());
                ps.setBigDecimal(5, m.getOficial());
                ps.setDate(6, m.getVigencia());
                ps.setInt(7, m.getEstado());
                ps.setString(8, m.getUsuario());
                
                ps.setInt(9,m.getIdMoneda());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(Moneda m) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_MONEDA),0) FROM MC_MONEDA WHERE ID_MONEDA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,m.getIdMoneda());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(Moneda m) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM MC_MONEDA WHERE ID_MONEDA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,m.getIdMoneda());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<Moneda> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Moneda> Lista = new LinkedList<>();
        String sql="SELECT * FROM MC_MONEDA ";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Moneda(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getBigDecimal(6), rs.getDate(7),rs.getInt(8), rs.getString(9)));
               }
            }
        }
        return Lista;
    }
    // Obtener la lista de nombres de moendas de a base de datos
    private static LinkedList<Moneda> ListaporMoneda() throws ClassNotFoundException, SQLException
    {
        LinkedList<Moneda> Lista = new LinkedList<>();
        String sql="SELECT ID_MONEDA,NOM_MONEDA FROM MC_MONEDA WHERE ESTADO=1";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Moneda(rs.getInt(1), rs.getString(2)));
               }
            }
        }
        return Lista;
    }
    //Obetner lista personaizada
    private static LinkedList<Moneda> ListaPersonalizada() throws ClassNotFoundException, SQLException
    {
        LinkedList<Moneda> Lista = new LinkedList<>();
        String sql="SELECT ID_MONEDA,NOM_MONEDA,COMPRA,VENTA,OFICIAL FROM MC_MONEDA WHERE ESTADO=1";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Moneda(rs.getInt(1), rs.getString(2),rs.getBigDecimal(3),rs.getBigDecimal(4),rs.getBigDecimal(5)));
               }
            }
        }
        return Lista;
    }
    // Funcion para obtener el tipo de compra de una moneda
    private static BigDecimal ObtenerCompra(String nomMoneda) throws ClassNotFoundException, SQLException
    {
        BigDecimal r=BigDecimal.ZERO;
        String sql="SELECT COMPRA FROM MC_MONEDA WHERE NOM_MONEDA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,nomMoneda);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getBigDecimal(1);
            }
        }
        return r;
    }
    // Funcion para obtener el tipo de venta de una moneda
    private static BigDecimal ObtenerVenta(String nomMoneda) throws ClassNotFoundException, SQLException
    {
        BigDecimal r=BigDecimal.ZERO;
        String sql="SELECT VENTA FROM MC_MONEDA WHERE NOM_MONEDA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,nomMoneda);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getBigDecimal(1);
            }
        }
        return r;
    }
    // Funcion que obtiene el id de moneda
    private static int ObtenerIdMoneda(String nomMoneda) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT ID_MONEDA FROM MC_MONEDA WHERE NOM_MONEDA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,nomMoneda);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getInt(1);
            }
        }
        return r;
    }
    
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(Moneda m) throws ClassNotFoundException, SQLException
    {
        if (Existe(m)) {
            return Actualizar(m);
        }else
        {
            return Nuevo(m);
        }
    }
    public static boolean Eliminar(Moneda m) throws ClassNotFoundException, SQLException
    {
        return DarBaja(m);
    }
    
    public static LinkedList<Moneda> ListaMonedas() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    public static LinkedList<Moneda> ListarporMoneda() throws ClassNotFoundException, SQLException
    {
        return ListaporMoneda();
    }
    public static LinkedList<Moneda> ListaPersonalizadaMoneda() throws ClassNotFoundException, SQLException
    {
        return ListaPersonalizada();
    }
    public static BigDecimal ObtenerTipoCompra(String nomMoneda) throws ClassNotFoundException, SQLException
    {
        return ObtenerCompra(nomMoneda);
    }
    public static int ObtenerId(String nomMoneda) throws ClassNotFoundException, SQLException
    {
        return ObtenerIdMoneda(nomMoneda);
    }
    public static BigDecimal ObtenerTipoVenta(String idMoneda) throws ClassNotFoundException, SQLException
    {
        return ObtenerVenta(idMoneda);
    }
}
