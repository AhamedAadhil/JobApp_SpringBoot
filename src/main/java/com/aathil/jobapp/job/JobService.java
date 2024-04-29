package com.aathil.jobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobByID(Long id);

    boolean deleteJobByID(Long id);

    boolean updateJobById(Long id, Job job);
}
