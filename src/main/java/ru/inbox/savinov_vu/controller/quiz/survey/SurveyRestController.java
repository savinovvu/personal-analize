package ru.inbox.savinov_vu.controller.quiz.survey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.service.quiz.survey.SurveyService;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz/survey", produces = MediaType.APPLICATION_JSON_VALUE)
public class SurveyRestController {
    @Autowired
    private SurveyService service;

    private static final Logger LOG = LoggerFactory.getLogger(SurveyRestController.class);

    @GetMapping("/all")
    public List<Survey> getAllSurveys() {
        LOG.debug("get all Surveys");
        return service.getAllSurveys();
    }

    @GetMapping("/{id}")
    public Survey getSurveyById(@PathVariable("id") Integer id) {
        LOG.debug("get Survey By id = {}", id);
        return service.getSurveyByID(id);
    }

    @PutMapping
    public List<Survey> addSurvey(@RequestBody Survey survey) {
        LOG.debug("add survey with {}", survey);
        service.addSurvey(survey);
        return service.getAllSurveys();
    }

    @DeleteMapping
    public List<Survey> deleteSurvey(@RequestBody Survey survey) {
        LOG.debug("delete survey with id = {}", survey.getId());
        service.deleteSurvey(survey);
        return service.getAllSurveys();
    }
}
