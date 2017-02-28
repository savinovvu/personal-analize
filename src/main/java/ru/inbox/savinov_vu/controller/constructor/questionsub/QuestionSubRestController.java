package ru.inbox.savinov_vu.controller.constructor.questionsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.question.QuestionSub;
import ru.inbox.savinov_vu.service.constructor.questionSub.QuestionSubService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/questionSub", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionSubRestController {

    @Autowired
    private QuestionSubService service;
    private static final Logger LOG = LoggerFactory.getLogger(QuestionSubRestController.class);

    @GetMapping("/{id}")
    public List<QuestionSub> getQuestionSubWithQuestionVar(@PathVariable("id") Integer id) {
        LOG.debug("get questionSub with questionVar_id={}", id);
        return service.getQuestionSubWithQuestionVar(id);
    }

    @PutMapping
    public List<QuestionSub> addQuestionSub(@RequestBody QuestionSub questionSub) {
        LOG.debug("add questionSub with {}", questionSub);
        service.addQuestionSub(questionSub);
        return service.getQuestionSubWithQuestionVar(questionSub.getQuestionVar().getId());

    }

    @DeleteMapping
    public List<QuestionSub> deleteQuestionSub(@RequestBody QuestionSub questionSub) {
        LOG.debug("delete questionSub with id = {}", questionSub.getId());
        service.deleteQuestionSub(questionSub);
        return service.getQuestionSubWithQuestionVar(questionSub.getQuestionVar().getId());
    }

}