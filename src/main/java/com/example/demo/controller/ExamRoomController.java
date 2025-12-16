package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ExamRoom;
import com.example.demo.service.ExamRoomService;

@RestController
@RequestMapping("/rooms")
public class ExamRoomController{

    @Autowired
    ExamRoomService examRoomService;

    @PostMapping
    public ResponseEntity<ExamRoom> addRoom(@RequestBody ExamRoom examRoom){
        return ResponseEntity.status(200).body(examRoomService.addRoom(examRoom));
    }

    @GetMapping
    public ResponseEntity<ExamRoom> listRooms(@RequestBody ExamRoom examRoom){
        return ResponseEntity.status(200).body(examRoomService.getAllStudents());
    }
}