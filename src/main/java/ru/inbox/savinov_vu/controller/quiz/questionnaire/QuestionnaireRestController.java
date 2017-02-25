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
        LOG.info("get all Questionnaires");
        return service.getAllQuestionnaires();
    }

    @GetMapping("/{id}")
    public List<Questionnaire> getAnswerVarWithAnswerKit(@PathVariable("id") Integer id) {
        LOG.info("get Questionnaires with Survey id = {}", id);
        return service.getQuestionnairesWithSurvey(id);
    }

    @PutMapping
    public List<Questionnaire> addAnswerVar(@RequestBody Questionnaire questionnaire) {
        LOG.info("add questionnaire with {}", questionnaire);
        service.addQuestionnaire(questionnaire);
        return service.getAllQuestionnaires();
    }

    @DeleteMapping
    public List<Questionnaire> deleteAnswerVar(@RequestBody Questionnaire questionnaire) {
        LOG.info("delete questionnaire with id = {}", questionnaire.getId());
        service.deleteQuestionnaire(questionnaire);
        return service.getAllQuestionnaires();
    }
}
