package com.itspace.job.repository;

import com.itspace.job.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
   public UserRole findByName(String name);
}
