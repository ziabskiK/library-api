package com.app.spring.controller;


import com.app.spring.model.book.user.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping
    public User register() {
        return null;
    }
}
