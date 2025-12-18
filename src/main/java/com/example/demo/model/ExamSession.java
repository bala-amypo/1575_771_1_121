package com.example.demo.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "exam_sessions")
public class ExamSession{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private LocalDate examDate;
    private String examTime;
    @ManyToMany
    private Set<Student> students;

    public ExamSession(){

    }

    

    public long getId() {
        return id;
    }

    public ExamSession(String courseCode, LocalDate examDate, String examTime, Set<Student> students) {
        this.courseCode = courseCode;
        this.examDate = examDate;
        this.examTime = examTime;
        this.students = students;
    }



    public void setId(long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }



    public List<Student> getStudents() {
        return students;
    }



    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    
    
    
}