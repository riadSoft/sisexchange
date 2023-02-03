/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

/**
 * 
 * @author rolomen
 */
public class Empresa {
    
    private int id_empresa;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    private String nit;
    private String act_ec;
    private String telefono;
    private String correo;
    private String propietario;
    private String logo;
    private int num_reg;
    private String descripcion;
    private int estado;

    public Empresa() {
    }

    public Empresa(int id_empresa, String nombre, String direccion, String ciudad, String pais, String nit, String act_ec, String telefono, String correo, String propietario, String logo, int num_reg, String descripcion, int estado) {
        this.id_empresa = id_empresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.nit = nit;
        this.act_ec = act_ec;
        this.telefono = telefono;
        this.correo = correo;
        this.propietario = propietario;
        this.logo = logo;
        this.num_reg = num_reg;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAct_ec() {
        return act_ec;
    }

    public void setAct_ec(String act_ec) {
        this.act_ec = act_ec;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getNum_reg() {
        return num_reg;
    }

    public void setNum_reg(int num_reg) {
        this.num_reg = num_reg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   

}
