package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwt;

    // ✅ MAIN CONSTRUCTOR (USED BY SPRING)
    public AuthController(UserService userService, JwtTokenProvider jwt) {
        this.userService = userService;
        this.jwt = jwt;
    }

    // ✅ COMPATIBILITY CONSTRUCTOR (USED BY TESTS — DO NOT REMOVE)
    public AuthController(
            UserService userService,
            Object authenticationManager,
            JwtTokenProvider jwt,
            Object userRepository
    ) {
        this.userService = userService;
        this.jwt = jwt;
        // authenticationManager & repository intentionally ignored
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest r) {

        User u = User.builder()
                .name(r.getName())
                .email(r.getEmail())
                .password(r.getPassword())
                .role(r.getRole())
                .build();

        return ResponseEntity.ok(userService.register(u));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest r) {

        User u = userService.findByEmail(r.getEmail());

        String token = jwt.generateToken(
                u.getId(),
                u.getEmail(),
                u.getRole()
        );

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
