package com.app.spring.controller;


import com.app.spring.model.user.User;
import com.app.spring.service.auth.LoginService;
import com.app.spring.service.auth.RegisterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

    private LoginService loginService;
    private RegisterService registerService;

    public AuthController(LoginService loginService, RegisterService registerService) {
        this.loginService = loginService;
        this.registerService = registerService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return registerService.register(user);
    }
}
