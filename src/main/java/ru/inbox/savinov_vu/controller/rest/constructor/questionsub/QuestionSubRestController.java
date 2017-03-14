package ru.inbox.savinov_vu.controller.rest.constructor.questionsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/questionSub", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class QuestionSubRestController {

    @Autowired
    private QuestionVarService service;

    @GetMapping("/{id}")
    public List<QuestionVar> getQuestionSubWithQuestionVar(@PathVariable("id") Integer id) {
        log.debug("get questonVar with questionVar_id={}", id);
        return service.getQuestionVarWithSuperQuestionVar(id);
    }

    @PutMapping
    public List<QuestionVar> addQuestionSub(@RequestBody QuestionVar questionVar) {
        log.debug("add questonVar with {}", questionVar);
        service.addQuestionVar(questionVar);
        return service.getQuestionVarWithSuperQuestionVar(questionVar.getSuperQuestionVarId());

    }

    @DeleteMapping
    public List<QuestionVar> deleteQuestionSub(@RequestBody QuestionVar questionVar) {
        log.debug("delete questonVar with id = {}", questionVar.getId());
        service.deleteQuestionVar(questionVar);
        return service.getQuestionVarWithSuperQuestionVar(questionVar.getSuperQuestionVarId());
    }

}