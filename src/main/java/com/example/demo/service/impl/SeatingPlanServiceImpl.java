package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;
import com.example.demo.model.SeatingPlan;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService{

    @Autowired
    SeatingRepository seatingRepository;

    @Override
    public SeatingPlan generatePlan(long sessionId){
        seatingRepository.examSession.id
    }

    @Override
    public SeatingPlan getPlan(long planId){
        Optional<SeatingPlan> s= findById(planId);
        if(s.presence()){
            return s.examRoom.getById(planId);
        }
    }

    @Override
    public SeatingPlan getPlansBySession(long sessionId){

    }
}
