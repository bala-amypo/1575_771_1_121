package com.example.demo.controller;

import com.example.demo.model.ExamRoom;
import com.example.demo.service.ExamRoomService;
import org.springframework.http.ResponseEntity;

public class ExamRoomController {

    private final ExamRoomService service;

    public ExamRoomController(ExamRoomService service) {
        this.service = service;
    }

    public ResponseEntity<ExamRoom> add(ExamRoom r) {
        return ResponseEntity.ok(service.addRoom(r));
    }

    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.getAllRooms());
    }
}
