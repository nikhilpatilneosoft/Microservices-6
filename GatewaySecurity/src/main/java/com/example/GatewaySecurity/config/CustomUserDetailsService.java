package com.example.GatewaySecurity.config;

import com.example.GatewaySecurity.entity.UserCredential;
import com.example.GatewaySecurity.repository.UserCredentialRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

//@Configuration
//@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    //here we will find the user with the help of username
    //we will return the userdetail service object which manager will take
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserCredential> credential = userCredentialRepository.findByName(username);
       return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found."));
    }
}
