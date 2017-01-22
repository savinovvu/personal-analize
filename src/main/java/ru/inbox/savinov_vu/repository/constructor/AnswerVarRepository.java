package ru.inbox.savinov_vu.repository.constructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerVar;
import ru.inbox.savinov_vu.model.personal.Group;

import java.util.List;

@Repository
public interface AnswerVarRepository extends JpaRepository<AnswerVar, Integer> {

    @Query("SELECT p FROM AnswerVar p WHERE p.answerKit.id=:answerKit_id")
    List<AnswerVar> getAnswerVarWithAnswerKit(@Param("answerKit_id") Integer id);


}
