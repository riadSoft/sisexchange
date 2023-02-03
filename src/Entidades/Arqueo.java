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
public class Arqueo {
    private int idArqueo;
    private String denominacion;
    private String tipo;
    private double valor;
    private int cantidad;
    private int idMoneda;

    public Arqueo() {
    }

    public Arqueo(int idArqueo, String denominacion, String tipo, double valor, int cantidad, int idMoneda) {
        this.idArqueo = idArqueo;
        this.denominacion = denominacion;
        this.tipo = tipo;
        this.valor = valor;
        this.cantidad = cantidad;
        this.idMoneda = idMoneda;
    }

    public int getIdArqueo() {
        return idArqueo;
    }

    public void setIdArqueo(int idArqueo) {
        this.idArqueo = idArqueo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        lista[0]= String.valueOf(idArqueo);
        lista[1]= denominacion;
        lista[2]= tipo;
        lista[3]= String.valueOf(valor);
        lista[4]= String.valueOf(cantidad);
        lista[5]= String.valueOf(idMoneda);
        return lista;
    }
    
}
