package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ExamSession;
import com.example.demo.service.ExamSessionService;

@RestController
@RequestMapping("/sessions")
public class ExamSessionController{

    @Autowired
    ExamSessionService examSessionService;

    @PostMapping
    public ResponseEntity<ExamSession> createSession(@Valid @RequestBody ExamSession examSession){
        return ResponseEntity.status(201).body(examSessionService.createSession(examSession));
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<ExamSession> getSession(@PathVariable sessionId){
        return ResponseEntity.status(200).body(examSessionService.getSession(sessionId));
    }
}