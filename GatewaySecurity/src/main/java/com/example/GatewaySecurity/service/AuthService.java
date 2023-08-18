package com.example.GatewaySecurity.service;

import com.example.GatewaySecurity.entity.UserCredential;
import com.example.GatewaySecurity.repository.UserCredentialRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    @Getter
    private UserCredentialRepository userCredentialRepository;

    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;

    public String saveUser(UserCredential credential)
    {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        userCredentialRepository.save(credential);
        return "User added to the system.";
    }

    public String generateToken(String username)
    {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token)
    {
        jwtService.validateToken(token);
    }
}
