package ru.inbox.savinov_vu.service.constructor.AnswerKit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;
import ru.inbox.savinov_vu.repository.constructor.AnswerKitRepository;

import java.util.List;

@Service
public class AnswerKitServiceImpl implements AnswerKitService {
    @Autowired
    AnswerKitRepository repository;

    @Override
    public List<AnswerKit> getAll() {
        return repository.findAll();
    }


    @Override
    public void addAnswerKit(AnswerKit answerKit) {
        repository.saveAndFlush(answerKit);

    }

    @Override
    public void deleteAnswerKit(AnswerKit answerKit) {
        repository.delete(answerKit.getId());
    }


}
