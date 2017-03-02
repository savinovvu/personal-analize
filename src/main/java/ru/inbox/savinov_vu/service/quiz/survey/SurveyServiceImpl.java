package ru.inbox.savinov_vu.service.quiz.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.repository.quiz.QuestionnaireRepository;
import ru.inbox.savinov_vu.repository.quiz.SurveyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    SurveyRepository repository;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Override
    public List<Survey> getAllSurveys() {
        return repository.findAll().stream()
                .map(survey -> survey.setCount(questionnaireRepository
                        .countQuestionnairesWithSurvey(survey.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Survey getSurveyByID(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Survey addSurvey(Survey survey) {
        return repository.saveAndFlush(survey);
    }

    @Override
    public void deleteSurvey(Survey survey) {
        repository.delete(survey.getId());
    }


}
