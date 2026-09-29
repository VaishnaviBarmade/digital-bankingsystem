package com.bank.bankapplication.controller;
import org.springframework.http.ResponseEntity;
import com.bank.bankapplication.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import com.bank.bankapplication.dto.RegisterRequestDTO;
import com.bank.bankapplication.dto.RegisterResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserAuth {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(
            @Valid @RequestBody RegisterRequestDTO  request){
        return ResponseEntity.status(201).body(authService.register(request));
    }
}
