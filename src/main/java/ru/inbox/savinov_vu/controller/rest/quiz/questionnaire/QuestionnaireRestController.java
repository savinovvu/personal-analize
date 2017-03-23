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
        log.debug("\nget all Questionnaires");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public List<Questionnaire> getQuestionnairesWithSurvey(@PathVariable("id") Integer id) {
        log.debug("\nget Questionnaires with Survey id = {}", id);
        return service.getQuestionnairesWithSurvey(id);
    }

    @GetMapping("/count/{id}")
    public Long getcountQuestionnairesWithSurvey(@PathVariable("id") Integer id) {
        log.debug("\nget countQuestionnaires with Survey id = {}", id);
        return service.getCountQuestionnairesWithSurvey(id);
    }

    @PutMapping
    public List<Questionnaire> addQuestionnaire(@RequestBody Questionnaire questionnaire) {
        log.debug("\nadd questionnaire with {}", questionnaire);
        service.addQuestionnaire(questionnaire);
        return service.getAll();
    }

    @DeleteMapping
    public List<Questionnaire> deleteQuestionnaire(@RequestBody Questionnaire questionnaire) {
        log.debug("\ndelete questionnaire with id = {}", questionnaire.getId());
        service.deleteQuestionnaire(questionnaire);
        return service.getQuestionnairesWithSurvey(questionnaire.getSurvey().getId());
    }
}
