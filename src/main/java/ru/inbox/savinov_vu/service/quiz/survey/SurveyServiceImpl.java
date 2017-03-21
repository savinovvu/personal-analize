package ru.inbox.savinov_vu.service.quiz.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.repository.quiz.SurveyRepository;
import ru.inbox.savinov_vu.service.quiz.questionnaire.QuestionnaireService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    SurveyRepository repository;

    @Autowired
    QuestionnaireService questionnaireService;

    @Override
    public List<Survey> getAllSurveys() {
        return repository.findAll().stream()
                .map(survey -> survey.setCount(questionnaireService
                        .getCountQuestionnairesWithSurvey(survey.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Survey getSurveyById(Integer id) {
        return repository.findOne(id).setCount(questionnaireService
                .getCountQuestionnairesWithSurvey(id));
    }

    @Override
    public Survey addSurvey(Survey survey) {
        survey = repository.saveAndFlush(survey);
        return survey.setCount(questionnaireService
                .getCountQuestionnairesWithSurvey(survey.getId()));
    }

    @Override
    public Integer getCountofQuestionnaire(Integer id) {
        return null;
    }

    @Override
    public void deleteSurvey(Survey survey) {
        repository.delete(survey.getId());
    }


}
