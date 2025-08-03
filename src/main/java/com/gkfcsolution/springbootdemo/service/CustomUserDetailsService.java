package com.gkfcsolution.springbootdemo.service;


import com.gkfcsolution.springbootdemo.model.User;
import com.gkfcsolution.springbootdemo.model.UserPrincipal;
import com.gkfcsolution.springbootdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 22:38
 * File: null.java
 * Project: spring-sec-demo
 *
 * @author Frank GUEKENG
 * @date 02/08/2025
 * @time 22:38
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database using the UserRepo
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new UserPrincipal(user);
    }
}
