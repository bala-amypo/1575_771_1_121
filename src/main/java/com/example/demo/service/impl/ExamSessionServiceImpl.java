package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.service.ExamSessionService;
import com.example.demo.model.ExamSession;


@Service
public class ExamSessionServiceImpl implements ExamSessionService{

    @Autowired
    ExamSessionRepository examSessionRepository;
   

    public ExamSession createSession(ExamSession session){
        return examSessionRepository.save(session);
    }

    public Optional<ExamSession> getSession(long sessionId){
        return examSessionRepository.findById(sessionId);
    }
    
}
