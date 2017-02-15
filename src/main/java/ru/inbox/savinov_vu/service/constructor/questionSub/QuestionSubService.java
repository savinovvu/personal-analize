package ru.inbox.savinov_vu.service.constructor.questionSub;

import ru.inbox.savinov_vu.model.constructor.question.QuestionSub;

import java.util.List;

public interface QuestionSubService {
    List<QuestionSub> getQuestionSubWithQuestionVar(Integer id);

    void addQuestionSub(QuestionSub questionSub);

    void deleteQuestionSub(QuestionSub questionSub);
}
