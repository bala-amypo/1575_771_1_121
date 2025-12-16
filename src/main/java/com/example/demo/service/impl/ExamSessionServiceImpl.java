package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ExamSession;
@Service
public interface ExamSessionServiceImpl implements ExamSessionService{
    @Autowiring
    ExamSessionRepository examSessionRepository;

    ExamSession createSession(ExamSession session){
        return examSessionRepository.save(session);
    }
    ExamSession getSession(long sessionId){
        return examSessionRepository.getById(sessionId);
    }
    
}
