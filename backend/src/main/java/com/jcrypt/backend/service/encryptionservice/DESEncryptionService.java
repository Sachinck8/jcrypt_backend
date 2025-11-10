package com.jcrypt.backend.service.encryptionservice;

import java.util.Base64;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.jcrypt.backend.dto.EncryptRequest;
import com.jcrypt.backend.dto.EncryptResponse;

@Service
public class DESEncryptionService {

    public EncryptResponse encrypt(EncryptRequest request) throws Exception{
        byte[] decodedKey = Base64.getDecoder().decode(request.getBase64key());

        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        byte[] encrypted = cipher.doFinal(request.getMessage().getBytes());

        String encryptedtext = Base64.getEncoder().encodeToString(encrypted);

        return new EncryptResponse(encryptedtext);
    }


    public EncryptResponse decrypt(EncryptRequest request) throws Exception{
        byte[] decodedKey = Base64.getDecoder().decode(request.getBase64key());

        SecretKey secretKey = new SecretKeySpec(decodedKey, 0,decodedKey.length,"DES");

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(request.getMessage()));

        String decryptedtext = new String(decrypted);
        return new EncryptResponse(decryptedtext);
    }
}
