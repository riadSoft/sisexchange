/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.DetalleCaja;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author EDWARD
 */
public class CRUD_DetalleCaja {
    private static boolean Nuevo(DetalleCaja dc) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO MC_DETALLE_CAJA VALUES (null,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                ps.setDouble(1,dc.getMonto());
                ps.setInt(2,dc.getEstado());
                ps.setTimestamp(3,dc.getFecha());
                ps.setInt(4, dc.getIdcaja());
                ps.setInt(5,dc.getMoneda());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(DetalleCaja dc) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE MC_DETALLE_CAJA " +
                        "SET " +
                        "ID_MONEDA = ?," +
                        "MONTO = ?," +
                        "ESTADO = ?," +
                        "FECHA = ?," +
                        "ID_CAJA = ? " +
                        "WHERE ID_DETALLE_CAJA = ?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                ps.setInt(1,dc.getMoneda());
                ps.setDouble(2,dc.getMonto());
                ps.setInt(3,dc.getEstado());
                ps.setTimestamp(4,dc.getFecha());
                ps.setInt(5, dc.getIdcaja());
                
                ps.setInt(6,dc.getIddetallecaja());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(DetalleCaja dc) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_DETALLE_CAJA),0) FROM MC_DETALLE_CAJA WHERE ID_DETALLE_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,dc.getIddetallecaja());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(DetalleCaja dc) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM MC_DETALLE_CAJA WHERE ID_DETALLE_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,dc.getIddetallecaja());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<DetalleCaja> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<DetalleCaja> Lista = new LinkedList<>();
        String sql="SELECT * FROM MC_DETALLE_CAJA";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new DetalleCaja(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getInt(4), rs.getTimestamp(5), rs.getInt(6)));
               }
            }
        }
        return Lista;
    }
    private static LinkedList<Object[]> ListporMonto(int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException
    {
        LinkedList<Object[]> Lista = new LinkedList<>();
        String sql=    "SELECT NOM_MONEDA, SALDO_INICIAL,COMPRAS,VENTAS,DEBITO,CREDITO, " +
                            "ROUND(IFNULL((SALDO_INICIAL+COMPRAS-VENTAS+CREDITO-DEBITO),0),2) AS SALDO,TC, " +
                            "ROUND(IFNULL((SALDO_INICIAL+COMPRAS-VENTAS+CREDITO-DEBITO)*TC,0),2) AS SALDO_FIN_BS " +
                            "FROM BDD_CAMBIO.VIEW_SALDOCIERRE " +
                            "WHERE FECHA = date(?) AND CAJA = ?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setTimestamp(1, fecha);
                ps.setInt(2, idcaja);
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add( new Object[] {rs.getString(1), rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9)});
               }
            }
        }
        return Lista;
    }
    // Funcion que debuelve la lista de detalle de caja para obtener los saldos.
    private static LinkedList<Object[]> ListporCaja(int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException
    {
        LinkedList<Object[]> Lista = new LinkedList<>();
        String sql=    " SELECT  s.NOM_MONEDA,(s.SALDO_INICIAL+s.COMPRAS-s.VENTAS-s.DEBITO+s.CREDITO) as SALDO " +
                            " FROM BDD_CAMBIO.VIEW_SALDO_MONEDAS s " +
                            " WHERE FECHA = date(?) AND CAJA = ?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setTimestamp(1, fecha);
                ps.setInt(2, idcaja);
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add( new Object[] {rs.getString(1), rs.getDouble(2)});
               }
            }
        }
        return Lista;
    }
    // Funcion para obtner los montos
    private static LinkedList<Object []> ViewSaldosCaja(int idcaja) throws ClassNotFoundException, SQLException
    {
        LinkedList<Object []> Lista = new LinkedList<>();
        String sql="SELECT NOM_MONEDA,MONTO,COMPRA, " +
                        "ROUND(IFNULL((MONTO*COMPRA),0),2) AS SALDO_BS " +
                        "FROM BDD_CAMBIO.VIEW_DETALLECAJA " +
                        "WHERE ID_CAJA=?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1, idcaja);
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Object[] {rs.getString(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4)});
               }
            }
        }
        return Lista;
    }
    private static LinkedList<Object []> SaldosCajaInicio(int idcaja) throws ClassNotFoundException, SQLException
    {
        LinkedList<Object []> Lista = new LinkedList<>();
        String sql="SELECT * FROM BDD_CAMBIO.VER_CAJA_SALDOS " +
                        "WHERE ID_CAJA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1, idcaja);
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Object[] {rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(4),rs.getString(5),rs.getInt(6)});
               }
            }
        }
        return Lista;
    }
    // Funcion para obtener el monto de una moneda especifica
    private static BigDecimal ObtenerMonto(String moneda, int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException
    {
        BigDecimal r=BigDecimal.ZERO;
        String sql=     "SELECT (s.SALDO_INICIAL+s.COMPRAS-s.VENTAS-s.DEBITO+s.CREDITO) as SALDO " +
                             "FROM BDD_CAMBIO.VIEW_SALDO_MONEDAS s " +
                             "WHERE FECHA = date(?) AND CAJA = ? AND NOM_MONEDA = ?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setTimestamp(1, fecha);
                ps.setInt(2, idcaja);
                ps.setString(3, moneda);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getBigDecimal(1);
            }
        }
        return r;
    }
    // Funcion que atualiza el monto de una moneda seleccionada
    private static boolean ActualizarMonto(double monto, int moneda, int idcaja) throws ClassNotFoundException, SQLException
    {
        int r=0;
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp fecha = new java.sql.Timestamp(date.getTime());
        
        String sql = "UPDATE MC_DETALLE_CAJA " +
                        "SET " +
                        "MONTO = ?," +
                        "FECHA = ? " +
                        "WHERE ID_MONEDA = ? AND ID_CAJA = ? ";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            
                ps.setDouble(1,monto);
                ps.setTimestamp(2, fecha);
                ps.setInt(3,moneda);
                ps.setInt(4, idcaja);
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    //Funcion para actualizar los saldos con un procedimiento almacenado
    private static boolean procedimientoSaldo(int idcaja, int estado){
        boolean r=false;
        String sql = "CALL saldoCaja("+idcaja+","+estado+");";
        try( Connection cn = Conexion_BDD.getConnection();
                    CallableStatement cs = cn.prepareCall(sql)) {
                    r = cs.execute();
                    System.out.println("result:"+r);
                    cn.close();
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro:"+e, "Error", JOptionPane.ERROR_MESSAGE);
        } catch(ClassNotFoundException c){
                JOptionPane.showMessageDialog(null, "Erro:"+c, "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return r;
    }
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(DetalleCaja c) throws ClassNotFoundException, SQLException
    {
        if (Existe(c)) {
            return Actualizar(c);
        }else
        {
            return Nuevo(c);
        }
    }
    public static boolean Eliminar(DetalleCaja c) throws ClassNotFoundException, SQLException
    {
        return DarBaja(c);
    }
    
    public static LinkedList<DetalleCaja> ListaDetalleCajas() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    public static LinkedList<Object[]> ListaporCajas(int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException
    {
        return ListporCaja(idcaja, fecha);
    }
    public static LinkedList<Object []> ListaporMontos(int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException
    {
        return ListporMonto(idcaja, fecha);
    }
    public static LinkedList<Object []> VistaDetalleCaja(int idcaja) throws ClassNotFoundException, SQLException
    {
        return ViewSaldosCaja(idcaja);
    }
    public static LinkedList<Object []> SadosCajaMoneda(int idcaja) throws ClassNotFoundException, SQLException
    {
        return SaldosCajaInicio(idcaja);
    }
    public static BigDecimal ObtenerMontoMoneda(String moneda, int idcaja, Timestamp fecha) throws ClassNotFoundException, SQLException
    {
        return ObtenerMonto(moneda,idcaja,fecha);
    }
    public static boolean ActualizarMontoMoneda(double monto,int moneda,int idcaja) throws ClassNotFoundException, SQLException
    {
        return ActualizarMonto(monto, moneda, idcaja);
    }
    public static boolean pralmSaldo(int idcaja, int estado){
        return procedimientoSaldo(idcaja, estado);
    }
}
