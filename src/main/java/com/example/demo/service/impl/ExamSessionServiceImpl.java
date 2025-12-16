package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ExamSession;
@Repository
public interface ExamSessionRepository extends JpaRepository<ExamSession, Long>{

}
