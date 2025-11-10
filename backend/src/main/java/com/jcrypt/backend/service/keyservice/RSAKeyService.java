package com.jcrypt.backend.service.keyservice;

import java.security.KeyPair;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.jcrypt.backend.crypto.CryptoKeyGenerater;
import com.jcrypt.backend.dto.KeyResponse;

@Service
public class RSAKeyService {

    public KeyResponse generateRSAKeyPair() throws Exception{
        KeyPair keyPair = CryptoKeyGenerater.generateRSAKey(2048);
        String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
        return new KeyResponse(publicKey, privateKey, null);
    }
}
