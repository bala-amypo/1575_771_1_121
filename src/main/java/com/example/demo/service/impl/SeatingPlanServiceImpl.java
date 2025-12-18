package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;



@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamSessionRepository examSessionRepository;
    private final SeatingPlanRepository seatingPlanRepository;
    private final ExamRoomRepository examRoomRepository;

    public SeatingPlanServiceImpl(ExamSessionRepository s, SeatingPlanRepository p, ExamRoomRepository r) {
        this.examSessionRepository = s;
        this.seatingPlanRepository = p;
        this.examRoomRepository = r;
    }

    @Override
    public SeatingPlan generatePlan(long sessionId) {
        ExamSession session = examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("ExamSession not found"));

        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        return seatingPlanRepository.save(plan);
    }

    @Override
    public SeatingPlan getPlan(long planId) {
        return seatingPlanRepository.findById(planId)
                .orElseThrow(() -> new ApiException("plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(long sessionId) {
        return seatingPlanRepository.findByExamSessionId(sessionId);
    }
}
