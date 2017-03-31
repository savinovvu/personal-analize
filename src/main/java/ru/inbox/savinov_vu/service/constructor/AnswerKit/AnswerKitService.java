package ru.inbox.savinov_vu.service.constructor.AnswerKit;

import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface AnswerKitService extends ParentService<AnswerKit> {

    List<AnswerKit> getAll();

    AnswerKit addAnswerKit(AnswerKit answerKit);

    void deleteAnswerKit(AnswerKit answerKit);

    AnswerKit getById(Integer id);

}
