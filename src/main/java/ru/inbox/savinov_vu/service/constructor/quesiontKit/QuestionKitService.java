package ru.inbox.savinov_vu.service.constructor.quesiontKit;

import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;

import java.util.List;

public interface QuestionKitService {

    List<QuestionKit> getAllQuestionKits();

    void addQuestionKit(QuestionKit questionKit);

    void deleteQuestionKit(QuestionKit questionKit);
}
