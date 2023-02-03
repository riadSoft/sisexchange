/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Timestamp;

/**
 *
 * @author rolomen
 */
public class CajaMovimiento {
    
    private int idcajamovimiento;
    private String numero;
    private double ingreso;
    private double egreso;
    private String tipo;
    private double saldo;
    private String glosa;
    private Timestamp fecha;
    private int idDocumento;
    private int idConcepto;
    private int idMoneda;
    private int idCaja;
    private int idUsuario;

    public CajaMovimiento() {
    }

    public CajaMovimiento(int idcajamovimiento, String numero, double ingreso, double egreso, String tipo, double saldo, String glosa, Timestamp fecha, int idDocumento, int idConcepto, int idMoneda, int idCaja, int idUsuario) {
        this.idcajamovimiento = idcajamovimiento;
        this.numero = numero;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.tipo = tipo;
        this.saldo = saldo;
        this.glosa = glosa;
        this.fecha = fecha;
        this.idDocumento = idDocumento;
        this.idConcepto = idConcepto;
        this.idMoneda = idMoneda;
        this.idCaja = idCaja;
        this.idUsuario = idUsuario;
    }

    public int getIdcajamovimiento() {
        return idcajamovimiento;
    }

    public void setIdcajamovimiento(int idcajamovimiento) {
        this.idcajamovimiento = idcajamovimiento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getEgreso() {
        return egreso;
    }

    public void setEgreso(double egreso) {
        this.egreso = egreso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
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

    public String[] DatostoArray()
    {
        String[] lista= new String[12];
        
        lista[0]= String.valueOf(idcajamovimiento);
        lista[1]= numero;
        lista[2]= String.valueOf(ingreso);
        lista[3]= String.valueOf(egreso);
        lista[4]= tipo;
        lista[5]= String.valueOf(saldo);
        lista[6]= glosa;
        lista[6]= String.valueOf(fecha);
        lista[7]= String.valueOf(idDocumento);
        lista[8]= String.valueOf(idConcepto);
        lista[9]= String.valueOf(idMoneda);
        lista[10]= String.valueOf(idCaja);
        lista[11]= String.valueOf(idUsuario);
        
        return lista;
    }
}
