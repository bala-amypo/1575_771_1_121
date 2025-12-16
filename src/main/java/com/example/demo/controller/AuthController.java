package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController{
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User>register(@Valid @RequestBody User user){
        return ResponseEntity.status(201).body(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User>login(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.findByEmail(user.getEmail()));
    }
}