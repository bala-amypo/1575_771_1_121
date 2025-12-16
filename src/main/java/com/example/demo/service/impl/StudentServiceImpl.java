package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowiring
    StudentRepository StudentRepository;
    Student addStudent(Student student){
        return StudentRepository.save(student);
    }
    List<Student> getAllStudents(){
        return StudentRepository.getAll();
    }
}