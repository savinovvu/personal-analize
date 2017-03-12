package ru.inbox.savinov_vu.repository.constructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;

import java.util.List;

@Repository
public interface QuestionVarRepository extends JpaRepository<QuestionVar, Integer> {

    @Query("SELECT p FROM QuestionVar p WHERE p.questionKit.id=:questionKit_id AND p.superQuestionVarId=NULL")
    List<QuestionVar> getQuestionVarWithQuestionKit(@Param("questionKit_id") Integer id);

    @Query("SELECT count(p) FROM QuestionVar p WHERE p.questionKit.id=:questionKit_id AND p.superQuestionVarId=NULL")
    Long getCountQuestionVarWithQuestionKit(@Param("questionKit_id") Integer questionKit_id);

    @Query("SELECT p FROM QuestionVar p WHERE p.superQuestionVarId=:superQuestionVarId")
    List<QuestionVar> getQuestionVarWithSuperQuestionVar(@Param("superQuestionVarId") Integer superQuestionVarId);

    @Query("SELECT count(p) FROM QuestionVar p WHERE p.superQuestionVarId=:superQuestionVarId")
    Long getCountQuestionVarWithSuperQuestionVar(@Param("superQuestionVarId") Integer superQuestionVarId);

    @Query("Select p FROM QuestionVar p WHERE p.id >:id AND p.superQuestionVarId=NULL AND p.questionKit.id=:questionKit_id")
    List<QuestionVar> getListWithIdMoreThatWithQuestionKit(@Param("id") Integer id, @Param("questionKit_id") Integer questionKit_id);

    @Query("Select p FROM QuestionVar p WHERE p.id >:id AND p.superQuestionVarId=:superQuestionVarId")
    List<QuestionVar> getListWithIdMoreThatWithQuestionVar(@Param("id") Integer id, @Param("superQuestionVarId") Integer superQuestionVarId);


}


