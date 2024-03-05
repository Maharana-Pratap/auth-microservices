package com.example.controller;

import com.example.dto.TokenRequestDTO;
import com.example.entity.UserCredential;
import com.example.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserAuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserCredential user) {
        return ResponseEntity.ok(authService.addUser(user));
    }

    @GetMapping("/validate/{token}")
    public String validatUserToken(@PathVariable String token) {
        authService.validateToken(token);
        return "valid token found";
    }

    @PostMapping("/token")
    public String findTokenByName(@RequestBody TokenRequestDTO user) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getName(),
                        user.getPassword()));
        if(authenticate.isAuthenticated()) {
            return authService.generateToken(user.getName());
        }
        return "Invalid token found";
    }
}
