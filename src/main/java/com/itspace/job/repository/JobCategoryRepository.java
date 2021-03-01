package com.itspace.job.repository;

import com.itspace.job.model.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobCategoryRepository extends JpaRepository<JobCategory,Long> {
}
