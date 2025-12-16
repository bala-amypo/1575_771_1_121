package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.repository.ExamSessionRepository;
import com.example.demo.model.ExamSession;

@Service
public interface ExamSessionServiceImpl implements ExamSessionService{

    @Autowired
    ExamSessionRepository examSessionRepository;

    public ExamSession createSession(ExamSession session){
        return examSessionRepository.save(session);
    }

    public ExamSession getSession(long sessionId){
        return examSessionRepository.getById(sessionId);
    }
    
}
