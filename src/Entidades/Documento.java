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
public class Documento {
    
    private int idDocumento;
    private String nombre;
    private int estado;

    public Documento() {
    }

    public Documento(int idDocumento, String nombre, int estado) {
        this.idDocumento = idDocumento;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
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
    
    public String[] DatostoArray()
    {
        String[] lista= new String[3];
        lista[0]= String.valueOf(idDocumento);
        lista[1]= nombre;
        lista[2]= String.valueOf(estado);
        return lista;
    }
    
}
