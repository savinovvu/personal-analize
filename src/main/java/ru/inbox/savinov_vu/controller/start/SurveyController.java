package ru.inbox.savinov_vu.controller.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.model.personal.Department;
import ru.inbox.savinov_vu.model.personal.Group;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.service.quiz.survey.SurveyService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Controller
public class SurveyController {
    @Autowired
    SurveyService service;

    private static final Logger LOG = LoggerFactory.getLogger(SurveyController.class);


    @GetMapping("conductSurvey")
    public String start(Model model) {
        LOG.debug("get quiz page");
        return "quiz/survey/survey";
    }

    @GetMapping("beginNewSurvey")
    public String beginNewSurvey (HttpServletRequest request,
                                  RedirectAttributes redirectAttributes, Model model){
        LOG.debug("get beginSurveyPage");

        Survey survey = new Survey();
        survey.setId(getSurveyId(request))
                .setQuestionKit(getSurveyQuestionKit(request))
                .setDate(getSurveyDate(request))
                .setDepartment(getSurveyDepartment(request))
                .setGroup(getSurveyGroup(request))
                .setComment(getSurveyComment(request));
        survey = service.addSurvey(survey);
        return "redirect:continueSurvey?id=" + survey.getId();
    }

    @GetMapping("continueSurvey")
    public String continueSurvey(HttpServletRequest request, Model model) {
        int id = getSurveyId(request);
        model.addAttribute("survey_id", id);
        model.addAttribute("numberOfQuestionnaire", service.getSurveyByID(id).getCount()+1);
        return "quiz/questionnaire/questionnaire";
    }

    private Integer getSurveyId(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }

    private QuestionKit getSurveyQuestionKit(HttpServletRequest request) {
        if ("".equals(request.getParameter("questionKit"))){
            throw new IllegalArgumentException("this parameter must be don't null");
        }
        return new QuestionKit().setId(Integer.valueOf(request.getParameter("questionKit")));
    }

    private LocalDate getSurveyDate(HttpServletRequest request) {
        if ("".equals(request.getParameter("createDate"))){
            return LocalDate.now();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(request.getParameter("createDate"), dtf);
    }


    private Department getSurveyDepartment(HttpServletRequest request) {
        if (Objects.isNull(request.getParameter("department"))){
            return null;
        }
        return new Department().setId(Integer.valueOf(request.getParameter("department")));
    }

    private Group getSurveyGroup(HttpServletRequest request) {
        if (Objects.isNull(request.getParameter("group"))){
            return null;
        }
        return new Group().setId(Integer.valueOf(request.getParameter("group")));
    }

    private String getSurveyComment(HttpServletRequest request) {
             return request.getParameter("comment");
    }


}
