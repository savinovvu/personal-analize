package ru.inbox.savinov_vu.service.quiz.question;

import ru.inbox.savinov_vu.model.quiz.question.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();

    List<Question> getQuestionsWithQuestionnaire(Integer id);


    void addQuestion(Question question);

    void deleteQuestion(Question question);
}
