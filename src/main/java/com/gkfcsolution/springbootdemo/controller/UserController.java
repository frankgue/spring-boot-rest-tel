package com.gkfcsolution.springbootdemo.controller;

import com.gkfcsolution.springbootdemo.model.User;
import com.gkfcsolution.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 00:00
 * File: null.java
 * Project: spring-sec-demo
 *
 * @author Frank GUEKENG
 * @date 03/08/2025
 * @time 00:00
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        // Here you would typically save the user to the database
        // For demonstration, we are just returning the user object
        return userService.saveUser(user);
    }
}
