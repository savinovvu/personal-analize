package ru.inbox.savinov_vu.service.quiz.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.repository.quiz.AnswerRepository;
import ru.inbox.savinov_vu.service.quiz.question.QuestionService;
import ru.inbox.savinov_vu.service.quiz.questionnaire.QuestionnaireService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository repository;

    @Autowired
    QuestionnaireService questionnaireService;


    @Autowired
    QuestionService questionService;


    @Override
    public List<Answer> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Answer> getAnswersWithQuestionnaire(Integer id) {
        return repository.getAnswerWithQuestionnaire(id);
    }

    @Override
    public Answer addAnswer(Answer answer) {
        return repository.saveAndFlush(answer);
    }

    @Override
    public Integer addAnswer(List<Answer> answers) {
        Questionnaire questionnaire = questionnaireService.addQuestionnaire(answers.get(0).getQuestionnaire());
        Survey survey = questionnaire.getSurvey();
        for (Answer answer : answers) {
            answer.setQuestionnaire(questionnaire)
                    .setQuestion(questionService.actualizeQuestion(answer.getQuestion().setSurvey(survey)));
            addAnswer(answer);
        }
        return questionnaire.getNumber();
    }


    @Override
    public void deleteAnswer(Answer answer) {
        repository.delete(answer.getId());
    }
}
