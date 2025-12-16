package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.ExamRoom;
@Repository
public interface ExamRoomRepository extends JpaRepository<ExamRoom, Long>{

}
