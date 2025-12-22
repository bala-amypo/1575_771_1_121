package com.example.demo.service.impl;
import com.example.demo.model.Student;
import java.time.LocalDate;

import org.springframework.transaction.annotation.Transactional;
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

@Transactional
public ExamSession createSession(ExamSession session) {

    if (session.getExamDate().isBefore(LocalDate.now()))
        throw new ApiException("past");

    if (session.getStudents() == null || session.getStudents().isEmpty())
        throw new ApiException("at least 1 student");

    ExamSession managedSession;

    // 🔹 CASE 1: UPDATE / ADD STUDENTS
    if (session.getId() != null) {

        managedSession = examSessionRepository.findById(session.getId())
                .orElseThrow(() -> new ApiException("Session not found"));

        // ADD students (do NOT replace)
        for (Student s : session.getStudents()) {
            managedSession.getStudents().add(s);
        }

        return managedSession; // dirty checking will save

    }

    // 🔹 CASE 2: CREATE NEW SESSION
    return examSessionRepository.save(session);
}

}


    public ExamSession getSession(Long sessionId){
        return examSessionRepository.findById(sessionId).orElseThrow(()->new ApiException("Session not found"));
    }
    
}
