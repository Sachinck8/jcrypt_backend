package com.jcrypt.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jcrypt.backend.BackendApplication;
import com.jcrypt.backend.dto.KeyResponse;
import com.jcrypt.backend.service.keyservice.AESKeyService;
import com.jcrypt.backend.service.keyservice.DESKeyService;
import com.jcrypt.backend.service.keyservice.RSAKeyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/keys")
public class KeyController {

    

    private final AESKeyService aesService;
    private final DESKeyService desService;
    private final RSAKeyService rsaService;

    public KeyController(AESKeyService aesService, DESKeyService desService, RSAKeyService rsaService, BackendApplication backendApplication){
        this.aesService=aesService;
        this.desService=desService;
        this.rsaService=rsaService;
        

    }

    @PostMapping("/aes")
    public KeyResponse generateAESKey() throws Exception{
        return aesService.generateAESKey();
    }

    @PostMapping("/des")
    public KeyResponse generateDESKey() throws Exception{
        return desService.generateDESKey();
    }

    @PostMapping("/rsa")
    public KeyResponse generateRSAKeyPair() throws Exception{
        return rsaService.generateRSAKeyPair();
    }

    
}
