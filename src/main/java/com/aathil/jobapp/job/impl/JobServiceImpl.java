package com.aathil.jobapp.job.impl;

import com.aathil.jobapp.job.Job;
import com.aathil.jobapp.job.JobRepository;
import com.aathil.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }


    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobByID(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobByID(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updateJobById(Long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job jb = jobOptional.get();
            jb.setTitle(job.getTitle());
            jb.setDescription(job.getDescription());
            jb.setMinSalary(job.getMinSalary());
            jb.setMaxSalary(job.getMaxSalary());
            jb.setLocation(job.getLocation());
            jobRepository.save(jb);
            return true;

        }
        return false;
    }

}
