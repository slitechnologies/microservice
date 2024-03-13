package com.manaba.jobsmicroservice.job.jobDto;

import com.manaba.jobsmicroservice.job.external.Company;
import com.manaba.jobsmicroservice.job.jobsEntity.Job;

public class JobCompanyDto {
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    private Company company;
}
