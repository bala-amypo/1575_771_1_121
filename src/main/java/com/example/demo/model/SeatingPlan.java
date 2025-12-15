package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SeatingPlan{
    private long id;
    private ExamSession examSession;
    private ExamRoom room;
    private String arrangementJson;
    private LocalDateTime generatedAt;

    public SeatingPlan(){

    }

    public SeatingPlan(ExamSession examSession, ExamRoom room, String arrangementJson, LocalDateTime generatedAt) {
        this.examSession = examSession;
        this.room = room;
        this.arrangementJson = arrangementJson;
        this.generatedAt = generatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ExamSession getExamSession() {
        return examSession;
    }

    public void setExamSession(ExamSession examSession) {
        this.examSession = examSession;
    }

    public ExamRoom getRoom() {
        return room;
    }

    public void setRoom(ExamRoom room) {
        this.room = room;
    }

    public String getArrangementJson() {
        return arrangementJson;
    }

    public void setArrangementJson(String arrangementJson) {
        this.arrangementJson = arrangementJson;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
    
}