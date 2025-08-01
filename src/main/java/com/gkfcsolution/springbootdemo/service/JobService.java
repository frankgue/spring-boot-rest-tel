package com.gkfcsolution.springbootdemo.service;

import com.gkfcsolution.springbootdemo.model.JobPost;
import com.gkfcsolution.springbootdemo.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2025 at 11:07
 * File: null.java
 * Project: JobApp
 *
 * @author Frank GUEKENG
 * @date 30/07/2025
 * @time 11:07
 */
@Service
public class JobService {

    private JobRepo jobRepo;

    @Autowired
    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public void addJob(JobPost jobPost) {
        // Logic to add a job post can be implemented here
        // This could involve saving the job post to a database or processing it further
        jobRepo.save(jobPost);
    }
    public List<JobPost> getAllJobs() {
        // Logic to retrieve all job posts can be implemented here
        // This could involve fetching job posts from a database or an in-memory list
        return jobRepo.findAll();
    }

    public JobPost getJob(int jobId) {
        return jobRepo.findById(jobId).orElse(null);
    }



    public JobPost updateJob( JobPost jobPost) {
        // Logic to update a job post by ID can be implemented here
        // This could involve updating the job post in a database or an in-memory list
        return jobRepo.save(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepo.deleteById(postId);
    }

    public void loadInitialJobs() {

        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Software Engineer", "Develop and maintain software applications", 3, List.of("Java", "Spring Boot")),
                new JobPost(2, "Data Scientist", "Analyze data and build predictive models", 5, List.of("Python", "Machine Learning")),
                new JobPost(3, "DevOps Engineer", "Manage infrastructure and deployment pipelines", 4, List.of("Docker", "Kubernetes")),
                new JobPost(4, "UI/UX Designer", "Design user interfaces and improve user experience", 2, List.of("Figma", "Adobe XD")),
                new JobPost(5, "Project Manager", "Oversee project execution and team coordination", 6, List.of("Agile", "Scrum"))
        ));
        // Save the initial jobs to the repository
        jobRepo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(keyword, keyword);
    }
}
