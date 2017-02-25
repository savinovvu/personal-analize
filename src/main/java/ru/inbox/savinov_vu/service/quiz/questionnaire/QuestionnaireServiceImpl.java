package ru.inbox.savinov_vu.service.quiz.questionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.repository.quiz.QuestionnaireRepository;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    QuestionnaireRepository repository;

    @Override
    public List<Questionnaire> getAllQuestionnaires() {
        return repository.findAll();
    }

    @Override
    public List<Questionnaire> getQuestionnairesWithSurvey(Integer id) {
        return repository.getQuestionnaireWithSurvey(id);
    }

    @Override
    public void addQuestionnaire(Questionnaire questionnaire) {
        repository.saveAndFlush(questionnaire);
    }

    @Override
    public void deleteQuestionnaire(Questionnaire questionnaire) {
        repository.delete(questionnaire.getId());
    }
}
