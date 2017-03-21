package ru.inbox.savinov_vu.controller.pdf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.service.quiz.answer.AnswerService;
import ru.inbox.savinov_vu.service.quiz.questionnaire.QuestionnaireService;
import ru.inbox.savinov_vu.service.quiz.survey.SurveyService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Controller
@Slf4j
public class SurveyPdfController {

    @Autowired
    SurveyService surveyService;

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    AnswerService answerService;

    @GetMapping(value = "pdf/quiz/survey/{id}")
    public void editOrder(Model model, @PathVariable("id") int id) {
        model.addAttribute("survey", surveyService.getSurveyById(id));
        List<Questionnaire> questionnairesWithSurvey = questionnaireService.getQuestionnairesWithSurvey(id);
        model.addAttribute("countQuestionnaires", questionnairesWithSurvey.size());
        model.addAttribute("countAnswerByQuestionMap", getCountAnswerByQuestion(questionnairesWithSurvey));

    }

    private Map<Question, Map<Answer, Long>> getCountAnswerByQuestion(List<Questionnaire>
                                                                              questionnairesWithSurvey) {
        return questionnairesWithSurvey.stream()
                .map(questionnaire -> answerService.getAnswersWithQuestionnaire(questionnaire.getId()))
                .flatMap(List::stream)
                .collect(Collectors.
                        groupingBy(Answer::getQuestion, LinkedHashMap::new,
                                Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())));
    }

}
