package ru.inbox.savinov_vu.service.constructor.questionVar;

import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface QuestionVarService extends ParentService<QuestionVar> {

    List<QuestionVar> getAll();

    QuestionVar findById(Integer id);

    List<QuestionVar> getQuestionVarWithQuestionKit(Integer id);

    void addQuestionVar(QuestionVar questionVar);

    void deleteQuestionVar(QuestionVar questionVar);

    List<QuestionVar> getQuestionVarWithSuperQuestionVar(Integer id);
}
