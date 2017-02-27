package ru.inbox.savinov_vu.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;

import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire,Integer> {

    @Query("SELECT p FROM Questionnaire p WHERE p.survey.id=:survey_id")
    List<Questionnaire> getQuestionnaireWithSurvey(@Param("survey_id") Integer id);

    @Query("SELECT count(p) FROM Questionnaire p WHERE p.survey.id=:survey_id")
    Long countQuestionnairesWithSurvey(@Param("survey_id") Integer id);

}
