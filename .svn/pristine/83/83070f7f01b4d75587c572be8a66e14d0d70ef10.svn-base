package com.jero.esc.common;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

//配置文件转化类
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    String[] propertids=new String[]{
            "database.password"
    };


    public static void main(String[] args) {
        String root = AESEncode("esc139");
//        root=AESDecode(root);
        System.out.println(root);
    }


    public static String AESEncode(String content) {
        try {
            KeyGenerator e = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed("blazh".getBytes());
            e.init(128, random);
            SecretKey original_key = e.generateKey();
            byte[] raw = original_key.getEncoded();
            SecretKeySpec key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, key);
            byte[] byte_encode = content.getBytes("utf-8");
            byte[] byte_AES = cipher.doFinal(byte_encode);
            String AES_encode = new String((new BASE64Encoder()).encode(byte_AES));
            return AES_encode;
        } catch (NoSuchAlgorithmException var10) {
            var10.printStackTrace();
        } catch (NoSuchPaddingException var11) {
            var11.printStackTrace();
        } catch (InvalidKeyException var12) {
            var12.printStackTrace();
        } catch (IllegalBlockSizeException var13) {
            var13.printStackTrace();
        } catch (BadPaddingException var14) {
            var14.printStackTrace();
        } catch (UnsupportedEncodingException var15) {
            var15.printStackTrace();
        }

        return null;
    }

    public static String AESDecode(String content) {
        try {
            KeyGenerator e = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed("blazh".getBytes());
            e.init(128, random);
            SecretKey original_key = e.generateKey();
            byte[] raw = original_key.getEncoded();
            SecretKeySpec key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, key);
            byte[] byte_content = (new BASE64Decoder()).decodeBuffer(content);
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, "utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException var10) {
            var10.printStackTrace();
        } catch (NoSuchPaddingException var11) {
            var11.printStackTrace();
        } catch (InvalidKeyException var12) {
            var12.printStackTrace();
        } catch (IOException var13) {
            var13.printStackTrace();
        } catch (IllegalBlockSizeException var14) {
            var14.printStackTrace();
        } catch (BadPaddingException var15) {
            var15.printStackTrace();
        }
        return null;
    }

    //配
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {

        for (String propertid : propertids) {
            if (propertyName.equals(propertid)){
                String s = AESDecode(propertyValue);
                System.out.println(s);
                return s;
            }
        }


        return super.convertProperty(propertyName, propertyValue);
    }


}
