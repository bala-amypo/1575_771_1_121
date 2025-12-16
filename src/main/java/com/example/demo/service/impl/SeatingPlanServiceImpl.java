package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.repository.SeatingPlanRepository;
import com.example.demo.model.SeatingPlan;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService{

    @Autowired
    SeatingRepository seatingRepository;

    @Override
    SeatingPlan generatePlan(long sessionId){
        seatingRepository.examSession.id
    }

    @Override
    SeatingPlan getPlan(long planId){
        Optional<SeatingPlan> s= findById(planId);
        if(s.presence()){
            return s.examRoom.getById(planId);
        }
    }

    @Override
    SeatingPlan getPlansBySession(long sessionId){

    }
}
