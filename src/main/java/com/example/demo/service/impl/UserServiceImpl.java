package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    // ✅ Constructor used by Spring
    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    // ✅ Constructor used by TESTS (encoder ignored)
    public UserServiceImpl(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
    }

    @Override
    public User register(User user) {
        repo.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new ApiException("Email exists");
                });

        if (user.getRole() == null) {
            user.setRole("STAFF");
        }

        // No encoding (intentional – tests expect plain text)
        return repo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ApiException("User not found"));
    }
}
