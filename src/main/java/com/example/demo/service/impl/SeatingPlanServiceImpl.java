package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;
import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamSession;
import com.example.demo.model.SeatingPlan;
import com.example.demo.model.ExamRoom; 
import com.example.demo.model.Student;  
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.SeatingPlanRepository;
import com.example.demo.service.SeatingPlanService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SeatingPlanServiceImpl implements SeatingPlanService {

    // These are the names you defined
    private final ExamSessionRepository examSessionRepository;
    private final SeatingPlanRepository seatingPlanRepository;
    private final ExamRoomRepository examRoomRepository;

    public SeatingPlanServiceImpl(ExamSessionRepository s, SeatingPlanRepository p, ExamRoomRepository r) {
        this.examSessionRepository = s;
        this.seatingPlanRepository = p;
        this.examRoomRepository = r;
    }

    @Override
    public SeatingPlan generatePlan(Long sessionId) {
        
        
        Optional<ExamSession> sessionOpt = examSessionRepository.findById(sessionId);
        if (!sessionOpt.isPresent()) {
            throw new ApiException("session not found");
        }

        ExamSession session = sessionOpt.get();
        int studentCount = session.getStudents().size();

        List<ExamRoom> rooms = examRoomRepository.findAll();
        ExamRoom selectedRoom = null;

        for (ExamRoom room : rooms) {
            if (room.getCapacity() >= studentCount) {
                selectedRoom = room;
                break; 
            }
        }

        if (selectedRoom == null) {
            throw new ApiException("no room");
        }

        Map<String, String> seatingMap = new LinkedHashMap<>();
        int seatIndex = 1;

        for (Student student : session.getStudents()) {
            seatingMap.put("Seat-" + seatIndex, student.getRollNumber());
            seatIndex++;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();

            SeatingPlan plan = new SeatingPlan();
            plan.setExamSession(session);
            plan.setRoom(selectedRoom);
            plan.setArrangementJson(mapper.writeValueAsString(seatingMap));

            return seatingPlanRepository.save(plan);

        } catch (Exception e) {
            throw new ApiException("json error");
        }
    }

    @Override
    public SeatingPlan getPlan(Long planId) {
        return seatingPlanRepository.findById(planId)
                .orElseThrow(() -> new ApiException("plan not found"));
    }

    @Override
    public List<SeatingPlan> getPlansBySession(Long sessionId) {
        return seatingPlanRepository.findByExamSessionId(sessionId);
    }
}