package ru.inbox.savinov_vu.controller.start;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String beginNewSurvey(HttpServletRequest request, Model model) {
        LOG.debug("get beginSurveyPage");
        ObjectMapper mapper = new ObjectMapper();
        Survey survey = new Survey();
        survey.setId(getSurveyId(request))
                .setQuestionKit(getSurveyQuestionKit(request))
                .setDate(getSurveyDate(request))
                .setDepartment(getSurveyDepartment(request))
                .setGroup(getSurveyGroup(request))
                .setComment(getSurveyComment(request));
        service.addSurvey(survey);
        model.addAttribute("survey_id", survey.getId());

        return "quiz/questionnaire/questionnaire";
    }

    private Integer getSurveyId(HttpServletRequest request) {
        return Integer.valueOf(request.getParameter("id"));
    }

    private QuestionKit getSurveyQuestionKit(HttpServletRequest request) {

        return new QuestionKit().setId(Integer.valueOf(request.getParameter("questionKit")));
    }

    private LocalDate getSurveyDate(HttpServletRequest request) {
        String dateString = request.getParameter("createDate");
        if(Objects.isNull(dateString)) {return LocalDate.now();}
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, dtf);
    }


    private Department getSurveyDepartment(HttpServletRequest request) {
        return new Department().setId(Integer.valueOf(request.getParameter("department")));
    }

    private Group getSurveyGroup(HttpServletRequest request) {
        return new Group().setId(Integer.valueOf(request.getParameter("group")));
    }

    private String getSurveyComment(HttpServletRequest request) {
        return request.getParameter("comment");
    }


}
