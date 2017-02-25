package ru.inbox.savinov_vu.service.quiz.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.repository.quiz.SurveyRepository;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    SurveyRepository repository;

    @Override
    public List<Survey> getAllSurveys() {
        return repository.findAll();
    }

    @Override
    public void addSurvey(Survey survey) {
        repository.saveAndFlush(survey);
    }

    @Override
    public void deleteSurvey(Survey survey) {
        repository.delete(survey.getId());
    }
}
