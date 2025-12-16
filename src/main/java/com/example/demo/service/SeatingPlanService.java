package com.example.demo.service;

import com.example.demo.model.SeatingPlan;

public interface SeatingPlanService{
    SeatingPlan generatePlan(long sessionId);
    SeatingPlan getPlan(long planId);
    SeatingPlan getPlansBySession(long sessionId);
}