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
public class CajaCierre {
    
    private int idCierre;
    private Timestamp fecha;
    private double saldo;
    private int idSucursal;
    private int idCaja;
    private int idMoneda;

    public CajaCierre() {
    }

    public CajaCierre(int idCierre, Timestamp fecha, double saldo, int idSucursal, int idCaja, int idMoneda) {
        this.idCierre = idCierre;
        this.fecha = fecha;
        this.saldo = saldo;
        this.idSucursal = idSucursal;
        this.idCaja = idCaja;
        this.idMoneda = idMoneda;
    }

    public int getIdCierre() {
        return idCierre;
    }

    public void setIdCierre(int idCierre) {
        this.idCierre = idCierre;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public int getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }
    
    public String[] DatostoArray()
    {
        String[] lista= new String[6];
        lista[0]= String.valueOf(idCierre);
        lista[1]= String.valueOf(fecha);
        lista[2]= String.valueOf(saldo);
        lista[3]= String.valueOf(idSucursal);
        lista[4]= String.valueOf(idCaja);
        lista[5]= String.valueOf(idMoneda);
        return lista;
    }


}
