package com.example.demo.repository;

import java.util.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ExamRoom;
import com.example.demo.model.repository.ExamRoomRepository;

@Service
public interface ExamRoomServiceImpl implements ExamRoomService{

    @Autowired
    ExamRoomRepository examRoomRepository;

    @Override
    public ExamRoom addRoom(ExamRoom room){
        return examRoomRepository.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms(){
        return examRoomRepository.getAll();
    }
    
}
