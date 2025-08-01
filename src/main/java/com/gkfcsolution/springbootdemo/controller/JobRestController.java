package com.gkfcsolution.springbootdemo.controller;

import com.gkfcsolution.springbootdemo.model.JobPost;
import com.gkfcsolution.springbootdemo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2025 at 20:33
 * File: null.java
 * Project: spring-boot-demo
 *
 * @author Frank GUEKENG
 * @date 30/07/2025
 * @time 20:33
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from the React frontend
public class JobRestController {
    @Autowired
    private JobService jobService;

    // Example method to handle a GET request for all job posts
    @GetMapping(value = "/jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return jobService.getJob(postId);
    }

    @GetMapping("/jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        // Logic to search job posts by keyword can be implemented here
        // This could involve searching in a database or filtering an in-memory list
        return jobService.search(keyword);
    }

    // Example method to handle a POST request to add a new job post
    @PostMapping(value = "/jobPost", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Void> addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId) {
        jobService.deleteJob(postId);
        return "Job post with ID " + postId + " has been deleted successfully.";
    }

    // Load initial job posts
    @GetMapping("/load")
    public String loadInitialJobs() {
        jobService.loadInitialJobs(); // This will load the initial jobs if they are not already loaded
        return "Initial job posts loaded successfully.";
    }
}
