package com.itspace.job.repository;

import com.itspace.job.model.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCommentRepository extends JpaRepository<BlogComment,Long> {

}
