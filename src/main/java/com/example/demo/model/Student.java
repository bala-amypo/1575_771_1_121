package com.example.demo.model;

public class Student{
    private long id;
    private String rollNumber;
    private String name;
    private String department;
    private Integer year;

    public Student(long id,String rollNumber,String name,String department,Integer year){
       
    }

    public Student(String rollNumber,String name,String department,Integer year){
        this.rollNumber=rollNumber;
        this.name=name;
        this.department = department;
        this.year=year;
    }

    public long getId(){
        return id;
    }

    public String getRollNumber(){
        return rollNumber;
    }

    public String getName(){
        return name;
    }

    public String getDepartment(){
        return department;
    }

    public Integer getYear(){
        return year;
    }
}