package com.itspace.job.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"users","jobCategories"})
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDateTime publishedOn;
    private int vacancy;
    private EmploymentStatus employmentStatus;
    private String country;
    private int salary;
    private LocalDateTime deadline;
    private String description;
    private String responsibilities;
    private String experience;
    private String other;
    @ManyToOne
    private Company company;
    @ManyToMany(mappedBy = "jobs",cascade={CascadeType.ALL})
    private List<User> users;
    @ManyToMany
    @JoinTable(name = "jobs_categories", joinColumns = @JoinColumn(name = "job-id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<JobCategory> jobCategories;

}
