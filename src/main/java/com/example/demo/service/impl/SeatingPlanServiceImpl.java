package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.SeatingPlanService;

import java.time.LocalDateTime;
import java.util.*;

public class SeatingPlanServiceImpl implements SeatingPlanService {

    private final ExamSessionRepository sessionRepo;
    private final SeatingPlanRepository planRepo;
    private final ExamRoomRepository roomRepo;

    public SeatingPlanServiceImpl(ExamSessionRepository s, SeatingPlanRepository p, ExamRoomRepository r) {
        this.sessionRepo = s;
        this.planRepo = p;
        this.roomRepo = r;
    }

    public SeatingPlan generatePlan(Long sessionId) {
        ExamSession session = sessionRepo.findById(sessionId)
                .orElseThrow(() -> new ApiException("session not found"));

        List<ExamRoom> rooms = roomRepo.findAll();
        if (rooms.isEmpty())
            throw new ApiException("no room");

        ExamRoom room = rooms.get(0);

        Map<String, String> map = new HashMap<>();
        for (Student s : session.getStudents()) {
            map.put(s.getRollNumber(), room.getRoomNumber());
        }

        SeatingPlan p = new SeatingPlan();
        p.setExamSession(session);
        p.setRoom(room);
        p.setArrangementJson(map.toString());
        p.setGeneratedAt(LocalDateTime.now());

        return planRepo.save(p);
    }

    public SeatingPlan getPlan(Long id) {
        return planRepo.findById(id)
                .orElseThrow(() -> new ApiException("plan not found"));
    }

    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return planRepo.findByExamSessionId(sessionId);
    }
}
