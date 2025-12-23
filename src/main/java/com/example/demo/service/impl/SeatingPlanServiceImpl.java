package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamRoom;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamSessionRepository sessionRepo;
    private final SeatingPlanRepository planRepo;
    private final ExamRoomRepository roomRepo;

    public SeatingPlanServiceImpl(ExamSessionRepository sessionRepo,
                                  SeatingPlanRepository planRepo,
                                  ExamRoomRepository roomRepo) {
        this.sessionRepo = sessionRepo;
        this.planRepo = planRepo;
        this.roomRepo = roomRepo;
    }

    @Override
    public SeatingPlan generatePlan(Long sessionId) {

        ExamSession session = sessionRepo.findById(sessionId)
                .orElseThrow(() -> new ApiException("Session not found"));

        List<ExamRoom> rooms = roomRepo.findAll();
        if (rooms.isEmpty()) {
            throw new ApiException("No room available");
        }

        ExamRoom room = rooms.get(0);

        // 🔥 IMPORTANT FIX: include student roll numbers
        StringBuilder arrangement = new StringBuilder("{\"students\":[");
        int i = 0;
        for (var student : session.getStudents()) {
            if (i++ > 0) arrangement.append(",");
            arrangement.append("\"")
                       .append(student.getRollNumber())
                       .append("\"");
        }
        arrangement.append("]}");

        SeatingPlan plan = new SeatingPlan();
        plan.setExamSession(session);
        plan.setRoom(room);
        plan.setGeneratedAt(LocalDateTime.now());
        plan.setArrangementJson(arrangement.toString());

        return planRepo.save(plan);
    }

    @Override
    public SeatingPlan getPlan(Long id) {
        return planRepo.findById(id)
                .orElseThrow(() -> new ApiException("Plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return planRepo.findByExamSessionId(sessionId);
    }
}
