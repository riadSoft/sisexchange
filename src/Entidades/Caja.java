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
public class Caja {
    
    private int idCaja;
    private String descripcion;
    private double saldoInicial;
    private double saldoFinal;
    private Timestamp fechaApertura;
    private Timestamp fechaCierre;
    private int estado;

    public Caja() {
    }

    public Caja(int idCaja, String descripcion, double saldoInicial, double saldoFinal, Timestamp fechaApertura, Timestamp fechaCierre, int estado) {
        this.idCaja = idCaja;
        this.descripcion = descripcion;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
    }

    public Caja(int idCaja, String descripcion) {
        this.idCaja = idCaja;
        this.descripcion = descripcion;
    }
    
    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Timestamp getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Timestamp fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Timestamp getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Timestamp fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public String[] DatostoArray()
    {
        String[] lista= new String[7];
        lista[0]= String.valueOf(idCaja);
        lista[1]= descripcion;
        lista[2]= String.valueOf(saldoInicial);
        lista[3]= String.valueOf(saldoFinal);
        lista[4]= String.valueOf(fechaApertura);
        lista[5]= String.valueOf(fechaCierre);
        lista[6]= String.valueOf(estado);
        return lista;
    }
    
    
    
}
