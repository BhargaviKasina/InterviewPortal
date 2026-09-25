package com.interview.interviewportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.interview.interviewportal.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}