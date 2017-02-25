package ru.inbox.savinov_vu.service.quiz.answer;

import ru.inbox.savinov_vu.model.quiz.answer.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> getAllAnswers();

    List<Answer> getAnswersWithQuestion(Integer id);

    void addAnswer(Answer answer);

    void deleteAnswer(Answer answer);
}
