package ru.inbox.savinov_vu.service.quiz.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.repository.quiz.AnswerRepository;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository repository;

    @Override
    public List<Answer> getAllAnswers() {
        return repository.findAll();
    }

    @Override
    public List<Answer> getAnswersWithQuestion(Integer id) {
        return repository.getAnswerWithQuestion(id);
    }

    @Override
    public void addAnswer(Answer answer) {
        repository.saveAndFlush(answer);
    }

    @Override
    public void deleteAnswer(Answer answer) {
        repository.delete(answer.getId());
    }
}
