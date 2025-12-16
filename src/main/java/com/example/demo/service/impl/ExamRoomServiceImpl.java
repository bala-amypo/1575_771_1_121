package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo1.model.ExamRoom;
@Service
public interface ExamRoomServiceImpl implements ExamRoomService{
    @Autowiring
    ExamRoomRepository examRoomRepository;
    ExamRoom addRoom(ExamRoom room){
        return examRoomRepository.save(room);
    }
    List<ExamRoom> getAllRooms(){
        return examRoomRepository.getAll();
    }
    
}
