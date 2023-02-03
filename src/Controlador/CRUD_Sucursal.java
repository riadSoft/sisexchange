/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.Sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_Sucursal {

    private static boolean Nuevo(Sucursal suc) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "INSERT INTO CAJ_ARQUEO VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, suc.getNombre());
            ps.setString(2, suc.getDireccion());
            ps.setString(3, suc.getTelefono());
            ps.setString(4, suc.getResponsable());
            ps.setInt(5, suc.getNcaja());
            ps.setString(6, suc.getNit());
            ps.setString(7, suc.getNautorizacion());
            ps.setString(8, suc.getLlave());
            ps.setString(9, suc.getLeyenda());
            ps.setDate(10, suc.getFecha());
            ps.setString(11, suc.getActEconomica());
            ps.setInt(12, suc.getIninfact());
            ps.setInt(13, suc.getActnfact());
            ps.setInt(14, suc.getFinnfact());
            ps.setInt(15, suc.getEstado());

            r = ps.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Actualizar(Sucursal suc) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "UPDATE MC_SUCURSAL "
                + "SET "
                + "NOMBRE = ?, "
                + "DIRECCION = ?, "
                + "TELEFONO = ?, "
                + "RESPONSABLE = ?, "
                + "N_CAJAS = ?, "
                + "NIT = ?, "
                + "AUTORIZACION = ?, "
                + "LLAVE_DOSIFICACION = ?, "
                + "FECHA_LIMITE = ?, "
                + "LEYENDA = ?, "
                + "ACT_ECONOMICA = ?, "
                + "INI_FACT = ?, "
                + "ACT_FACT = ?, "
                + "FIN_FACT = ?, "
                + "ESTADO = ? "
                + "WHERE ID_SUCURSAL = ?;";

        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, suc.getNombre());
            ps.setString(2, suc.getDireccion());
            ps.setString(3, suc.getTelefono());
            ps.setString(4, suc.getResponsable());
            ps.setInt(5, suc.getNcaja());
            ps.setString(6, suc.getNit());
            ps.setString(7, suc.getNautorizacion());
            ps.setString(8, suc.getLlave());
            ps.setString(9, suc.getLeyenda());
            ps.setDate(10, suc.getFecha());
            ps.setString(11, suc.getActEconomica());
            ps.setInt(12, suc.getIninfact());
            ps.setInt(13, suc.getActnfact());
            ps.setInt(14, suc.getFinnfact());
            ps.setInt(15, suc.getEstado());

            ps.setInt(16, suc.getIdSucursal());

            r = ps.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static boolean Existe(Sucursal suc) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "SELECT IFNULL(COUNT(ID_SUCURSAL),0) FROM MC_SUCURSAL WHERE ID_SUCURSAL = ?";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, suc.getIdSucursal());
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r > 0 ? true : false;
    }

    private static boolean DarBaja(Sucursal suc) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "DELETE FROM MC_SUCURSAL WHERE ID_SUCURSAL = ?";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, suc.getIdSucursal());
            r = ps.executeUpdate();
        }
        return r == 1 ? true : false;
    }

    private static LinkedList<Sucursal> Lista() throws ClassNotFoundException, SQLException {
        int r = 0;
        LinkedList<Sucursal> Lista = new LinkedList<>();
        String sql = "SELECT * FROM MC_SUCURSAL";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Lista.add(new Sucursal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10), rs.getString(11), rs.getString(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16)));
                }
            }
        }
        return Lista;
    }

    //Obtener id de sucursal
    private static int Obtenerid(String nombre) throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "SELECT ID_SUCURSAL FROM MC_SUCURSAL WHERE NOMBRE = ?";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {

                rs.next();
                r = rs.getInt(1);
            }
        }
        return r;
    }

    // Obtener la sucursal activa
    private static int ObtenerSucursalActiva() throws ClassNotFoundException, SQLException {
        int r = 0;
        String sql = "SELECT ID_SUCURSAL FROM MC_SUCURSAL WHERE ESTADO = 1";
        try (Connection cn = Conexion_BDD.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                r = rs.getInt(1);
            }
        }
        return r;
    }

    // Se crea funciones publicas para su acceso
    public static boolean Guardar(Sucursal suc) throws ClassNotFoundException, SQLException {
        if (Existe(suc)) {
            return Actualizar(suc);
        } else {
            return Nuevo(suc);
        }
    }

    public static boolean Eliminar(Sucursal suc) throws ClassNotFoundException, SQLException {
        return DarBaja(suc);
    }

    public static LinkedList<Sucursal> ListaSucursales() throws ClassNotFoundException, SQLException {
        return Lista();
    }

    public static int getidSucursal(String nombre) throws ClassNotFoundException, SQLException {
        return Obtenerid(nombre);
    }
    public static int getSucursalActiva() throws ClassNotFoundException, SQLException {
        return ObtenerSucursalActiva();
    }
}
