package com.example.demo.model;

public class Student{
    private long id;
    private String rollNumber;
    private String name;
    private String department;
    private Integer year;

    public Student(){
       
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

    public void setId(long id) {
        this.id = id;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}