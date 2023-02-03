/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author rolomen
 */
public class Sucursal {
    
    private int idSucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private String responsable;
    private int ncaja;
    private String nit;
    private String nautorizacion;
    private String llave;
    private Date fecha;
    private String leyenda;
    private String actEconomica;
    private int ininfact;
    private int actnfact;
    private int finnfact;
    private int estado;

    public Sucursal() {
    }

    public Sucursal(int idSucursal, String nombre, String direccion, String telefono, String responsable, int ncaja, String nit, String nautorizacion, String llave, Date fecha, String leyenda, String actEconomica, int ininfact, int actnfact, int finnfact, int estado) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.responsable = responsable;
        this.ncaja = ncaja;
        this.nit = nit;
        this.nautorizacion = nautorizacion;
        this.llave = llave;
        this.fecha = fecha;
        this.leyenda = leyenda;
        this.actEconomica = actEconomica;
        this.ininfact = ininfact;
        this.actnfact = actnfact;
        this.finnfact = finnfact;
        this.estado = estado;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getNcaja() {
        return ncaja;
    }

    public void setNcaja(int ncaja) {
        this.ncaja = ncaja;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNautorizacion() {
        return nautorizacion;
    }

    public void setNautorizacion(String nautorizacion) {
        this.nautorizacion = nautorizacion;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public String getActEconomica() {
        return actEconomica;
    }

    public void setActEconomica(String actEconomica) {
        this.actEconomica = actEconomica;
    }

    public int getIninfact() {
        return ininfact;
    }

    public void setIninfact(int ininfact) {
        this.ininfact = ininfact;
    }

    public int getActnfact() {
        return actnfact;
    }

    public void setActnfact(int actnfact) {
        this.actnfact = actnfact;
    }

    public int getFinnfact() {
        return finnfact;
    }

    public void setFinnfact(int finnfact) {
        this.finnfact = finnfact;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public String[] DatostoArray()
    {
        String[] lista= new String[16];
        
        lista[0]= String.valueOf(idSucursal);
        lista[1]= nombre;
        lista[2]= direccion;
        lista[3]= telefono;
        lista[4]= responsable;
        lista[5]= String.valueOf(ncaja);
        lista[6] = nit;
        lista[7] = nautorizacion;
        lista[8] = llave;
        lista[9] = String.valueOf(fecha);
        lista[10] = leyenda;
        lista[11] = actEconomica;
        lista[12]= String.valueOf(ininfact);
        lista[13]= String.valueOf(actnfact);
        lista[14]= String.valueOf(finnfact);
        lista[15]= String.valueOf(estado);
        
        return lista;
    }
    
}
