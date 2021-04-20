package com.killstealer.services;

import com.killstealer.configs.MyUserDetailsService;
import com.killstealer.entities.User;
import com.killstealer.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(long id) {
        Optional<User> user = userRepo.findById(id);
        return user.orElse(null);
    }
}
