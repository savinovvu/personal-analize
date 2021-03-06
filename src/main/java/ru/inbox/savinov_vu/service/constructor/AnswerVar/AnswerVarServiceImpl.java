package ru.inbox.savinov_vu.service.constructor.AnswerVar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerVar;
import ru.inbox.savinov_vu.repository.constructor.AnswerVarRepository;

import java.util.List;

@Service
public class AnswerVarServiceImpl implements AnswerVarService {

    @Autowired
    AnswerVarRepository repository;

    @Override
    public List<AnswerVar> getAll() {
        return repository.findAll();
    }

    @Override
    public List<AnswerVar> getAnswerVarWithAnswerKit(Integer id) {
        return repository.getAnswerVarWithAnswerKit(id);
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
