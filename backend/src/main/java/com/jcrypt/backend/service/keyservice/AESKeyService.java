package com.jcrypt.backend.service.keyservice;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.jcrypt.backend.crypto.CryptoKeyGenerater;
import com.jcrypt.backend.dto.KeyResponse;

@Service
public class AESKeyService{
   public KeyResponse generateAESKey() throws Exception{
      SecretKey key = CryptoKeyGenerater.generateAESKey(128);
      String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
      return new KeyResponse(null, null, encodedKey);

   }
}