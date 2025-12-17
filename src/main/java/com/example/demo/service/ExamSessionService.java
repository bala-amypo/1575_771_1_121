package com.example.demo.service;


import java.util.Optional;

import com.example.demo.model.ExamSession;


public interface ExamSessionService{
    ExamSession createSession(ExamSession session);
    Optional<ExamSession> getSession(long sessionId);
}