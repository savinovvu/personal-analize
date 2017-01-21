package ru.inbox.savinov_vu.service.constructor.AnswerKit;

import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;

import java.util.List;

public interface AnswerKitService {

    List<AnswerKit> getAllAnswerKits();

    void addAnswerKit(AnswerKit answerKit);

    void deleteAnswerKit(AnswerKit answerKit);

}
