package com.bank.bankapplication.dto;

import lombok.Data;

@Data
public class RegisterResponseDTO {
    private String message;
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
}
