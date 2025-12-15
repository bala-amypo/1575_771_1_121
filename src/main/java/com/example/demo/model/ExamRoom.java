package com.example.demo.model;

public class ExamRoom{
    private long id;
    private String roomNumber;
    private String name;
    private String department;
    private int year;
    public ExamRoom(){
        
    }
    public ExamRoom(String roomNumber, String name, String department, int year) {
        this.roomNumber = roomNumber;
        this.name = name;
        this.department = department;
        this.year = year;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    
}