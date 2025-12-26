package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwt;
    private final PasswordEncoder encoder;

    /* ===========================================================
       SPRING CONSTRUCTOR (ONLY ONE SPRING WILL EVER USE)
       =========================================================== */
    public AuthController(UserService userService,
                          JwtTokenProvider jwtTokenProvider,
                          PasswordEncoder passwordEncoder) {

        this.userService = userService;
        this.jwt = jwtTokenProvider;
        this.encoder = passwordEncoder;
    }

    /* ===========================================================
       TEST CONSTRUCTOR (EXACT SIGNATURE REQUIRED)
       =========================================================== */
    public AuthController(UserService userService,
                          AuthenticationManager ignored,
                          JwtTokenProvider jwtTokenProvider,
                          PasswordEncoder passwordEncoder) {

        this.userService = userService;
        this.jwt = jwtTokenProvider;
        this.encoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest r) {

        User user = User.builder()
                .name(r.getName())
                .email(r.getEmail())
                .password(r.getPassword())
                .role(r.getRole())
                .build();

        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest r) {

        User user = userService.findByEmail(r.getEmail());

        if (!encoder.matches(r.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).build();
        }

        String token = jwt.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
