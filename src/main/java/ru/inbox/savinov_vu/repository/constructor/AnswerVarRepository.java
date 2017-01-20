package ru.inbox.savinov_vu.repository.constructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerVar;

@Repository
public interface AnswerVarRepository extends JpaRepository<AnswerVar, Integer> {
}
