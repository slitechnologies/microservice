package com.manaba.jobsmicroservice.job.jobsService.jobsServiceImpl;

;
import com.manaba.jobsmicroservice.job.JobsRepository.JobRepository;
import com.manaba.jobsmicroservice.job.external.Company;
import com.manaba.jobsmicroservice.job.jobDto.JobCompanyDto;
import com.manaba.jobsmicroservice.job.jobsEntity.Job;
import com.manaba.jobsmicroservice.job.jobsService.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
private JobCompanyDto toJobCompanyDto(Job job){
    JobCompanyDto jobCompanyDto = new JobCompanyDto();
    jobCompanyDto.setJob(job);
    RestTemplate restTemplate = new RestTemplate();
    Company company = restTemplate.getForObject(
            "http://localhost:8085/mana-jobs/api/v1/companies/"+job.getCompanyId(),
            Company.class);
    jobCompanyDto.setCompany(company);
    return jobCompanyDto;
}
    @Override
    public List<JobCompanyDto> findAll() {
        List<Job> jobs = jobRepository.findAll();

        return jobs.stream().map(this::toJobCompanyDto).collect(Collectors.toList());
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id)
                .orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setJobTitle(updatedJob.getJobTitle());
            job.setJobDescription(updatedJob.getJobDescription());
            job.setMaxSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setJobLocation(updatedJob.getJobLocation());
            jobRepository.save(job);
            return true;
        }

        return false;
    }
}
