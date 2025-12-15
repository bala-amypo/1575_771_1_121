package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    List<User> users = new ArrayList<>();
    int idx = 1;
    User register(User user){
        users.add(user);
    }
    User findByEmail(String email){

    }
}
