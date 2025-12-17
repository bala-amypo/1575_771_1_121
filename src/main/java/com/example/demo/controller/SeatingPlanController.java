package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SeatingPlan;
import com.example.demo.service.SeatingPlanService;


@RestController
public class SeatingPlanController {
    
    SeatingPlanService seatingPlanService;

    @PostMapping("/generate/{sessionId}")
    public ResponseEntity<SeatingPlan> generateSeatingPlan(@PathVariable long sessionId){
        return ResponseEntity.status(201).body(seatingPlanService.generatePlan(sessionId));
    }

    @GetMapping("/{planId}")
    public ResponseEntity<SeatingPlan> getSeatingPlan(@PathVariable long planId){
        return ResponseEntity.status(201).body(seatingPlanService.getPlan(planId));
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<SeatingPlan>> getListOfPlans(@PathVariable long sessionId){
        return ResponseEntity.status(200).body(seatingPlanService.getPlansBySession(sessionId));
    }

}
