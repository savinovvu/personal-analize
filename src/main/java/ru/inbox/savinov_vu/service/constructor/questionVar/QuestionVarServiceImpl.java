package ru.inbox.savinov_vu.service.constructor.questionVar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.repository.constructor.QuestionVarRepository;

import java.util.List;

@Service
public class QuestionVarServiceImpl implements QuestionVarService {
    @Autowired
    QuestionVarRepository repository;

    @Override
    public QuestionVar findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<QuestionVar> getQuestionVarWithQuestionKit(Integer id) {
        return repository.getQuestionVarWithQuestionKit(id);
    }

    @Override
    public void addQuestionVar(QuestionVar questionVar) {
        repository.saveAndFlush(questionVar);
    }

    @Override
    public void deleteQuestionVar(QuestionVar questionVar) {
        repository.delete(questionVar.getId());
    }

    @Override
    public List<QuestionVar> getQuestionVarWithSuperQuestionVar(Integer id) {
        return repository.getQuestionVarWithSuperQuestionVar(id);
    }
}
