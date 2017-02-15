package ru.inbox.savinov_vu.controller.constructor.questionvar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/questionVar", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionVarRestController {

    @Autowired
    private QuestionVarService service;
    private static final Logger LOG = LoggerFactory.getLogger(QuestionVarRestController.class);

    @GetMapping("/{id}")
    public List<QuestionVar> getQuestionVarWithQuestionKit(@PathVariable("id") Integer id) {
        return service.getQuestionVarWithQuestionKit(id);
    }

    @PutMapping
    public List<QuestionVar> addQuestionVar(@RequestBody QuestionVar questionVar) {
        LOG.info("add questionVar with {}", questionVar);
        service.addQuestionVar(questionVar);
        return service.getQuestionVarWithQuestionKit(questionVar.getQuestionKit().getId());
    }

    @DeleteMapping
    public List<QuestionVar> deleteQuestionVar(@RequestBody QuestionVar questionVar) {
        LOG.info("delete questionVar with id = {}", questionVar.getId());
        service.deleteQuestionVar(questionVar);
        return service.getQuestionVarWithQuestionKit(questionVar.getQuestionKit().getId());
    }

}
