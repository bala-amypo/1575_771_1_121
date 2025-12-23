package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student s) {
        if (s.getRollNumber() == null)
            throw new ApiException("roll required");
        if (s.getYear() == null || s.getYear() < 1 || s.getYear() > 5)
            throw new ApiException("year invalid");
        if (repo.findByRollNumber(s.getRollNumber()).isPresent())
            throw new ApiException("exists");
        return repo.save(s);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}
