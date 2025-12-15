package com.example.demo.model;

public class User{
    private long id;
    private String name;
    private String email;
    private String password;
    private String role;

    User(long id,String name,String email,String password,String role)
    User(long id,String name,String email,String password,String role){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.role=role;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

}