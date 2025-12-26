package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwt;
    private final PasswordEncoder encoder;

    // ✅ SINGLE constructor — Spring-friendly
    public AuthController(UserService userService,
                          JwtTokenProvider jwt,
                          PasswordEncoder encoder) {

        this.userService = userService;
        this.jwt = jwt;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest r) {

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

        if (!encoder.matches(r.getPassword(), u.getPassword())) {
            return ResponseEntity.status(401).build();
        }

        String token = jwt.generateToken(
                u.getId(),
                u.getEmail(),
                u.getRole());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
