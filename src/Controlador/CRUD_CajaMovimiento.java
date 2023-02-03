/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.CajaMovimiento;
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
public class CRUD_CajaMovimiento {
    
    private static boolean Nuevo(CajaMovimiento cm) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO CAJ_MOVIMIENTO VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                ps.setString(1,cm.getNumero());
                ps.setDouble(2,cm.getIngreso());
                ps.setDouble(3,cm.getEgreso());
                ps.setString(4,cm.getTipo());
                ps.setDouble(5, cm.getSaldo());
                ps.setString(6, cm.getGlosa());
                ps.setTimestamp(7, cm.getFecha());
                ps.setInt(8, cm.getIdDocumento());
                ps.setInt(9, cm.getIdConcepto());
                ps.setInt(10, cm.getIdMoneda());
                ps.setInt(11, cm.getIdCaja());
                ps.setInt(12, cm.getIdUsuario());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(CajaMovimiento cm) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE CAJ_MOVIMIENTO " +
                        "SET " +
                        "NUMERO = ?, " +
                        "INGRESO = ?, " +
                        "EGRESO = ?, " +
                        "TIPO = ?, " +
                        "SALDO = ?, " +
                        "GLOSA = ?, " +
                        "FECHA = ?, " +
                        "ID_DOCUMENTO = ?, " +
                        "ID_CONCEPTO = ?, " +
                        "ID_MONEDA = ?, " +
                        "ID_CAJA = ?, " +
                        "ID_USUARIO = ? " +
                        "WHERE ID_MOVIMIENTO = ?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                ps.setString(1,cm.getNumero());
                ps.setDouble(2,cm.getIngreso());
                ps.setDouble(3,cm.getEgreso());
                ps.setString(4,cm.getTipo());
                ps.setDouble(5, cm.getSaldo());
                ps.setString(6, cm.getGlosa());
                ps.setTimestamp(7, cm.getFecha());
                ps.setInt(8, cm.getIdDocumento());
                ps.setInt(9, cm.getIdConcepto());
                ps.setInt(10, cm.getIdMoneda());
                ps.setInt(11, cm.getIdCaja());
                ps.setInt(12, cm.getIdUsuario());
                
                ps.setInt(13,cm.getIdcajamovimiento());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(CajaMovimiento cm) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_MOVIMIENTO),0) FROM CAJ_MOVIMIENTO WHERE ID_MOVIMIENTO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                ps.setInt(1,cm.getIdcajamovimiento());
                
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(CajaMovimiento cm) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM CAJ_MOVIMIENTO WHERE ID_MOVIMIENTO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                ps.setInt(1,cm.getIdcajamovimiento());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<CajaMovimiento> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<CajaMovimiento> Lista = new LinkedList<>();
        String sql="SELECT * FROM CAJ_MOVIMIENTO";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   
                   Lista.add(new CajaMovimiento(rs.getInt(1), rs.getString(2), rs.getDouble(4), 
                           rs.getDouble(5), rs.getString(6), rs.getDouble(7), rs.getString(8), 
                           rs.getTimestamp(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14)));
                   
               }
            }
        }
        return Lista;
    }
    // Funcion que retorna la lista de elementos del movimiento cuando la caja se cuentra abierta
    private static LinkedList<String[]> ListaCorta(int idcaja, String fecha) throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<String[]> Lista = new LinkedList<>();
        String sql="SELECT  " +
                    "NOMBRE, " +
                    "INGRESO, " +
                    "EGRESO " +
                    "FROM " +
                    "CAJ_MOVIMIENTO m " +
                    "INNER JOIN " +
                    "CAJ_DOCUMENTOS d ON m.ID_DOCUMENTO = d.ID_DOCUMENTO " +
                    "WHERE (SELECT ESTADO FROM MC_CAJA WHERE ID_CAJA = ?) = 1 AND m.FECHA LIKE \"%"+fecha+"%\"";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                    ps.setInt(1, idcaja);
                    //ps.setString(2, fecha);
                    System.out.println("SQL:"+sql);
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new String[] {rs.getString(1),rs.getString(2),rs.getString(3)});
                   
               }
            }
        }
        return Lista;
    }
    // Funcion para conocer el saldo de ingreso
    public static double Saldo(String tipo,String fecha)throws ClassNotFoundException, SQLException{
        double r=0;
        String sql="SELECT SUM("+tipo+") FROM CAJ_MOVIMIENTO WHERE FECHA LIKE \"%"+fecha+"%\"";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getDouble(1);
            }
        }
        return r;
        
    }
    // Funcion que obtiene el saldo de ingresos 
    public static double saldoIngresos(int idcaja, Timestamp fecha)throws ClassNotFoundException, SQLException{
        double r =0;
        String sql =    "SELECT ROUND(IFNULL(SUM(c.INGRESO*m.COMPRA),0),2) as Total " +
                             "FROM MC_MONEDA m " +
                             "INNER JOIN " +
                             "CAJ_MOVIMIENTO c ON m.ID_MONEDA = c.ID_MONEDA " +
                             "WHERE c.ID_CAJA = ? AND date(c.FECHA) = date(?) AND c.TIPO='I'; ";
       try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                        ps.setInt(1, idcaja);
                        ps.setTimestamp(2, fecha);
                        try (ResultSet rs= ps.executeQuery()){
                             rs.next();
                             r=rs.getDouble(1);
                        }
        }
        return r;
    }
    // Funcion que obtiene el saldo de ingresos 
    public static double saldoGasto(int idcaja, Timestamp fecha)throws ClassNotFoundException, SQLException{
        double r =0;
        String sql =    "SELECT ROUND(IFNULL(SUM(c.EGRESO*m.COMPRA),0),2) as Total " +
                             "FROM MC_MONEDA m " +
                             "INNER JOIN " +
                             "CAJ_MOVIMIENTO c ON m.ID_MONEDA = c.ID_MONEDA " +
                             "WHERE c.ID_CAJA = ? AND date(c.FECHA) = date(?) and c.TIPO='E'; ";
       try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                        ps.setInt(1, idcaja);
                        ps.setTimestamp(2, fecha);
                        try (ResultSet rs= ps.executeQuery()){
                             rs.next();
                             r=rs.getDouble(1);
                        }
        }
        return r;
    }
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(CajaMovimiento cm) throws ClassNotFoundException, SQLException
    {
        if (Existe(cm)) {
            return Actualizar(cm);
        }else
        {
            return Nuevo(cm);
        }
    }
    public static boolean Eliminar(CajaMovimiento cm) throws ClassNotFoundException, SQLException
    {
        return DarBaja(cm);
    }
    public static double SaldoMovimiento(String tipo, String fecha) throws ClassNotFoundException, SQLException
    {
        return Saldo(tipo, fecha);
    }
    
    public static double saldoIngresoCaja(int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException
    {
        return saldoIngresos(idcaja, fecha);
    }
    
    public static double saldoGastoCaja(int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException
    {
        return saldoGasto(idcaja, fecha);
    }
    
    public static LinkedList<CajaMovimiento> ListaCajas() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    
    public static LinkedList<String[]> ListaMovimientoCaja(int idcaja, String fecha) throws ClassNotFoundException, SQLException
    {
        return ListaCorta(idcaja, fecha);
    }
}
