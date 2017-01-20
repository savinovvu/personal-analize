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
    public List<QuestionKit> getAllQuestionKits() {
        return repository.findAll();
    }

    @Override
    public void addQuestionKit(QuestionKit questionKit) {
        repository.saveAndFlush(questionKit);
    }

    @Override
    public void deleteQuestionKit(QuestionKit questionKit) {
        repository.delete(questionKit);
    }
}
