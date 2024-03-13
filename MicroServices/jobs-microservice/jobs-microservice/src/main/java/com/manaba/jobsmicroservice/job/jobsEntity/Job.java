package com.manaba.jobsmicroservice.job.jobsEntity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String jobTitle;
    private String jobDescription;
    private String minSalary;
    private String maxSalary;
    private String jobLocation;
    private Long companyId;
}
