package com.gkfcsolution.springbootdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created on 2025 at 22:43
 * File: null.java
 * Project: spring-sec-demo
 *
 * @author Frank GUEKENG
 * @date 02/08/2025
 * @time 22:43
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users") // Specify the table name if different from the class name
public class User {
    @Id
    private int id;
    private String username;
    private String password;
//    private String role;
//    private boolean enabled;
//    private String email;
//    private String phoneNumber;
}
