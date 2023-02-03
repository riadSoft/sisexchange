/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author rolomen
 */
public class Usuario {
    
    private int id;
    private String login;
    private String password;
    private String nombre;
    private String apellidos;
    private String celular;
    private Timestamp fecha_registro;

    public Usuario() {
    }

    public Usuario(int id, String login, String password, String nombre, String apellidos, String celular, Timestamp fecha_registro) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.celular = celular;
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Timestamp getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Timestamp fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    public String[] DatostoArray()
    {
        String[] lista= new String[7];
        lista[0]= String.valueOf(id);
        lista[1]= login;
        lista[2]= password;
        lista[3]= nombre;
        lista[4]= apellidos;
        lista[5]= celular;
        lista[6]= String.valueOf(fecha_registro);
        return lista;
    }
}
