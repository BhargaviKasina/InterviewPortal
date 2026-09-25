package com.interview.interviewportal.service;

import com.interview.interviewportal.dto.QuizResponse;
import com.interview.interviewportal.dto.QuizSubmission;
import com.interview.interviewportal.entity.Question;
import com.interview.interviewportal.entity.Quiz;
import com.interview.interviewportal.repository.QuestionRepository;
import com.interview.interviewportal.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Integer id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz addQuestionToQuiz(Integer quizId, Long questionId) {

        Quiz quiz = quizRepository.findById(quizId).orElse(null);
        Question question = questionRepository.findById(questionId).orElse(null);

        if (quiz != null && question != null) {
            quiz.getQuestions().add(question);
            return quizRepository.save(quiz);
        }

        return null;
    }

    public QuizResponse submitQuiz(Integer quizId, QuizSubmission submission) {

        Quiz quiz = quizRepository.findById(quizId).orElse(null);

        if (quiz == null) {
            QuizResponse response = new QuizResponse();
            response.setScore(0);
            response.setTotalQuestions(0);
            return response;
        }

        int score = 0;

        for (Question question : quiz.getQuestions()) {

            String userAnswer =
                    submission.getAnswers().get(question.getId());

            if (userAnswer != null &&
                    userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                score++;
            }
        }

        QuizResponse response = new QuizResponse();
        response.setScore(score);
        response.setTotalQuestions(quiz.getQuestions().size());

        return response;

    }
        public String deleteQuiz(Integer id) {
            quizRepository.deleteById(id);
            return "Quiz Deleted Successfully";

    }
}