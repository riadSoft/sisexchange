/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidades.Usuario;
import Utilidades.Encriptacion;
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
public class CRUD_USUARIO {
    private static boolean Nuevo(Usuario p) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO SEG_USUARIO VALUES (null,?,?,?,?,?,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,p.getLogin());
                ps.setString(2,p.getPassword());
                ps.setString(3,p.getNombre());
                ps.setString(4,p.getApellidos());
                ps.setString(5, p.getCelular());
                ps.setTimestamp(6, p.getFecha_registro());
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Actualizar(Usuario p) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql = "UPDATE SEG_USUARIO SET LOGIN = ?,PASSWORD = ?,NOMBRE = ?,APELLIDOS = ?,CELULAR = ?,FECHA_REGISTRO = ? WHERE ID_USUARIO = ?;";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,p.getLogin());
                ps.setString(2,p.getPassword());
                ps.setString(3,p.getNombre());
                ps.setString(4,p.getApellidos());
                ps.setString(5, p.getCelular());
                ps.setTimestamp(6, p.getFecha_registro());
                
                ps.setInt(7,p.getId());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static boolean Existe(Usuario p) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT IFNULL(COUNT(ID_USUARIO),0) FROM SEG_USUARIO WHERE ID_USUARIO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,p.getId());
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }
        return r>0?true:false;
    }
    private static boolean DarBaja(Usuario p) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="DELETE FROM SEG_USUARIO WHERE ID_USUARIO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,p.getId());
            r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
    private static LinkedList<Object[]> Lista() throws ClassNotFoundException, SQLException
    {
        int r=0;
        LinkedList<Object[]> Lista = new LinkedList<>();
        String sql="SELECT * FROM SEG_USUARIO";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
            try (ResultSet rs= ps.executeQuery()){
               while(rs.next())
               {
                   Lista.add(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getTimestamp(7)});
               }
            }
        }
        return Lista;
    }
    // Funcion para obtener el id del usuario segun el usuario y contrasenia
    private static int ObtenerIdUsuario(Usuario p) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT ID_USUARIO FROM SEG_USUARIO WHERE LOGIN = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,p.getLogin());
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getInt(1);
            }
        }
        return r;
    }
    private static int ObtenerIdUsuario(String user) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="SELECT ID_USUARIO FROM SEG_USUARIO WHERE LOGIN = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,user);
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               r=rs.getInt(1);
            }
        }
        return r;
    }
    private static String ObtenerUsuario(int id) throws ClassNotFoundException, SQLException
    {
        String user="";
        String sql="SELECT CONCAT(NOMBRE,' ',APELLIDOS) FROM SEG_USUARIO WHERE ID_USUARIO = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setInt(1,id);
                
            try (ResultSet rs= ps.executeQuery()){
               rs.next();
               user=rs.getString(1);
            }
        }
        return user;
    }
    // Funcion que comprueba el ingreso del usuario en la base de datos.
    private static int Ingreso(Usuario p) throws ClassNotFoundException, SQLException
    {
        int r=0;
        Encriptacion encriptacion = new Encriptacion();
        String sql="SELECT IFNULL(COUNT(ID_USUARIO),0) FROM SEG_USUARIO WHERE LOGIN = ? AND PASSWORD = ?";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setString(1,p.getLogin());
                String password = encriptacion.encriptarAES(p.getPassword());
                ps.setString(2,password);
            try (ResultSet rs= ps.executeQuery()){
                rs.next();
                r=rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return r;
    }
    
    // Funcion que recupera la contrasena  del usuario acual
    private static String recuperarContrasena(Usuario pUsuario) throws ClassNotFoundException,SQLException{
        String password ="";
        String SQL ="select password\n" +
                            "from SEG_USUARIO\n" +
                            "where login=?";
        try(Connection cn=Conexion_BDD.getConnection();
                     PreparedStatement ps=cn.prepareStatement(SQL)) {
            ps.setString(1, pUsuario.getLogin());
            try(ResultSet rs =ps.executeQuery()) {
                rs.next();
                password=rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
    // Funcion que inserta el log de registro de inicio de secion.
     private static boolean Nuevo_log(int id, java.sql.Timestamp finicio) throws ClassNotFoundException, SQLException
    {
        int r=0;
        String sql="INSERT INTO SEG_LOG_USUARIO VALUES (null,?,null,?)";
        try (Connection cn= Conexion_BDD.getConnection();
                PreparedStatement ps= cn.prepareStatement(sql)){
                ps.setTimestamp(1,finicio);
                ps.setInt(2,id);
                r=ps.executeUpdate();
        }
        return r==1?true:false;
    }
     
    public static boolean Guardar(Usuario p) throws ClassNotFoundException, SQLException
    {
        if (Existe(p)) {
            return Actualizar(p);
        }else
        {
            return Nuevo(p);
        }
    }
    public static boolean Eliminar(Usuario p) throws ClassNotFoundException, SQLException
    {
        return DarBaja(p);
    }
    
    public static LinkedList<Object[]> ListaUsuarios() throws ClassNotFoundException, SQLException
    {
        return Lista();
    }
    public static int IngresoLogin(Usuario p) throws ClassNotFoundException, SQLException
    {
        return Ingreso(p);
    }
    public static int ObtenerID(Usuario p) throws ClassNotFoundException, SQLException
    {
        return ObtenerIdUsuario(p);
    }
    public static int ObtenerID(String user) throws ClassNotFoundException, SQLException
    {
        return ObtenerIdUsuario(user);
    }
    public static String ObtenerUser(int idUsuario) throws ClassNotFoundException, SQLException
    {
        return ObtenerUsuario(idUsuario);
    }
    public static boolean registro_log(int id,java.sql.Timestamp fecha_inicio) throws ClassNotFoundException, SQLException
    {
        return Nuevo_log(id, fecha_inicio);
    }
    public static String recuperarPassword(Usuario pUsuario) throws ClassNotFoundException,SQLException{
        return recuperarContrasena(pUsuario);
    }
}
