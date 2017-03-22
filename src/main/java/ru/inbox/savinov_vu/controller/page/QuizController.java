package ru.inbox.savinov_vu.controller.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.service.constructor.quesiontKit.QuestionKitService;
import ru.inbox.savinov_vu.service.quiz.survey.SurveyService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Controller
@Slf4j
public class QuizController {
    @Autowired
    SurveyService surveyService;
    @Autowired
    QuestionKitService questionKitService;

    @GetMapping("conductSurvey")
    public String start() {
        log.debug("\nget quiz page");
        return "quiz/survey/survey";
    }

    @GetMapping("answerAndQuestion")
    public String getAnswersAndQuestions(HttpServletRequest request, Model model) {
        int id = getSurveyId(request);
        Survey survey = surveyService.getSurveyById(id);
        model.addAttribute("surveyId", id);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        model.addAttribute("surveyName", survey.getName());
        model.addAttribute("surveyDate", dtf.format(survey.getDate()));
        return "quiz/questionnaire/answersAndQuestions";
    }

    @GetMapping("questionnaire")
    public String getQuestionnaire(HttpServletRequest request, Model model) {
        int id = getSurveyId(request);
        Survey survey = surveyService.getSurveyById(id);
        model.addAttribute("surveyId", id);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        model.addAttribute("surveyName", survey.getName());
        model.addAttribute("surveyDate", dtf.format(survey.getDate()));
        return "quiz/questionnaire/questionnaire";
    }


    @GetMapping("newQuiz")
    public String beginNewSurvey(HttpServletRequest request) {
        log.debug("\nget beginSurveyPage");

        Survey survey = new Survey();
        QuestionKit questionKit = getSurveyQuestionKit(request);
        survey.setId(getSurveyId(request))
                .setName(questionKit.getName())
                .setDate(getSurveyDate(request))
                .setDepartment(getSurveyDepartment(request))
                .setGroup(getSurveyGroup(request))
                .setComment(getSurveyComment(request))
                .setQuestionKitId(questionKit.getId());
        survey = surveyService.addSurvey(survey);
        return "redirect:continueQuiz?id=" + survey.getId();
    }

    @GetMapping("continueQuiz")
    public String continueSurvey(HttpServletRequest request, Model model) {
        int id = getSurveyId(request);
        model.addAttribute("survey_id", id);
        return "quiz/quiz/quiz";
    }

    private Integer getSurveyId(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }

    private QuestionKit getSurveyQuestionKit(HttpServletRequest request) {
        if ("".equals(request.getParameter("questionKit"))) {
            throw new IllegalArgumentException("this parameter must be don't null");
        }
        return questionKitService.getById(Integer.valueOf(request.getParameter("questionKit")));
    }

    private LocalDate getSurveyDate(HttpServletRequest request) {
        if ("".equals(request.getParameter("createDate"))) {
            return LocalDate.now();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(request.getParameter("createDate"), dtf);
    }


    private String getSurveyDepartment(HttpServletRequest request) {
        if (Objects.isNull(request.getParameter("department"))) {
            return null;
        }
        return request.getParameter("department");
    }

    private String getSurveyGroup(HttpServletRequest request) {
        if (Objects.isNull(request.getParameter("group"))) {
            return null;
        }
        return request.getParameter("group");
    }

    private String getSurveyComment(HttpServletRequest request) {
        return request.getParameter("comment");
    }


}
