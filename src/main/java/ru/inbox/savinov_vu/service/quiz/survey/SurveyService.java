package ru.inbox.savinov_vu.service.quiz.survey;

import ru.inbox.savinov_vu.model.quiz.survey.Survey;

import java.util.List;

public interface SurveyService {

    List<Survey> getAllSurveys();

    Survey getSurveyById(Integer id);

    Survey addSurvey(Survey survey);

    void deleteSurvey(Survey survey);

    Integer getCountofQuestionnaire(Integer id);

}
