package com.jcrypt.backend.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcrypt.backend.service.encryptionservice.DESEncryptionService;
import com.jcrypt.backend.service.encryptionservice.RSAEncryptionService;

import org.springframework.web.bind.annotation.RequestBody;


import com.jcrypt.backend.dto.EncryptRequest;
import com.jcrypt.backend.dto.EncryptResponse;
import com.jcrypt.backend.service.encryptionservice.AESEncryptionService;

@RestController
@RequestMapping("/api/crypto")
public class encontrol {
 
    private final AESEncryptionService aesEncryptionService;
    private final DESEncryptionService desEncryptionService;
    private final RSAEncryptionService rsaEncryptionService;

    public encontrol(AESEncryptionService aesEncryptionService, DESEncryptionService desEncryptionService, RSAEncryptionService rsaEncryptionService){
        this.aesEncryptionService=aesEncryptionService;
        this.desEncryptionService=desEncryptionService;
        this.rsaEncryptionService=rsaEncryptionService;
    }

    @PostMapping("/aes/encrypt", produces = "application/json")
    public EncryptResponse encryptAES(@RequestBody EncryptRequest request) throws Exception{
        return aesEncryptionService.encrypt(request);
    }

    @PostMapping("/aes/decrypt", produces = "application/json")
    public EncryptResponse decryptAES(@RequestBody EncryptRequest request) throws Exception{
        return aesEncryptionService.decrypt(request);
    }

    @PostMapping("/des/encrypt", produces = "application/json")
    public EncryptResponse encryptDES(@RequestBody EncryptRequest request) throws Exception{
        return desEncryptionService.encrypt(request);
    }

    @PostMapping("/des/decrypt", produces = "application/json")
    public EncryptResponse decryptDES(@RequestBody EncryptRequest request) throws Exception{
        return desEncryptionService.decrypt(request);
    }

    @PostMapping("/rsa/encrypt", produces = "application/json")
    public EncryptResponse encryptRSA(@RequestBody EncryptRequest request) throws Exception{
        return rsaEncryptionService.encrypt(request);
    }

    @PostMapping("/rsa/decrypt", produces = "application/json")
    public EncryptResponse decryptRSA(@RequestBody EncryptRequest request) throws Exception{
        return rsaEncryptionService.decrypt(request);
    }

}
