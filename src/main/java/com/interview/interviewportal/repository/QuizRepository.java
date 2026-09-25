package com.interview.interviewportal.repository;

import com.interview.interviewportal.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Integer>
{
}