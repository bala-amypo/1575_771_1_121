package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;
    private final com.example.demo.repository.UserRepository repo;

    public AuthController(UserService us, AuthenticationManager am, JwtTokenProvider jwt,
                          com.example.demo.repository.UserRepository repo) {
        this.userService = us;
        this.authManager = am;
        this.jwt = jwt;
        this.repo = repo;
    }

    public ResponseEntity<?> register(RegisterRequest r) {
        User u = User.builder()
                .name(r.getName())
                .email(r.getEmail())
                .password(r.getPassword())
                .role(r.getRole())
                .build();
        return ResponseEntity.ok(userService.register(u));
    }

    public ResponseEntity<AuthResponse> login(AuthRequest r) {
        User u = userService.findByEmail(r.getEmail());
        String token = jwt.generateToken(u.getId(), u.getEmail(), u.getRole());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
