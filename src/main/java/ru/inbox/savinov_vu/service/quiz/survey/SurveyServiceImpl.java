package ru.inbox.savinov_vu.service.quiz.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.repository.quiz.QuestionnaireRepository;
import ru.inbox.savinov_vu.repository.quiz.SurveyRepository;

import java.util.List;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    SurveyRepository repository;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Override
    public List<Survey> getAllSurveys() {
        return getQuestionnaireCountOfSurvey(repository.findAll());

    }

    @Override
    public void addSurvey(Survey survey) {
        repository.saveAndFlush(survey);
    }

    @Override
    public void deleteSurvey(Survey survey) {
        repository.delete(survey.getId());
    }


    private List<Survey> getQuestionnaireCountOfSurvey(List<Survey> surveys) {
        surveys.forEach(survey -> {
          survey.setCount(questionnaireRepository.countQuestionnairesWithSurvey(survey.getId()));
        });
        return surveys;
    }

}
