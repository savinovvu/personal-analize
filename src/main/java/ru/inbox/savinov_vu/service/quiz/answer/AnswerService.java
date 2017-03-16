package ru.inbox.savinov_vu.service.quiz.answer;

import ru.inbox.savinov_vu.model.quiz.answer.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> getAllAnswers();

    List<Answer> getAnswersWithQuestionnaire(Integer id);

    Answer addAnswer(Answer answer);

    Integer addAnswer(List<Answer> answer);

    void deleteAnswer(Answer answer);
}
