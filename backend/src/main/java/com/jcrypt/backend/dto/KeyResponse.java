package com.jcrypt.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class KeyResponse {
    private String privateKeyBase64;
    private String publicKeyBase64;
    private String secretKeyBase64;
}
