package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {
    // This can be empty for now just to fix the "cannot find symbol" error
    public String generateToken(String username) {
        return "dummy-token";
    }
}