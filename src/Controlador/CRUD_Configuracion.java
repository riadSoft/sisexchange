/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Configuracion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_Configuracion {

    private static boolean Nuevo(Configuracion con) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "INSERT INTO SIS_CONFIGURACION VALUES (null,?,?,?,?,?,?,?,?,?)";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, con.getIni_oper());
            ps.setInt(2, con.getAct_oper());
            ps.setInt(3, con.getReg_log());
            ps.setInt(4, con.getTip_fact());
            ps.setString(5, con.getLink_conf());
            ps.setInt(6, con.getImpresion());
            ps.setInt(7, con.getEstado());
            ps.setInt(8, con.getIdCaja());
            ps.setInt(9, con.getIdUsuario());

            r = ps.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Actualizar(Configuracion con) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "UPDATE SIS_CONFIGURACION "
                + "SET "
                + "INI_OPER = ?, "
                + "ACT_OPER = ?, "
                + "REG_LOG = ?, "
                + "TIP_FACT = ?, "
                + "LINK_CONF = ?, "
                + "IMPRESION = ?, "
                + "ESTADO = ?, "
                + "ID_CAJA = ?, "
                + "ID_USUARIO = ? "
                + "WHERE ID = ?; ";

        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, con.getIni_oper());
            ps.setInt(2, con.getAct_oper());
            ps.setInt(3, con.getReg_log());
            ps.setInt(4, con.getTip_fact());
            ps.setString(5, con.getLink_conf());
            ps.setInt(6, con.getImpresion());
            ps.setInt(7, con.getEstado());
            ps.setInt(8, con.getIdCaja());
            ps.setInt(9, con.getIdUsuario());


            ps.setInt(10, con.getId());

            r = ps.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Existe(Configuracion con) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "SELECT IFNULL(COUNT(ID),0) FROM SIS_CONFIGURACION WHERE ID = ?";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, con.getId());
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }

    private static boolean DarBaja(Configuracion con) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "DELETE FROM SIS_CONFIGURACION WHERE ID = ?";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, con.getId());
            r = ps.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static LinkedList<Configuracion> Lista() throws ClassNotFoundException, SQLException {
        int r = 0;
        LinkedList<Configuracion> Lista = new LinkedList<>();
        String sql = "SELECT * FROM SIS_CONFIGURACION WHERE ESTADO = 1";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Lista.add(new Configuracion(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getInt(7),rs.getInt(8),rs.getInt(9), rs.getInt(10)));
                }
            }
        }
        return Lista;
    }

    //Funcion que genera el numero de operacion
    public static int getOperacion(Configuracion con) throws ClassNotFoundException, SQLException {

        int nfact = 0;
        ResultSet rs;

        String sql = "SELECT * FROM SIS_CONFIGURACION WHERE ID_CAJA  = ? AND ID_USUARIO = ?";

        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, con.getIdCaja());
            ps.setInt(2, con.getIdUsuario());

            rs = ps.executeQuery();
            if (rs.first()) {
                rs.beforeFirst();
                while (rs.next()) {
                    nfact = rs.getInt("ACT_OPER");
                    nfact = nfact + 1;
                }
            } else {
                nfact = 1;
            }
        }

        System.out.println("Numero de operacion:" + nfact);
        return nfact;
    }

    // Funcion que actualiza el numero de operacion
    public static boolean ActualizaNumeroOperacion(Configuracion con) throws ClassNotFoundException, SQLException {

        int r = 0;
        String sql = "UPDATE SIS_CONFIGURACION "
                + "SET "
                + "ACT_OPER = ? "
                + "WHERE ID_CAJA = ? AND ID_USUARIO = ?;";

        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, con.getAct_oper());
            ps.setInt(2, con.getIdCaja());
            ps.setInt(3, con.getIdUsuario());

            r = ps.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    //Funcion que recupera caja establecida
    public static int getCajaActiva() throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "SELECT ID_CAJA FROM SIS_CONFIGURACION WHERE ESTADO = 1;";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r;
    }
    // Funcion que recuepera el estado de impresion
    public static int getEstadoImpresion()throws ClassNotFoundException, SQLException{
        int r = 0;
        String sql = "SELECT IMPRESION FROM SIS_CONFIGURACION WHERE ESTADO = 1;";
        try(Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try(ResultSet rs = ps.executeQuery()) {
                rs.next();
                r=rs.getInt(1);
            }            
        } 
        return r;
    }
    

    // Se crea funciones publicas para su acceso
    public static boolean Guardar(Configuracion con) throws ClassNotFoundException, SQLException {
        if (Existe(con)) {
            return Actualizar(con);
        } else {
            return Nuevo(con);
        }
    }

    public static boolean Eliminar(Configuracion con) throws ClassNotFoundException, SQLException {
        return DarBaja(con);
    }

    public static LinkedList<Configuracion> ListaConfiguracions() throws ClassNotFoundException, SQLException {
        return Lista();
    }

    public static int ObtenerNumeroOperacion(Configuracion con) throws ClassNotFoundException, SQLException {
        return getOperacion(con);
    }

    public static boolean UpdateOperaion(Configuracion con) throws ClassNotFoundException, SQLException {
        return ActualizaNumeroOperacion(con);
    }

    public static int getcajaActiva() throws ClassNotFoundException, SQLException {
        return getCajaActiva();
    }
    public static int getImpresion() throws ClassNotFoundException,SQLException{
        return getEstadoImpresion();
    }
}
