package com.jcrypt.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Getter
@Setter
@Data
public class EncryptRequest {

    private String message;
    private String base64key;


}
