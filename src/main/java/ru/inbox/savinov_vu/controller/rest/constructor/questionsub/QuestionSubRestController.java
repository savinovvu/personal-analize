package ru.inbox.savinov_vu.controller.rest.constructor.questionsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/questionSub", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionSubRestController {

    @Autowired
    private QuestionVarService service;
    private static final Logger LOG = LoggerFactory.getLogger(QuestionSubRestController.class);

    @GetMapping("/{id}")
    public List<QuestionVar> getQuestionSubWithQuestionVar(@PathVariable("id") Integer id) {
        LOG.debug("get questonVar with questionVar_id={}", id);
        return service.getQuestionVarWithSuperQuestionVar(id);
    }

    @PutMapping
    public List<QuestionVar> addQuestionSub(@RequestBody QuestionVar questionVar) {
        LOG.debug("add questonVar with {}", questionVar);
        service.addQuestionVar(questionVar);
        return service.getQuestionVarWithSuperQuestionVar(questionVar.getSuperQuestionVarId());

    }

    @DeleteMapping
    public List<QuestionVar> deleteQuestionSub(@RequestBody QuestionVar questionVar) {
        LOG.debug("delete questonVar with id = {}", questionVar.getId());
        service.deleteQuestionVar(questionVar);
        return service.getQuestionVarWithSuperQuestionVar(questionVar.getSuperQuestionVarId());
    }

}