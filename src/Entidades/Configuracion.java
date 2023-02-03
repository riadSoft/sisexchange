/*
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
public class Configuracion {
    
    private int id;
    private int ini_oper;
    private int act_oper;
    private int reg_log;
    private int tip_fact;
    private String link_conf;
    private int impresion;
    private int estado;
    private int idCaja;
    private int idUsuario;

    public Configuracion() {
    }

    public Configuracion(int id, int ini_oper, int act_oper, int reg_log, int tip_fact, String link_conf, int impresion, int estado, int idCaja, int idUsuario) {
        this.id = id;
        this.ini_oper = ini_oper;
        this.act_oper = act_oper;
        this.reg_log = reg_log;
        this.tip_fact = tip_fact;
        this.link_conf = link_conf;
        this.impresion = impresion;
        this.estado = estado;
        this.idCaja = idCaja;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIni_oper() {
        return ini_oper;
    }

    public void setIni_oper(int ini_oper) {
        this.ini_oper = ini_oper;
    }

    public int getAct_oper() {
        return act_oper;
    }

    public void setAct_oper(int act_oper) {
        this.act_oper = act_oper;
    }

    public int getReg_log() {
        return reg_log;
    }

    public void setReg_log(int reg_log) {
        this.reg_log = reg_log;
    }

    public int getTip_fact() {
        return tip_fact;
    }

    public void setTip_fact(int tip_fact) {
        this.tip_fact = tip_fact;
    }

    public String getLink_conf() {
        return link_conf;
    }

    public void setLink_conf(String link_conf) {
        this.link_conf = link_conf;
    }

    public int getImpresion() {
        return impresion;
    }

    public void setImpresion(int impresion) {
        this.impresion = impresion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
        String[] lista= new String[9];
        
        lista[0]= String.valueOf(id);
        lista[1]= String.valueOf(ini_oper);
        lista[2]= String.valueOf(act_oper);
        lista[3]= String.valueOf(reg_log);
        lista[4]= String.valueOf(tip_fact);
        lista[5] = this.link_conf;
        lista[6] = String .valueOf(this.impresion);
        lista[7] =  String.valueOf(this.estado);
        lista[8]= String.valueOf(idCaja);
        lista[9]= String.valueOf(idUsuario);
        
        return lista;
    }
    
}
