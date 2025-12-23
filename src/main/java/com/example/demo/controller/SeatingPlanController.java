package com.example.demo.controller;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;
import org.springframework.http.ResponseEntity;

public class SeatingPlanController {

    private final SeatingPlanService service;

    public SeatingPlanController(SeatingPlanService service) {
        this.service = service;
    }

    public ResponseEntity<SeatingPlan> get(Long id) {
        return ResponseEntity.ok(service.getPlan(id));
    }

    public ResponseEntity<?> list(Long sessionId) {
        return ResponseEntity.ok(service.getPlansBySession(sessionId));
    }
}
