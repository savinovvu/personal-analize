package ru.inbox.savinov_vu.repository.constructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.constructor.question.QuestionSub;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;

import java.util.List;

@Repository
public interface QuestionSubRepository extends JpaRepository<QuestionSub, Integer> {

    @Query("SELECT p FROM QuestionSub p WHERE p.questionVar.id=:questionVar_id")
    List<QuestionSub> getQuestionSubWithQuestionVar(@Param("questionVar_id") Integer id);

}
