package ru.inbox.savinov_vu.service.constructor.questionVar;

import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;

import java.util.List;

public interface QuestionVarService {
    QuestionVar findById(Integer id);

    List<QuestionVar> getQuestionVarWithQuestionKit(Integer id);

    void addQuestionVar(QuestionVar questionVar);

    void deleteQuestionVar(QuestionVar questionVar);
}
