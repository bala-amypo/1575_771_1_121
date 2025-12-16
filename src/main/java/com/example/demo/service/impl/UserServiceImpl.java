package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowiring
    UserRepository userRepository;

    public User register(User user){
        userRepository.save(user);
        return user;
    }
    public User findByEmail(String email){
        for(User u:users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
}
