/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControlExcepciones {

    private static String tipo;

    public ControlExcepciones() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "ControlExcepciones{" + "tipo=" + tipo + '}';
    }

    public static void eventoTexto(String tipo, java.awt.event.KeyEvent evt, JTextField jtext) {
        char c = evt.getKeyChar();
        switch (tipo) {
            case "entero":

                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    evt.consume();
                }
                break;
            case "decimal":
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_DECIMAL) || (c == KeyEvent.VK_PERIOD))) {
                    evt.consume();
                }
                
                break;
        }
    }

}
