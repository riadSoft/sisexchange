/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import datechooser.beans.editor.utils.TextOutput;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Encriptacion implements IEncriptacion {
    
    private static String ENCRYPT_KEY = "sys234hsr2516345";

    public Encriptacion() {
        super();
    }

    @Override
    public String encritarMD5(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(texto.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public String desencriptarMD5(String texto) {

        String secretKey = "qualityinfosolutions"; //llave para desenciptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.getDecoder().decode(texto.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return base64EncryptedString;
    }
    
    @Override
    public String encriptarAES(String texto) throws Exception{
        Key aeskey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aeskey);
        byte[] encryted = cipher.doFinal(texto.getBytes());
        
        return Base64.getEncoder().encodeToString(encryted);
        
    }
    
    @Override
    public String desencriptarAES(String texto)throws Exception{
        byte [] encryptedByte = Base64.getDecoder().decode(texto.replace("\n", ""));
        
        Key asekey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");
        
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE,asekey);
        
        String decryted = new String(cipher.doFinal(encryptedByte));
        
        return decryted;
    }
    
    @Override
    public String encriptarBase64(String texto) throws UnsupportedEncodingException{
        
        return Base64.getEncoder().encodeToString(texto.getBytes());
        
    }
    
        @Override
    public String desencriptarBase64(String texto) throws UnsupportedEncodingException{
        
        byte[] decode = Base64.getDecoder().decode(texto.getBytes());
        return new String(decode,"utf-8");
        
    }
    
}
