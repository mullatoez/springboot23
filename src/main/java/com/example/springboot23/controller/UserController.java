package com.example.springboot23.controller;

import com.example.springboot23.entity.User;
import com.example.springboot23.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/list")
    public List<User> getUserById(){
        User user = new User(1L,"Admin","admin@001","admin@100");
        userRepository.save(user);
        return userRepository.findAll();
    }
}
