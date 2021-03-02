package com.itspace.job.repository;

import com.itspace.job.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     User findByEmail(String email);

}
