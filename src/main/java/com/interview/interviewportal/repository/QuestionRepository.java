package com.interview.interviewportal.repository;

import com.interview.interviewportal.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
