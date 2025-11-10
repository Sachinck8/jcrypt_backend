package com.jcrypt.backend.service.encryptionservice;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.stereotype.Service;

import com.jcrypt.backend.dto.EncryptRequest;
import com.jcrypt.backend.dto.EncryptResponse;
import com.jcrypt.backend.dto.KeyResponse;

@Service
public class RSAEncryptionService {

    public EncryptResponse encrypt(EncryptRequest request) throws Exception{
        byte[] decodedKey = Base64.getDecoder().decode(request.getBase64key());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypted = cipher.doFinal(request.getMessage().getBytes());
        String encryptedtext = Base64.getEncoder().encodeToString(encrypted);
        return new EncryptResponse(encryptedtext);
    } 

    public EncryptResponse decrypt(EncryptRequest request) throws Exception{
        byte[] decodedKey = Base64.getDecoder().decode(request.getBase64key());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(request.getMessage()));
        String decryptedtext = Base64.getEncoder().encodeToString(decrypted);
        return new EncryptResponse(decryptedtext);
    } 
}
