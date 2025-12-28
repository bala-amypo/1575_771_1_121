package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class AuthController {

    private UserService userService;
    private JwtTokenProvider jwt;
    private PasswordEncoder encoder;

    
    public AuthController() {
        this.encoder = new BCryptPasswordEncoder();
    }

    
    public AuthController(UserService userService,
                          AuthenticationManager ignored,
                          JwtTokenProvider jwt,
                          UserRepository ignoredRepo) {
        this.userService = userService;
        this.jwt = jwt;
        this.encoder = new BCryptPasswordEncoder();
    }

    
    @Autowired
    public AuthController(UserService userService,
                          JwtTokenProvider jwt,
                          PasswordEncoder encoder) {
        this.userService = userService;
        this.jwt = jwt;
        this.encoder = encoder;
    }

   

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest r) {

        User user = User.builder()
                .name(r.getName())
                .email(r.getEmail())
                .password(r.getPassword())
                .role(r.getRole())
                .build();

        return ResponseEntity.status(201).body(userService.register(user));
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

        return ResponseEntity.status(201).body(new AuthResponse(token));
    }
}
