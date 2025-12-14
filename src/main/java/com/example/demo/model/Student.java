package com.example.demo.model;

public class Student{
    private long id;
    private String rollNumber;
    private String name;
    private String department;
    private Integer year;

    Student(long id,String rollNumber,String name,String department,Integer year){
        this.id=id;
        this.rollNumber=rollNumber;
        this.name=name;
        this.department = department;
        this.year=year;
    }


}