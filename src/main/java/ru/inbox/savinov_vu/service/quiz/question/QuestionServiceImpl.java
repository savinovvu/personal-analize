package ru.inbox.savinov_vu.service.quiz.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.repository.quiz.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository repository;

    @Override
    public List<Question> getAllQuestions() {
        return repository.findAll();
    }

    @Override
    public List<Question> getQuestionsWithQuestionnaire(Integer id) {
        return repository.getQuestionWithQuestionnaire(id);
    }

    @Override
    public void addQuestion(Question question) {

    }

    @Override
    public void deleteQuestion(Question question) {

    }
}
