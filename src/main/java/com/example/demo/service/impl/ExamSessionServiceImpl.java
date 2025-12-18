package com.example.demo.service.impl;

import java.time.LocalDate;


import org.springframework.stereotype.Service;

import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ExamSessionService;

import com.example.demo.exception.ApiException;

import com.example.demo.model.ExamSession;


@Service
public class ExamSessionServiceImpl implements ExamSessionService{

    private final ExamSessionRepository examSessionRepository;
    private final StudentRepository studentRepository;

    public ExamSessionServiceImpl(ExamSessionRepository examSessionRepository, StudentRepository studentRepository) {
        this.examSessionRepository = examSessionRepository;
        this.studentRepository = studentRepository;
    }

    public ExamSession createSession(ExamSession session){
        if (session.getExamDate().isBefore(LocalDate.now()))
            throw new ApiException("Past date");

        if (session.getStudents() == null || session.getStudents().isEmpty())
            throw new ApiException("at least 1 student required");
        return examSessionRepository.save(session);
    }

    public ExamSession getSession(long sessionId){
        return examSessionRepository.findById(sessionId).orElseThrow(()->new ApiException("Session not found"));
    }
    
}
