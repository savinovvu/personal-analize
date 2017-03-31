package ru.inbox.savinov_vu.service.constructor.quesiontKit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.repository.constructor.QuestionKitRepository;

import java.util.List;

@Service
public class QuestionKitServiceImpl implements QuestionKitService {

    @Autowired
    QuestionKitRepository repository;

    @Override
    public QuestionKit getById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<QuestionKit> getAll() {
        return repository.findAll();
    }

    @Override
    public QuestionKit addQuestionKit(QuestionKit questionKit) {
        return repository.saveAndFlush(questionKit);

    }

    @Override
    public void deleteQuestionKit(QuestionKit questionKit) {
        repository.delete(questionKit.getId());
    }
}
