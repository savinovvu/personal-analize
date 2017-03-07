package ru.inbox.savinov_vu.service.quiz.questionnaire;

import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;

import java.util.List;

public interface QuestionnaireService {

    List<Questionnaire> getAllQuestionnaires();

    List<Questionnaire> getQuestionnairesWithSurvey(Integer id);

    Questionnaire addQuestionnaire(Questionnaire questionnaire);

    void deleteQuestionnaire(Questionnaire questionnaire);

    Long countQuestionnairesWithSurvey(Integer id);

}
