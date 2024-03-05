package com.example.service;

import com.example.entity.UserCredential;
import com.example.repository.CollageUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAuthService {
    @Autowired
    private CollageUserRepository collageUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @Transactional
    public String addUser(UserCredential user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        collageUserRepository.save(user);
        return "User added in db successfully..!";
    }

    public String generateToken(String userName) {
       return jwtService.generateToken(userName);
    }
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
