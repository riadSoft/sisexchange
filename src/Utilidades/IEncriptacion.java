
package Utilidades;

import java.io.UnsupportedEncodingException;


public interface IEncriptacion {
    
    public String encritarMD5(String texto);
    public String desencriptarMD5(String texto);
    public String encriptarAES(String texto) throws Exception;
    public String desencriptarAES(String texto)throws Exception;
    public String encriptarBase64(String texto)throws UnsupportedEncodingException;
    public String desencriptarBase64(String texto)throws UnsupportedEncodingException;
    
}
