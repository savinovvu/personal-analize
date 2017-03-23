package ru.inbox.savinov_vu.service.quiz.survey;

import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface SurveyService extends ParentService<Survey> {

    List<Survey> getAll();

    Survey getSurveyById(Integer id);

    Survey addSurvey(Survey survey);

    void deleteSurvey(Survey survey);

    Integer getCountofQuestionnaire(Integer id);

}
