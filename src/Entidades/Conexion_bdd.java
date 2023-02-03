/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Conexion_bdd {
    
    private int id;
    private String ipserver;
    private int puerto;
    private String bdd;
    private String user;
    private String password;
    private int estado;

    public Conexion_bdd() {
    }

    public Conexion_bdd(int id, String ipserver, int puerto, String bdd, String user, String password, int estado) {
        this.id = id;
        this.ipserver = ipserver;
        this.puerto = puerto;
        this.bdd = bdd;
        this.user = user;
        this.password = password;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpserver() {
        return ipserver;
    }

    public void setIpserver(String ipserver) {
        this.ipserver = ipserver;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getBdd() {
        return bdd;
    }

    public void setBdd(String bdd) {
        this.bdd = bdd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    

}
