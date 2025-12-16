package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.repository.StudentRepository;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository StudentRepository;
    Student addStudent(Student student){
        return StudentRepository.save(student);
    }
    List<Student> getAllStudents(){
        return StudentRepository.getAll();
    }
}