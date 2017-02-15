package ru.inbox.savinov_vu.service.constructor.questionSub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.constructor.question.QuestionSub;
import ru.inbox.savinov_vu.repository.constructor.QuestionSubRepository;

import java.util.List;

@Service
public class QuestionSubServiceImpl implements QuestionSubService {
    @Autowired
    QuestionSubRepository repository;


    @Override
    public List<QuestionSub> getQuestionSubWithQuestionVar(Integer id) {
        return repository.getQuestionSubWithQuestionVar(id);
    }

    @Override
    public void addQuestionSub(QuestionSub questionSub) {
        repository.saveAndFlush(questionSub);
    }

    @Override
    public void deleteQuestionSub(QuestionSub questionSub) {
        repository.delete(questionSub.getId());
    }
}
