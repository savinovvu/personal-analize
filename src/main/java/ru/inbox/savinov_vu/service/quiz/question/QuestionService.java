package ru.inbox.savinov_vu.service.quiz.question;

import ru.inbox.savinov_vu.model.quiz.question.Question;

public interface QuestionService {

    Question findOne(Integer id);

     Question actualizeQuestion(Question question);
}
