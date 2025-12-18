package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;


@RestController
@RequestMapping("/plans")
public class SeatingPlanController {
    
    private final SeatingPlanService seatingPlanService;

    public SeatingPlanController(SeatingPlanService seatingPlanService) {
        this.seatingPlanService = seatingPlanService;
    }

    @PostMapping("/generate/{sessionId}")
    public ResponseEntity<SeatingPlan> generateSeatingPlan(@PathVariable Long sessionId){
        return ResponseEntity.status(201).body(seatingPlanService.generatePlan(sessionId));
    }

    @GetMapping("/{planId}")
    public ResponseEntity<SeatingPlan> getSeatingPlan(@PathVariable Long planId){
        return ResponseEntity.status(200).body(seatingPlanService.getPlan(planId));
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<SeatingPlan>> getListOfPlans(@PathVariable Long sessionId){
        return ResponseEntity.status(200).body(seatingPlanService.getPlansBySession(sessionId));
    }

}
