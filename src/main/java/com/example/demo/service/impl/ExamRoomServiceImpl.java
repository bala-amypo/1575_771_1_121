package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.service.ExamRoomService;

@Service
public class ExamRoomServiceImpl implements ExamRoomService{

    @Autowired
    ExamRoomRepository examRoomRepository;

    @Override
    public ExamRoom addRoom(ExamRoom room){
        return examRoomRepository.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms(){
        return examRoomRepository.findAll();
    }
    
}
