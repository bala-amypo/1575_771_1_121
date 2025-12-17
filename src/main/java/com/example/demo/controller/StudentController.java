
package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController{

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student>add(@Valid @RequestBody Student student){
        return ResponseEntity.status(201).body(studentService.addStudent(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> list(){
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }
}