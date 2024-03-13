package com.manaba.jobsmicroservice.job.JobsRepository;


import com.manaba.jobsmicroservice.job.jobsEntity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
