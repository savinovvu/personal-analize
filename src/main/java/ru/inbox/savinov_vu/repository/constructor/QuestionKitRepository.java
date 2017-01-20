package ru.inbox.savinov_vu.repository.constructor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;

@Repository
public interface QuestionKitRepository extends JpaRepository<QuestionKit, Integer> {
}
