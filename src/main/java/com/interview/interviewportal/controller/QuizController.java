package com.interview.interviewportal.controller;

import com.interview.interviewportal.dto.QuizResponse;
import com.interview.interviewportal.dto.QuizSubmission;
import com.interview.interviewportal.entity.Quiz;
import com.interview.interviewportal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/all")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Integer id) {
        return quizService.getQuizById(id);
    }

    @PostMapping("/{quizId}/question/{questionId}")
    public Quiz addQuestionToQuiz(@PathVariable Integer quizId,
                                  @PathVariable Long questionId) {
        return quizService.addQuestionToQuiz(quizId, questionId);
    }

    @PostMapping("/{quizId}/submit")
    public QuizResponse submitQuiz(
            @PathVariable Integer quizId,
            @RequestBody QuizSubmission submission) {

        return quizService.submitQuiz(quizId, submission);

    }
        @DeleteMapping("/{id}")
        public String deleteQuiz(@PathVariable Integer id) {
            return quizService.deleteQuiz(id);
    }
}