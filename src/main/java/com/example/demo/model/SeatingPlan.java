package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
@Table(name = "seating_plans")
public class SeatingPlan{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ExamSession examSession;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ExamRoom room;
    @Column(columnDefinition = "TEXT")
    private String arrangementJson;
    
    private LocalDateTime generatedAt;

    @PrePersist
    public void prePersist(){
        if(generatedAt==null){
        generatedAt = LocalDateTime.now();
        }
    }

    public SeatingPlan(){

    }

    public SeatingPlan(ExamSession examSession, ExamRoom room, String arrangementJson, LocalDateTime generatedAt) {
        this.examSession = examSession;
        this.room = room;
        this.arrangementJson = arrangementJson;
        this.generatedAt = generatedAt;
    }

    public Long getId() {
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