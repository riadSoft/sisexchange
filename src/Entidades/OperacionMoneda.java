/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author rolomen
 */
public class OperacionMoneda {
    
    private int idOperacion;
    private int NroOperacion;
    private Timestamp fecha;
    private BigDecimal importe;
    private BigDecimal cotizacion;
    private String tipo;
    private String cedula;
    private String nombre;
    private int estado;
    private int idSucursal;
    private int idCaja;
    private int idUsuario;
    private int idMoneda;

    public OperacionMoneda() {
    }

    public OperacionMoneda(int idOperacion, int NroOperacion, Timestamp fecha, BigDecimal importe, BigDecimal cotizacion, String tipo, String cedula, String nombre, int estado, int idSucursal, int idCaja, int idUsuario, int idMoneda) {
        this.idOperacion = idOperacion;
        this.NroOperacion = NroOperacion;
        this.fecha = fecha;
        this.importe = importe;
        this.cotizacion = cotizacion;
        this.tipo = tipo;
        this.cedula = cedula;
        this.nombre = nombre;
        this.estado = estado;
        this.idSucursal = idSucursal;
        this.idCaja = idCaja;
        this.idUsuario = idUsuario;
        this.idMoneda = idMoneda;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getNroOperacion() {
        return NroOperacion;
    }

    public void setNroOperacion(int NroOperacion) {
        this.NroOperacion = NroOperacion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(BigDecimal cotizacion) {
        this.cotizacion = cotizacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    @Override
    public String toString() {
        return "OperacionMoneda{" + "idOperacion=" + idOperacion + ", NroOperacion=" + NroOperacion + ", fecha=" + fecha + ", importe=" + importe + ", cotizacion=" + cotizacion + ", tipo=" + tipo + ", cedula=" + cedula + ", nombre=" + nombre + ", estado=" + estado + ", idSucursal=" + idSucursal + ", idCaja=" + idCaja + ", idUsuario=" + idUsuario + ", idMoneda=" + idMoneda + '}';
    }
    
    public String[] DatostoArray()
    {
        String[] lista= new String[13];
        lista[0]= String.valueOf(idOperacion);
        lista[1]= String.valueOf(NroOperacion);
        lista[2]= String.valueOf(fecha);
        lista[3]= String.valueOf(importe);
        lista[4]= String.valueOf(cotizacion);
        lista[5]= tipo; 
        lista[6]= cedula;
        lista[7]= nombre;
        lista[8]= String.valueOf(estado);
        lista[9]= String.valueOf(idSucursal);
        lista[10]= String.valueOf(idCaja);
        lista[11]= String.valueOf(idUsuario);
        lista[12]= String.valueOf(idMoneda);
        
        return lista;
    }
    
}
