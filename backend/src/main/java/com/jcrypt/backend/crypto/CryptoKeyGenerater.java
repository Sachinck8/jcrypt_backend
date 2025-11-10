package com.jcrypt.backend.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CryptoKeyGenerater {

    public static SecretKey generateAESKey(int keySize) throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keySize);
        return keyGen.generateKey();

    }

    public static SecretKey generateDESKey() throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56);
        return keyGen.generateKey();

    }

    public static KeyPair generateRSAKey(int keySize) throws Exception{
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(keySize);
        return keyPairGen.generateKeyPair();

    }


}
