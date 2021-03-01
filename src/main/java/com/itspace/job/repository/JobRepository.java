package com.itspace.job.repository;

import com.itspace.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long>{

}