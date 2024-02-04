package com.dklb.filius.infrastructure.config.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CipherX {
    public static String encrypt(String value) {
        try {
            String key = generateKey();
            String vector = generateVector();
            IvParameterSpec iv = new IvParameterSpec(vector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipherX = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipherX.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipherX.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encrypted) {
        try {
            String key = generateKey();
            String vector = generateVector();
            IvParameterSpec iv = new IvParameterSpec(vector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static String generateKey() {
        return "1234567890123456";
    }

    private static String generateVector() {
        return "1234567890123456";
    }
}
