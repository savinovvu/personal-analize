package ru.inbox.savinov_vu.service.quiz.questionnaire;

import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;

import java.util.List;

public interface QuestionnaireService {

    List<Questionnaire> getAllQuestionnaires();

    List<Questionnaire> getQuestionnairesWithSurvey(Integer id);

    Questionnaire addQuestionnaire(Questionnaire questionnaire);

    Questionnaire getQuestionnaireById(Integer id);

    void deleteQuestionnaire(Questionnaire questionnaire);

    Long getCountQuestionnairesWithSurvey(Integer id);

}
