package ru.inbox.savinov_vu.service.quiz.question;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.repository.quiz.QuestionRepository;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import java.util.Objects;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository repository;

    @Autowired
    QuestionVarService questionVarService;

    @Override
    public Question findOne(Integer id) {
        return repository.findOne(id);
    }


    @Override
    public Question actualizeQuestion(Question question) {
        Question resultQuestion = getBySurveyIdAndQuestionVarId(question.getSurvey().getId(), question.getQuestionVarId());
        if (Objects.isNull(resultQuestion)) {
            resultQuestion = prepareAndAddQuestion(question);
        }
        return resultQuestion;
    }


    private Question getBySurveyIdAndQuestionVarId(Integer surveyId, Integer questionVarId) {
        return repository.getBySurveyIdAndQuestionVarId(surveyId, questionVarId);
    }

    private Question prepareAndAddQuestion(Question question) {
        QuestionVar questionVar = questionVarService.findById(question.getQuestionVarId());
        question.setNumber(questionVar.getNumber())
                .setName(questionVar.getName());
        if (Objects.nonNull(questionVar.getSuperQuestionVarId())) {
            actualizeSuperQuestion(questionVar, question);
            question.setSuperQuestionId(getBySurveyIdAndQuestionVarId(question.getSurvey().getId(),
                    questionVar.getSuperQuestionVarId()).getId());
        }
        return addQuestion(question);
    }

    private void actualizeSuperQuestion(QuestionVar questionVar, Question subQuestion) {
        Question superQuestion = new Question();
        QuestionVar superQuestionVar = questionVarService.findById(questionVar.getSuperQuestionVarId());
        superQuestion.setName(superQuestionVar.getName())
                .setNumber(superQuestionVar.getNumber())
                .setSurvey(subQuestion.getSurvey())
                .setQuestionVarId(superQuestionVar.getId());
        Question checkQuestion = getBySurveyIdAndQuestionVarId(superQuestion.getSurvey().getId(), superQuestion.getQuestionVarId());
        if (Objects.isNull(checkQuestion)) {
            addQuestion(superQuestion);
        }

    }


    private Question addQuestion(Question question) {
        return repository.saveAndFlush(question);
    }


}
