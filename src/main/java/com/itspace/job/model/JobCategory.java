package com.itspace.job.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "jobs")
public class JobCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "jobCategories",cascade={CascadeType.ALL})
    private List<Job> jobs;
}
