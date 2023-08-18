package com.example.GatewaySecurity.controller;

import com.example.GatewaySecurity.dto.UserDTO;
import com.example.GatewaySecurity.entity.UserCredential;
import com.example.GatewaySecurity.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user)
    {
        return authService.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserDTO userDTO)
    {
        // We are authenticating username and password with the help of authentication manager
        // authentication manager will go to customUserDetailService

        try
        {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getName(), userDTO.getPassword()));
            if(authentication.isAuthenticated())
                return authService.generateToken(userDTO.getName());
            else
                throw new RuntimeException("Invalid access.");
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token)
    {
        authService.validateToken(token);
        return "Token is Valid";
    }
}
