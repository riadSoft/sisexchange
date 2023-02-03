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
public class ConceptoCaja {
    
    private int idconcepto;
    private String nombre;
    private int estado;

    public ConceptoCaja() {
    }

    public ConceptoCaja(int idconcepto, String nombre, int estado) {
        this.idconcepto = idconcepto;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(int idconcepto) {
        this.idconcepto = idconcepto;
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
        lista[0]= String.valueOf(idconcepto);
        lista[1]= nombre;
        lista[2]= String.valueOf(estado);
        
        return lista;
    }
    
}
