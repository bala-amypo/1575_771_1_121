package com.example.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.ExamSession;
@Repository
public interface ExamSessionRepository extends JpaRepository<ExamSession, Long>{

}
