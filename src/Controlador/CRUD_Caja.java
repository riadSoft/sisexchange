/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.Caja;
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
public class CRUD_Caja {
    private static boolean Nuevo(Caja c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO MC_CAJA VALUES (null,?,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,c.getDescripcion());
                ps.setDouble(2,c.getSaldoInicial());
                ps.setDouble(3,c.getSaldoFinal());
                ps.setTimestamp(4,c.getFechaApertura());
                ps.setTimestamp(5, c.getFechaCierre());
                ps.setInt(6, c.getEstado());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(Caja c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE MC_CAJA SET DESCRIPCION = ?, SALDO_INI = ?, SALDO_FIN = ?, FECHA_APERTURA = ?, FECHA_CIERRE = ?, ESTADO = ? WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,c.getDescripcion());
                ps.setDouble(2,c.getSaldoInicial());
                ps.setDouble(3,c.getSaldoFinal());
                ps.setTimestamp(4,c.getFechaApertura());
                ps.setTimestamp(5, c.getFechaCierre());
                ps.setInt(6, c.getEstado());
                
                ps.setInt(7,c.getIdCaja());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(Caja c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_CAJA),0) FROM MC_CAJA WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,c.getIdCaja());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(Caja c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM MC_CAJA WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,c.getIdCaja());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<Caja> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Caja> Lista = new LinkedList<>();
        String sql="SELECT * FROM MC_CAJA";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Caja(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7)));
               }
            }
        }
        return Lista;
    }
    // Obtener la lista de acuerdo al id de caja
    private static LinkedList<Caja> ListaporId(int idcaja) throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Caja> Lista = new LinkedList<>();
        String sql="SELECT * FROM MC_CAJA WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1, idcaja);
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Caja(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7)));
               }
            }
        }
        return Lista;
    }
    // Obtener la lista de nombres de moendas de a base de datos
    private static LinkedList<Caja> ListaporCaja() throws ClassNotFoundException, SQLException
    {
        LinkedList<Caja> Lista = new LinkedList<>();
        String sql="SELECT ID_CAJA,DESCRIPCION FROM MC_CAJA";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Caja(rs.getInt(1), rs.getString(2)));
               }
            }
        }
        return Lista;
    }
    // Funcion que obtiene el id de caja
    private static int ObtenerId(String nomCaja) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT ID_CAJA FROM MC_CAJA WHERE DESCRIPCION = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,nomCaja);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getInt(1);
            }
        }
        return r;
    }
    // Funcion que obtiene el nombre de caja
    private static String ObtenerNombre(int idCaja) throws ClassNotFoundException, SQLException
    {
        String nom="";
        String sql="SELECT DESCRIPCION FROM MC_CAJA WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,idCaja);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               nom=rs.getString(1);
            }
        }
        return nom;
    }
        // Funcion que obtiene la fecha de inicio de la caja
    private static Timestamp ObtenerFechaInicio(int idCaja) throws ClassNotFoundException, SQLException
    {
        Timestamp fecha;
        String sql="SELECT FECHA_APERTURA FROM MC_CAJA WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,idCaja);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               fecha=rs.getTimestamp(1);
            }
        }
        return fecha;
    }
    //Funcion que obtiene el estado de la caja
    private static int ObtenerEstado(int idCaja) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT ESTADO FROM MC_CAJA WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,idCaja);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getInt(1);
            }
        }
        return r;
    }
    // Recupera el saldo de acuerdo a la caja seleccionada
    private static double SaldoBolivianos(int idCaja) throws ClassNotFoundException, SQLException
    {
        double saldo=0.0;
        String sql="SELECT SALDO_INI FROM MC_CAJA WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,idCaja);
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                saldo=rs.getDouble(1);
            }
        }
        return saldo;
    }
    // Recupera el saldo de acuerdo a la caja seleccionada
     private static double SaldoDolares(int idCaja) throws ClassNotFoundException, SQLException
    {
        double saldo=0.0;
        String sql="SELECT SALDO_FIN FROM MC_CAJA WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,idCaja);
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                saldo=rs.getDouble(1);
            }
        }
        return saldo;
    }
    private static boolean UpdateSaldos(double saldoBs, double saldoSus, int idcaja) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE MC_CAJA SET SALDO_INI = ?, SALDO_FIN = ? WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                System.out.println("Los monto recuperados son:"+saldoBs+";"+saldoSus);
                
                ps.setDouble(1,saldoBs);
                ps.setDouble(2,saldoSus);
                
                ps.setInt(3,idcaja);
                
            r=ps.executeUpdate();
        }catch (Exception e) {
            System.out.println("Error:"+e);
        }
        return r==1?true:false;
    }
    //Funcion que actualiza el cierre de caja
    private static boolean ActualizarCierre(Caja c) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE MC_CAJA SET SALDO_FIN = ?, FECHA_CIERRE = ?, ESTADO = ? WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setDouble(1,c.getSaldoFinal());
                ps.setTimestamp(2, c.getFechaCierre());
                ps.setInt(3, c.getEstado());
                
                ps.setInt(4,c.getIdCaja());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(Caja c) throws ClassNotFoundException, SQLException
    {
        if (Existe(c)) {
            return Actualizar(c);
        }else
        {
            return Nuevo(c);
        }
    }
    public static boolean Eliminar(Caja c) throws ClassNotFoundException, SQLException
    {
        return DarBaja(c);
    }
    
    public static LinkedList<Caja> ListaCajas() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    public static LinkedList<Caja> ListaporIdCaja(int idCaja) throws ClassNotFoundException, SQLException
    {
        return ListaporId(idCaja);
    }
    public static LinkedList<Caja> ListarporCaja() throws ClassNotFoundException, SQLException
    {
        return ListaporCaja();
    }
     public static String getNombreCaja(int idCaja) throws ClassNotFoundException, SQLException
    {
        return ObtenerNombre(idCaja);
    }
    public static Timestamp getFechaApertura(int idCaja) throws ClassNotFoundException, SQLException
    {
        return ObtenerFechaInicio(idCaja);
    }
    public static int getEstadoCaja(int idCaja) throws ClassNotFoundException, SQLException
    {
        return ObtenerEstado(idCaja);
    }
    public static int getidCaja(String nomCaja) throws ClassNotFoundException, SQLException
    {
        return ObtenerId(nomCaja);
    }
    public static double getSaldoBolvianos(int idcaja) throws ClassNotFoundException, SQLException
    {
        return SaldoBolivianos(idcaja);
    }
    public static double getSaldoDolares(int idcaja) throws ClassNotFoundException, SQLException
    {
        return SaldoDolares(idcaja);
    }
    public static boolean ActualizarSaldos(double saldodBs, double saldoSus, int idcaja) throws ClassNotFoundException, SQLException
    {
        return UpdateSaldos(saldodBs, saldoSus, idcaja);
    }
    public static boolean ActualizarCajaCierre(Caja c) throws ClassNotFoundException, SQLException
    {
        return ActualizarCierre(c);
    }
}
