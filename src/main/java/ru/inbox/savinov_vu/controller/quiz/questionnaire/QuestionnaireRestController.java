package ru.inbox.savinov_vu.controller.quiz.questionnaire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.service.quiz.questionnaire.QuestionnaireService;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz/questionnaire", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionnaireRestController {

    @Autowired
    private QuestionnaireService service;

    private static final Logger LOG = LoggerFactory.getLogger(QuestionnaireRestController.class);

    @GetMapping("/all")
    public List<Questionnaire> getAllQuestionnaire() {
        LOG.debug("get all Questionnaires");
        return service.getAllQuestionnaires();
    }

    @GetMapping("/{id}")
    public List<Questionnaire> getQuestionnairesWithSurvey(@PathVariable("id") Integer id) {
        LOG.debug("get Questionnaires with Survey id = {}", id);
        return service.getQuestionnairesWithSurvey(id);
    }

    @GetMapping("/count/{id}")
    public Long getcountQuestionnairesWithSurvey(@PathVariable("id") Integer id) {
        LOG.debug("get countQuestionnaires with Survey id = {}", id);
        return service.countQuestionnairesWithSurvey(id);
    }

    @PutMapping
    public List<Questionnaire> addQuestionnaire(@RequestBody Questionnaire questionnaire) {
        LOG.debug("add questionnaire with {}", questionnaire);
        service.addQuestionnaire(questionnaire);
        return service.getAllQuestionnaires();
    }

    @DeleteMapping
    public List<Questionnaire> deleteQuestionnaire(@RequestBody Questionnaire questionnaire) {
        LOG.debug("delete questionnaire with id = {}", questionnaire.getId());
        service.deleteQuestionnaire(questionnaire);
        return service.getAllQuestionnaires();
    }
}
