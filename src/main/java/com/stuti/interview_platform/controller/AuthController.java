package com.stuti.interview_platform.controller;

import com.stuti.interview_platform.entity.User;
import com.stuti.interview_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    // OPEN LOGIN PAGE
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // OPEN REGISTER PAGE
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // REGISTER USER
    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
    ) {

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        service.registerUser(user);

        return "redirect:/login";
    }

    
}
