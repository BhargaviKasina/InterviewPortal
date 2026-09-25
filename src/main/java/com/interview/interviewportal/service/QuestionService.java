package com.interview.interviewportal.service;

import com.interview.interviewportal.entity.Question;
import com.interview.interviewportal.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

        public String deleteQuestion(Long id) {
            questionRepository.deleteById(id);
            return "Question Deleted Successfully";
    }

    public Question updateQuestion(Long id, Question updatedQuestion) {

        Question question = questionRepository.findById(id).orElse(null);

        if (question != null) {
            question.setQuestionText(updatedQuestion.getQuestionText());
            question.setOptionA(updatedQuestion.getOptionA());
            question.setOptionB(updatedQuestion.getOptionB());
            question.setOptionC(updatedQuestion.getOptionC());
            question.setOptionD(updatedQuestion.getOptionD());
            question.setCorrectAnswer(updatedQuestion.getCorrectAnswer());
            question.setCategory(updatedQuestion.getCategory());
            question.setDifficulty(updatedQuestion.getDifficulty());

            return questionRepository.save(question);
        }

        return null;
    }
}