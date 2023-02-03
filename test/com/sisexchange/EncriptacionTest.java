/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sisexchange;

import Utilidades.Encriptacion;
import Utilidades.IEncriptacion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class EncriptacionTest {
    
    public EncriptacionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void encriptacionMD5Test() {
        
        Encriptacion vEncriptacion = new Encriptacion();
        String vtexto = "rolomen23";
        String vresultao = vEncriptacion.encritarMD5(vtexto);
        System.out.println("METODO MD5");
        System.out.println("Encriptado:"+vresultao);
        System.out.println("Desencriptado:"+vEncriptacion.desencriptarMD5(vresultao));
        assertTrue(vresultao.length()>0);
        
    }
    @Test
    public void encriptacionAesTest() {
        
        Encriptacion vEncriptacion = new Encriptacion();
        String vtexto = "admin";
        String vresultao="";
        try {
            vresultao = vEncriptacion.encriptarAES(vtexto);
            System.out.println("METODO AES");
            System.out.println("Encriptado:"+vresultao);
            System.out.println("Desencriptado:"+vEncriptacion.desencriptarAES(vresultao));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        assertTrue(vresultao.length()>0);
        
    }
}
