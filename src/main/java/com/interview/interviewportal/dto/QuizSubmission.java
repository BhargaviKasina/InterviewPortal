package com.interview.interviewportal.dto;

import lombok.Data;
import java.util.Map;

@Data
public class QuizSubmission {

    private Map<Long, String> answers;
}