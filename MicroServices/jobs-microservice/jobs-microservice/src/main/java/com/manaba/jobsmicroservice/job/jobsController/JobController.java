package com.manaba.jobsmicroservice.job.jobsController;


import com.manaba.jobsmicroservice.job.jobDto.JobCompanyDto;
import com.manaba.jobsmicroservice.job.jobsEntity.Job;
import com.manaba.jobsmicroservice.job.jobsService.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobCompanyDto>> findAll() {

        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJobs(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if (isDeleted)
            return new ResponseEntity<>("Job Successfully Deleted", HttpStatus.OK);
        return new ResponseEntity<>("Job Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Long id) {
        Job job = jobService.getJobById(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable("id") Long id, @RequestBody Job job){
        boolean isUpdated = jobService.updateJob(id, job);
        if(isUpdated)
            return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
        return new ResponseEntity<>("Job Not Found", HttpStatus.NOT_FOUND);

    }
}
