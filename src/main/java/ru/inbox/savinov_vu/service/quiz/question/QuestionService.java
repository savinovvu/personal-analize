package ru.inbox.savinov_vu.service.quiz.question;

import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface QuestionService extends ParentService<Question> {
    List<Question> getAll();

    Question findOne(Integer id);

     Question actualizeQuestion(Question question);
}
