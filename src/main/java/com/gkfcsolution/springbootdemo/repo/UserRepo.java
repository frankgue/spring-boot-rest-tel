package com.gkfcsolution.springbootdemo.repo;

import com.gkfcsolution.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 2025 at 22:43
 * File: UserRepo.java.java
 * Project: spring-sec-demo
 *
 * @author Frank GUEKENG
 * @date 02/08/2025
 * @time 22:43
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    // Add other query methods as needed
}
