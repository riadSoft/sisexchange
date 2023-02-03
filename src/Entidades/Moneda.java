/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author rolomen
 */
public class Moneda {
    
    private int idMoneda;
    private String nombre;
    private String sigla;
    private BigDecimal compra;
    private BigDecimal venta;
    private BigDecimal oficial;
    private Date vigencia;
    private int estado;
    private String usuario;

    public Moneda() {
    }

    public Moneda(int idMoneda, String nombre) {
        this.idMoneda = idMoneda;
        this.nombre = nombre;
    }

    public Moneda(int idMoneda, String nombre, BigDecimal compra, BigDecimal venta, BigDecimal oficial) {
        this.idMoneda = idMoneda;
        this.nombre = nombre;
        this.compra = compra;
        this.venta = venta;
        this.oficial = oficial;
    }

    public Moneda(int idMoneda, String nombre, String sigla, BigDecimal compra, BigDecimal venta, BigDecimal oficial, Date vigencia, int estado, String usuario) {
        this.idMoneda = idMoneda;
        this.nombre = nombre;
        this.sigla = sigla;
        this.compra = compra;
        this.venta = venta;
        this.oficial = oficial;
        this.vigencia = vigencia;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public BigDecimal getCompra() {
        return compra;
    }

    public void setCompra(BigDecimal compra) {
        this.compra = compra;
    }

    public BigDecimal getVenta() {
        return venta;
    }

    public void setVenta(BigDecimal venta) {
        this.venta = venta;
    }

    public BigDecimal getOficial() {
        return oficial;
    }

    public void setOficial(BigDecimal oficial) {
        this.oficial = oficial;
    }
        
    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String[] DatostoArray()
    {
        String[] lista= new String[9];
        lista[0]= String.valueOf(idMoneda);
        lista[1]= nombre;
        lista[2]= sigla;
        lista[3]= String.valueOf(compra);
        lista[4]= String.valueOf(venta);
        lista[5]= String.valueOf(oficial);
        lista[6]= String.valueOf(vigencia);
        lista[7]= String.valueOf(estado);
        lista[8]= usuario;
        return lista;
    }
    public String[] DatostoArray2()
    {
        String[] lista= new String[5];
        lista[0]= String.valueOf(idMoneda);
        lista[1]= nombre;
        lista[2]= String.valueOf(compra);
        lista[3]= String.valueOf(venta);
        lista[4]= String.valueOf(oficial);
        
        return lista;
    }
    
}
