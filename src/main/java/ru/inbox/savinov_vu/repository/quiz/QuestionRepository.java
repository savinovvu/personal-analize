package ru.inbox.savinov_vu.repository.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.quiz.question.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>{
    @Query("SELECT p FROM Question p WHERE p.survey.id=:survey_id AND p.questionVarId=:questionVar_id")
    Question getBySurveyIdAndQuestionVarId(@Param("survey_id") Integer surveyId,
                                                 @Param("questionVar_id") Integer questionVarId);



}
