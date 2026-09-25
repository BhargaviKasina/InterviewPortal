package com.interview.interviewportal.controller;

import com.interview.interviewportal.entity.User;
import com.interview.interviewportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "Interview Portal Running";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User loggedUser = userService.loginUser(
                user.getEmail(),
                user.getPassword());

        if (loggedUser != null) {
            return "Login Successful";
        }

        return "Invalid Email or Password";
    }
}