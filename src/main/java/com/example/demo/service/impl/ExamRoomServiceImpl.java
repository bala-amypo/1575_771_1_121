package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ExamRoom;
import com.example.demo.repository.ExamRoomRepository;
import com.example.demo.service.ExamRoomService;

import com.example.demo.exception.ApiException;

@Service
public class ExamRoomServiceImpl implements ExamRoomService{

    private final ExamRoomRepository examRoomRepository;

    public ExamRoomServiceImpl(ExamRoomRepository examRoomRepository) {
        this.examRoomRepository = examRoomRepository;
    }

    @Override
    public ExamRoom addRoom(ExamRoom room){
        if(room.getRows()<=0||room.getColumns()<=0 || room.getCapacity()!=(room.getRows()*room.getColumns())){
            throw new ApiException("invalid rows");
        }
        if(examRoomRepository.findByRoomNumber(room.getRoomNumber()).isPresent()){
            throw new ApiException("exists");
        }
        room.ensureCapacityMatches();
        return examRoomRepository.save(room);
    }

    @Override
    public List<ExamRoom> getAllRooms(){
        return examRoomRepository.findAll();
    }
    
}
