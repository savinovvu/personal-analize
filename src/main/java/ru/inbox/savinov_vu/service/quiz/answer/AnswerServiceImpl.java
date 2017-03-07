package ru.inbox.savinov_vu.service.quiz.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.repository.quiz.AnswerRepository;
import ru.inbox.savinov_vu.service.quiz.questionnaire.QuestionnaireService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository repository;

    @Autowired
    QuestionnaireService questionnaireService;

    @Override
    public List<Answer> getAllAnswers() {
        return repository.findAll();
    }

    @Override
    public List<Answer> getAnswersWithQuestionnaire(Integer id) {
        return repository.getAnswerWithQuestionnaire(id);
    }

    @Override
    public void addAnswer(Answer answer) {
        repository.saveAndFlush(answer);
    }

    @Override
    public Integer addAnswer(List<Answer> answers) {
        Questionnaire questionnaire = questionnaireService.addQuestionnaire(answers.get(0).getQuestionnaire());
       /* answers.forEach(answer -> {
            answer.setQuestionnaire(questionnaire);
            repository.saveAndFlush(answer);
        });*/
        System.out.println("начало");
        for (Answer answer : answers) {
            answer.setQuestionnaire(questionnaire);

            System.out.println(answer.getQuestionVar().getId());
            addAnswer(answer);
        }
        return questionnaire.getNumber();
    }

    @Override
    public void deleteAnswer(Answer answer) {
        repository.delete(answer.getId());
    }
}
