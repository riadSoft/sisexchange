    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.OperacionMoneda;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_OperacionMoneda {
    private static boolean Nuevo(OperacionMoneda om) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO MC_MOVIMIENTO VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,om.getNroOperacion());
                ps.setTimestamp(2, om.getFecha());
                ps.setBigDecimal(3, om.getImporte());
                ps.setBigDecimal(4, om.getCotizacion());
                ps.setString(5, om.getTipo());
                ps.setString(6, om.getCedula());
                ps.setString(7, om.getNombre());
                ps.setInt(8, om.getEstado());
                ps.setInt(9, om.getIdSucursal());
                ps.setInt(10, om.getIdCaja());
                ps.setInt(11, om.getIdUsuario());
                ps.setInt(12, om.getIdMoneda());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(OperacionMoneda om) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE MC_MOVIMIENTO SET " +
                    "NRO_OPER = ?," +
                    "FECHA = ?," +
                    "IMPORTE = ?," +
                    "COTIZACION = ?," +
                    "TIPO = ?," +
                    "CEDULA = ?," +
                    "NOMBRE = ?," +
                    "ESTADO = ?," +
                    "MC_SUCURSAL_ID_SUCURSAL = ?," +
                    "MC_CAJA_ID_CAJA = ?," +
                    "SEG_USUARIO_ID_USUARIO = ?," +
                    "MC_MONEDA_ID_MONEDA = ? " +
                    "WHERE ID_MOVI = ?;";
        
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                
                ps.setInt(1,om.getNroOperacion());
                ps.setTimestamp(2, om.getFecha());
                ps.setBigDecimal(3, om.getImporte());
                ps.setBigDecimal(4, om.getCotizacion());
                ps.setString(5, om.getTipo());
                ps.setString(6, om.getCedula());
                ps.setString(7, om.getNombre());
                ps.setInt(8, om.getEstado());
                ps.setInt(9, om.getIdSucursal());
                ps.setInt(10, om.getIdCaja());
                ps.setInt(11, om.getIdUsuario());
                ps.setInt(12, om.getIdMoneda());
                
                ps.setInt(13,om.getIdOperacion());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(OperacionMoneda om) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_MOVI),0) FROM MC_MOVIMIENTO WHERE ID_MOVI = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,om.getIdOperacion());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(OperacionMoneda om) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM MC_MOVIMIENTO WHERE ID_MOVI = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,om.getIdOperacion());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<OperacionMoneda> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<OperacionMoneda> Lista = new LinkedList<>();
        String sql="SELECT * FROM MC_MOVIMIENTO";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new OperacionMoneda(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13)));
               }
            }
        }
        return Lista;
    }
    //Vista de elementos que las transacciones ralizadas
    private static LinkedList<Object[]> ListaTransacciones(Timestamp fecha, int idcaja, int idusuario) throws ClassNotFoundException, SQLException
    {
        int r=0;
        System.out.println(fecha.toString()+"|"+idcaja+"|"+idusuario);
        LinkedList<Object[]> Lista = new LinkedList<>();
        String sql="SELECT NRO_OPER, TIME(FECHA) AS HORA, OPERACION, MONEDA, IMPORTE,COTIZACION, SALDO " +
                            "FROM BDD_CAMBIO.VER_TRANSACIONES " +
                            "WHERE DATE(FECHA)= DATE(?) AND IDCAJA = ? AND IDUSER = ? ";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                            ps.setTimestamp(1, fecha);
                            ps.setInt(2, idcaja);
                            ps.setInt(3, idusuario);
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getDouble(6),rs.getDouble(7)});
               }
                System.out.println("Tamano:"+Lista.size());
            }
        }
        return Lista;
    }
    //Funcion que devuelve la LIsta de registros de acuerdo a filtro de datos
    private static LinkedList<Object[]> ListaFiltroRegistros(int tipoconsulta,String fecha,String moneda, String idcaja, String idusuario, String operacion) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="";
        System.out.println(fecha.toString()+"|"+idcaja+"|"+idusuario);
        LinkedList<Object[]> Lista = new LinkedList<>();
        if (tipoconsulta==2) {
            sql="SELECT * FROM BDD_CAMBIO.VIEW_GESTION_TRANSACCIONES " +
                            "WHERE FECHA = '"+fecha+"' "+
                            "ORDER BY FECHA;";
        }
        else if (tipoconsulta==1) {
            sql="SELECT * FROM BDD_CAMBIO.VIEW_GESTION_TRANSACCIONES " +
                            "ORDER BY FECHA;";
        } else {
            sql="SELECT * FROM BDD_CAMBIO.VIEW_GESTION_TRANSACCIONES " +
                            "WHERE FECHA = '"+fecha+"' AND MONEDA = '"+moneda+"' AND IDCAJA = "+idcaja+" AND IDUSER = "+idusuario+" AND OPERACION = '"+operacion+"' " +
                            "ORDER BY FECHA;";
        }
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Object[]{rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9),rs.getInt(10),rs.getInt(11)});
               }
                System.out.println("Tamano:"+Lista.size());
            }
        }
        return Lista;
    }
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(OperacionMoneda om) throws ClassNotFoundException, SQLException
    {
        if (Existe(om)) {
            return Actualizar(om);
        }else
        {
            return Nuevo(om);
        }
    }
    public static boolean Eliminar(OperacionMoneda om) throws ClassNotFoundException, SQLException
    {
        return DarBaja(om);
    }
    
    public static LinkedList<OperacionMoneda> ListaOperacionMonedas() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    public static LinkedList<Object[]> ListadeTransacciones(Timestamp fecha, int idcaja, int idusuario) throws ClassNotFoundException, SQLException
    {
        return ListaTransacciones(fecha, idcaja, idusuario);
    }
    public static LinkedList<Object[]> ListaFiltroTransacciones(int tipoconsulta,String fecha,String moneda, String idcaja, String idusuario, String operacion) throws ClassNotFoundException, SQLException
    {
        return ListaFiltroRegistros(tipoconsulta,fecha,moneda,idcaja,idusuario,operacion);
    }
    
}
