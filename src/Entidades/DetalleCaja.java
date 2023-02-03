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
public class DetalleCaja {
    
    private int iddetallecaja;
    private int moneda;
    private double monto;
    private int estado;
    private Timestamp fecha;
    private int idcaja;

    public DetalleCaja() {
    }

    public DetalleCaja(int iddetallecaja, int moneda, double monto, int estado, Timestamp fecha, int idcaja) {
        this.iddetallecaja = iddetallecaja;
        this.moneda = moneda;
        this.monto = monto;
        this.estado = estado;
        this.fecha = fecha;
        this.idcaja = idcaja;
    }

    public int getIddetallecaja() {
        return iddetallecaja;
    }

    public void setIddetallecaja(int iddetallecaja) {
        this.iddetallecaja = iddetallecaja;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getIdcaja() {
        return idcaja;
    }

    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }
    
    public Object[] DatostoArray()
    {
        Object[] lista= new Object[6];
        lista[0]= String.valueOf(iddetallecaja);
        lista[1]= moneda;
        lista[2]= String.valueOf(monto);
        lista[3]= (estado==1?true:false);
        lista[4]= String.valueOf(fecha);
        lista[5]= String.valueOf(idcaja);
        
        return lista;
    }
    
}
