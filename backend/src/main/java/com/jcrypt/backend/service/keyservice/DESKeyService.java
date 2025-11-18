package com.jcrypt.backend.service.keyservice;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.jcrypt.backend.crypto.CryptoKeyGenerater;
import com.jcrypt.backend.dto.KeyResponse;
@Service
public class DESKeyService {

    public KeyResponse generateDESKey() throws Exception{
      SecretKey key = CryptoKeyGenerater.generateDESKey();
      String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
      return new KeyResponse(null, null, encodedKey);
}

}
