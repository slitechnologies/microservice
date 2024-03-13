package com.manaba.jobsmicroservice.job.jobsService;



import com.manaba.jobsmicroservice.job.jobDto.JobCompanyDto;
import com.manaba.jobsmicroservice.job.jobsEntity.Job;

import java.util.List;

public interface JobService {

    List<JobCompanyDto> findAll();

    void createJob(Job job);
    Job getJobById(Long id);
    boolean updateJob(Long id, Job job);
    boolean deleteJobById(Long id);
}
