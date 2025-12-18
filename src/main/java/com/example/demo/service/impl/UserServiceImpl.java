package com.example.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder;
    }

    public User register(User user){
        return userRepository.save(user);
    }
    public User findByEmail(String email){
       return userRepository.findByEmail(email).orElseThrow(()->new ApiException("user not found"));
    }
}
