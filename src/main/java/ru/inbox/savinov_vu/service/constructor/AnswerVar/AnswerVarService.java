package ru.inbox.savinov_vu.service.constructor.AnswerVar;

import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerVar;

import java.util.List;

public interface AnswerVarService {

    List<AnswerVar> getAnswerVarWithAnswerKit(AnswerKit answerKit);

    void addAnswerVar(AnswerVar answerVar);

    void deleteAnswerVar(AnswerVar answerVar);
}
