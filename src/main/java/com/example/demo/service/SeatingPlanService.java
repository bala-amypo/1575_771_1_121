package com.example.demo.service;

import java.util.List;

import com.example.demo.model.SeatingPlan;

public interface SeatingPlanService{
    SeatingPlan generatePlan(long sessionId);
    SeatingPlan getPlan(long planId);
    List<SeatingPlan> getPlansBySession(long sessionId);
}