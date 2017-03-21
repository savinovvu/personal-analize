package ru.inbox.savinov_vu.service.quiz.questionnaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.repository.quiz.QuestionnaireRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    QuestionnaireRepository repository;


    @Override
    public List<Questionnaire> getAllQuestionnaires() {
        return repository.findAll();
    }

    @Override
    public List<Questionnaire> getQuestionnairesWithSurvey(Integer id) {
        return repository.getQuestionnaireWithSurvey(id);
    }

    @Override
    public Long getCountQuestionnairesWithSurvey(Integer id) {
        return repository.countQuestionnairesWithSurvey(id);
    }

    @Override
    public Questionnaire addQuestionnaire(Questionnaire questionnaire) {
        if (questionnaire.getNumber() == null || questionnaire.getNumber() < 1) {
            getNumberOfQuestionnaire(questionnaire);
        }
        if (questionnaire.getDate() == null) {
            questionnaire.setDate(LocalDate.now());
        }

        return repository.saveAndFlush(questionnaire);
    }

    private void getNumberOfQuestionnaire(Questionnaire questionnaire) {
        questionnaire.setNumber((int) (getCountQuestionnairesWithSurvey(questionnaire.getSurvey().getId()) + 1));
    }

    @Override
    public void deleteQuestionnaire(Questionnaire questionnaire) {
        List<Questionnaire> questionnaires = repository.getQuestionnairesWithSurveyAndIdMoreThat(questionnaire.getSurvey().getId(), questionnaire.getId());
        repository.delete(questionnaire.getId());
        questionnaires.stream().map(questionnaire1 -> questionnaire1.setNumber(questionnaire1.getNumber()-1))
                .forEach(questionnaire1-> repository.saveAndFlush(questionnaire1));
    }


}
