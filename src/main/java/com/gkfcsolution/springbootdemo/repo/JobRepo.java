package com.gkfcsolution.springbootdemo.repo;

import com.gkfcsolution.springbootdemo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2025 at 11:15
 * File: null.java
 * Project: JobApp
 *
 * @author Frank GUEKENG
 * @date 30/07/2025
 * @time 11:15
 */
@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String postProfile, String postDesc);

}

/*

public void addJob(JobPost jobPost) {
    jobs.add(jobPost);
    System.out.println(jobs);
}

public JobPost getJob(int postId) {
    for (JobPost job : jobs) {
        if (job.getPostId() == postId) {
            return job;
        }
    }
    return null;
}

public JobPost updateJob(int postId, JobPost updatedJobPost) {
    // Logic to update a job post by ID can be implemented here
    // This could involve updating the job post in a database or an in-memory list
    for (JobPost jobPost : jobs){
        if (jobPost.getPostId() == postId) {
            jobPost.setPostProfile(updatedJobPost.getPostProfile());
            jobPost.setPostDesc(updatedJobPost.getPostDesc());
            jobPost.setReqExperience(updatedJobPost.getReqExperience());
            jobPost.setPostTechStack(updatedJobPost.getPostTechStack());
            return jobPost;
        }
    }
    return null;
}

public List<JobPost> getAllJobs() {
    return jobs;
}

public void deleteJob(int postId) {
    jobs.removeIf(job -> job.getPostId() == postId);
}*/
