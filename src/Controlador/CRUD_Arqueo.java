/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.Arqueo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author EDWARD
 */
public class CRUD_Arqueo {
    private static boolean Nuevo(Arqueo arq) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO CAJ_ARQUEO VALUES (null,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                
                ps.setString(1,arq.getDenominacion());
                ps.setString(2,arq.getTipo());
                ps.setDouble(3,arq.getValor());
                ps.setInt(4, arq.getCantidad());
                ps.setInt(5, arq.getIdMoneda());
                
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(Arqueo arq) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE CAJ_ARQUEO " +
                        "SET " +
                        "DENOMINACION = ?, " +
                        "TIPO = ?, " +
                        "VALOR = ?, " +
                        "CANTIDAD = ?, " +
                        "ID_MONEDA = ? " +
                        "WHERE ID = ?;";
        
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                
                ps.setString(1,arq.getDenominacion());
                ps.setString(2,arq.getTipo());
                ps.setDouble(3,arq.getValor());
                ps.setInt(4, arq.getCantidad());
                ps.setInt(5, arq.getIdMoneda());
                
                ps.setInt(3,arq.getIdArqueo());
                
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(Arqueo arq) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID),0) FROM CAJ_ARQUEO WHERE ID = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,arq.getIdArqueo());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(Arqueo arq) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM CAJ_ARQUEO WHERE ID = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,arq.getIdArqueo());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<Arqueo> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Arqueo> Lista = new LinkedList<>();
        String sql="SELECT * FROM CAJ_ARQUEO";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Arqueo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
               }
            }
        }
        return Lista;
    }
    // retornamos el id del documento seleccionado
    private static int ObtenerId(String nombre) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT ID FROM CAJ_ARQUEO WHERE NOMBRE = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                    ps.setString(1, nombre);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getInt(1);
            }
        }
        return r;
    }
    // Lista de acuerdo al id de moneda
    private static LinkedList<Arqueo> ListaMoneda(int idmoneda) throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Arqueo> Lista = new LinkedList<>();
        String sql="SELECT * FROM CAJ_ARQUEO WHERE ID_MONEDA = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1, idmoneda);
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Arqueo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
               }
            }
        }
        return Lista;
    }
    // Se crea funciones publicas para su acceso
    public static boolean Guardar(Arqueo arq) throws ClassNotFoundException, SQLException
    {
        if (Existe(arq)) {
            return Actualizar(arq);
        }else
        {
            return Nuevo(arq);
        }
    }
    public static boolean Eliminar(Arqueo arq) throws ClassNotFoundException, SQLException
    {
        return DarBaja(arq);
    }
    
    public static LinkedList<Arqueo> ListaArqueos() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    public static LinkedList<Arqueo> ListaporMoneda(int idmoneda) throws ClassNotFoundException, SQLException
    {
        return ListaMoneda(idmoneda);
    }
    public static int ObtenerIdArqueo(String nombre) throws ClassNotFoundException, SQLException
    {
        return ObtenerId(nombre);
    }
    
}
