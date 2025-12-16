package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.StudentService;
import com.example.demo.repository.StudentRepository;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    StudentRepository studentRepository;
    
    Student addStudent(Student student){
        return studentRepository.save(student);
    }

    List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    
}