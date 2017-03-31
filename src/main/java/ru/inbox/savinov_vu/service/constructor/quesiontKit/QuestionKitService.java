package ru.inbox.savinov_vu.service.constructor.quesiontKit;

import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface QuestionKitService extends ParentService<QuestionKit> {

    List<QuestionKit> getAll();

    QuestionKit getById( Integer id);

    QuestionKit addQuestionKit(QuestionKit questionKit);

    void deleteQuestionKit(QuestionKit questionKit);
}
