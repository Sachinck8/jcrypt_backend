package com.jcrypt.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EncryptRequest {

    private String message;
    private String base64key;


}
