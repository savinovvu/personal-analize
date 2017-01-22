package ru.inbox.savinov_vu.service.constructor.questionVar;

import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;

import java.util.List;

public interface QuestionVarService {
    List<QuestionVar> getQuestionVarWithQuestionKit(Integer id);

    void addQuestionVar(QuestionVar questionVar);

    void deleteQuestionVar(QuestionVar questionVar);
}
