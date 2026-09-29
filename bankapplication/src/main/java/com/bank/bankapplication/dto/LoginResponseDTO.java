package com.bank.bankapplication.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String message;
    private Long userId;
    private String email;
    private String role;
    private String token;
}
