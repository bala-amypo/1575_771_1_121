package com.example.demo.service;

import com.example.demo.model.ExamRoom;

public interface ExamRoomService{
    ExamRoom addRoom(ExamRoom room);
    ExamRoom getAllRooms();
}