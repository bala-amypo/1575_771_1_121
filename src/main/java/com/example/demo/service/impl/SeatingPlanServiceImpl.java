package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;
import com.example.demo.model.SeatingPlan;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService{

    @Autowired
    SeatingPlanRepository seatingPlanRepository;
    ExamSessionRepository examSessionRepository;
    ExamRoomRepository examRoomRepository;

    @Override
    public SeatingPlan generatePlan(long sessionId){
        ExamSession session = examSessionRepository.findById(sessionId);

    }

    @Override
    public SeatingPlan getPlan(long planId){
        Optional<SeatingPlan> s= findById(planId);
        if(s.presence()){
            return s.examRoom.getById(planId);
        }
    }

    @Override
    public List<SeatingPlan> getPlansBySession(long sessionId){
        return seatingPlanRepository.findBy
    }
}
