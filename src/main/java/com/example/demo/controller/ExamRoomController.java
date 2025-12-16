package com.example.demo.controller;

import java.util.List;

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
    public ResponseEntity<ExamRoom> addRoom(@Valid @RequestBody ExamRoom examRoom){
        return new ResponseEntity.status(201).body(examRoomService.addRoom(examRoom));
    }

    @GetMapping
    public ResponseEntity<List<ExamRoom>> listRooms(){
        return ResponseEntity.status(200).body(examRoomService.getAllRooms());
    }
}