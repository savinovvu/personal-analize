package ru.inbox.savinov_vu.controller.rest.constructor.questionvar;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/questionVar", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class QuestionVarRestController {

    @Autowired
    private QuestionVarService service;

    @GetMapping("/{id}")
    public List<QuestionVar> getQuestionVarWithQuestionKit(@PathVariable("id") Integer id) {
        log.debug("\nget QuestionVar with QuestionKit id = {}", id);
        return service.getQuestionVarWithQuestionKit(id);
    }

    @PutMapping
    public List<QuestionVar> addQuestionVar(@RequestBody QuestionVar questionVar) {
        log.debug("\nadd questionVar with {}", questionVar);
        service.addQuestionVar(questionVar);
        return service.getQuestionVarWithQuestionKit(questionVar.getQuestionKit().getId());
    }

    @DeleteMapping
    public List<QuestionVar> deleteQuestionVar(@RequestBody QuestionVar questionVar) {
        log.debug("\ndelete questionVar with id = {}", questionVar.getId());
        service.deleteQuestionVar(questionVar);
        return service.getQuestionVarWithQuestionKit(questionVar.getQuestionKit().getId());
    }

}
