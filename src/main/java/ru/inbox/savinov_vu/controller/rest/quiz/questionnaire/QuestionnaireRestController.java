package ru.inbox.savinov_vu.controller.rest.quiz.questionnaire;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.service.quiz.questionnaire.QuestionnaireService;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz/questionnaire", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class QuestionnaireRestController {

    @Autowired
    private QuestionnaireService service;


    @GetMapping("/all")
    public List<Questionnaire> getAllQuestionnaire() {
        log.debug("get all Questionnaires");
        return service.getAllQuestionnaires();
    }

    @GetMapping("/{id}")
    public List<Questionnaire> getQuestionnairesWithSurvey(@PathVariable("id") Integer id) {
        log.debug("get Questionnaires with Survey id = {}", id);
        return service.getQuestionnairesWithSurvey(id);
    }

    @GetMapping("/count/{id}")
    public Long getcountQuestionnairesWithSurvey(@PathVariable("id") Integer id) {
        log.debug("get countQuestionnaires with Survey id = {}", id);
        return service.getCountQuestionnairesWithSurvey(id);
    }

    @PutMapping
    public List<Questionnaire> addQuestionnaire(@RequestBody Questionnaire questionnaire) {
        log.debug("add questionnaire with {}", questionnaire);
        service.addQuestionnaire(questionnaire);
        return service.getAllQuestionnaires();
    }

    @DeleteMapping
    public List<Questionnaire> deleteQuestionnaire(@RequestBody Questionnaire questionnaire) {
        log.debug("delete questionnaire with id = {}", questionnaire.getId());
        service.deleteQuestionnaire(questionnaire);
        return service.getAllQuestionnaires();
    }
}
