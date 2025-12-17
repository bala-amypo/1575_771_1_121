package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

public class SeatingPlan{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ExamSession examSession;
    @ManyToOne
    private ExamRoom room;
    @Column(columnDefinition = "TEXT")
    private String arrangementJson;
    
    private LocalDateTime generatedAt;

    @PrePersist
    public void onCreate(){
        generatedAt = LocalDateTime.now();
    }

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