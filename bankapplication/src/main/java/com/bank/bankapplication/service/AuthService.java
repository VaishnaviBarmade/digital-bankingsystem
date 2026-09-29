package com.bank.bankapplication.service;
import com.bank.bankapplication.entity.UserEntity;
import com.bank.bankapplication.dto.RegisterRequestDTO;
import com.bank.bankapplication.dto.RegisterResponseDTO;
import com.bank.bankapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public RegisterResponseDTO register(RegisterRequestDTO request)
    {
          if(userRepository.existsByEmail(request.getEmail())){
              throw new RuntimeException("Email Already Register");
          }
          if(userRepository.existsByMobileNumber(request.getMobileNumber())){
              throw new RuntimeException("Mobile Number Is Already Register");
          }
          UserEntity user=new UserEntity();
          user.setFirstName(request.getFirstName());
          user.setLastName(request.getLastName());
          user.setEmail(request.getEmail());
          user.setMobileNumber(request.getMobileNumber());
          user.setPassword(passwordEncoder.encode(request.getPassword()));
          user.setRole("CUSTOMER");
          userRepository.save(user);
          RegisterResponseDTO response=new RegisterResponseDTO();
          response.setMessage("Registration successful");
        response.setUserId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setMobileNumber(user.getMobileNumber());

        return response;
    }
}
