package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;

public class StudentController {

    private final StudentService service;

    public StudentController(StudentService s) {
        this.service = s;
    }

    public ResponseEntity<Student> add(Student s) {
        return ResponseEntity.ok(service.addStudent(s));
    }

    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.getAllStudents());
    }
}
