package ru.inbox.savinov_vu.service.quiz.questionnaire;

import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.service.ParentService;

import java.util.List;

public interface QuestionnaireService extends ParentService<Questionnaire> {

    List<Questionnaire> getAll();

    List<Questionnaire> getQuestionnairesWithSurvey(Integer id);

    Questionnaire addQuestionnaire(Questionnaire questionnaire);

    Questionnaire getQuestionnaireById(Integer id);

    void deleteQuestionnaire(Questionnaire questionnaire);

    Long getCountQuestionnairesWithSurvey(Integer id);

}
