package ru.inbox.savinov_vu.service.constructor.AnswerVar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerVar;
import ru.inbox.savinov_vu.repository.constructor.AnswerVarRepository;

import java.util.List;

@Service
public class AnswerVarServiceImpl implements AnswerVarService {

    @Autowired
    AnswerVarRepository repository;

    @Override
    public List<AnswerVar> getAnswerVarWithAnswerKit(AnswerKit answerKit) {
        return repository.getAnswerVarWithAnswerKit(answerKit.getId());
    }

    @Override
    public void addAnswerVar(AnswerVar answerVar) {
        repository.saveAndFlush(answerVar);
    }

    @Override
    public void deleteAnswerVar(AnswerVar answerVar) {
    repository.delete(answerVar.getId());
    }
}
