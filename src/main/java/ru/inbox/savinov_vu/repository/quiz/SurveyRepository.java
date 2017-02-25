package ru.inbox.savinov_vu.repository.quiz;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,Integer> {
}
