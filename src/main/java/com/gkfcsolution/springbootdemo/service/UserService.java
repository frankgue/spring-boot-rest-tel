package com.gkfcsolution.springbootdemo.service;

import com.gkfcsolution.springbootdemo.model.User;
import com.gkfcsolution.springbootdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 00:02
 * File: UserService.java.java
 * Project: spring-sec-demo
 *
 * @author Frank GUEKENG
 * @date 03/08/2025
 * @time 00:02
 */
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return userRepo.save(user);
    }
}
