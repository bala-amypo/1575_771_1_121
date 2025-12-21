package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.service.StudentService;


import com.example.demo.model.ExamRoom; 
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.exception.ApiException;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
    
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public Student addStudent(Student student){
        if(student.getRollNumber()==null||student.getYear()==null){
            throw  new ApiException("invalid student");
        }
        if(student.getYear()<1 || student.getYear()>5){
            throw new ApiException("year");
        }
        if(studentRepository.findByRollNumber(student.getRollNumber()).isPresent()){
            throw new ApiException("exists");
        }
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

}
