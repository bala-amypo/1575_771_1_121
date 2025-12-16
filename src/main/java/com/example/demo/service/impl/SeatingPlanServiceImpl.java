package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.SeatingPlan;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService{
    @Autowiring
    SeatingRepository seatingRepository;
    SeatingPlan generatePlan(long sessionId){
        seatingRepository.examSession.id
    }
    SeatingPlan getPlan(long planId){
        Optional<SeatingPlan> s= findById(planId);
        if(s.presence()){
            return s.examRoom.getById(planId);
        }
    }
    SeatingPlan getPlansBySession(long sessionId){

    }
}
