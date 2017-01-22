package ru.inbox.savinov_vu.controller.constructor.answervar;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerVar;
import ru.inbox.savinov_vu.service.constructor.AnswerVar.AnswerVarService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/answerVar", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnswerVarRestController {

    @Autowired
    private AnswerVarService service;

    private static final Logger LOG = LoggerFactory.getLogger(AnswerVarRestController.class);

    @GetMapping("/{id}")
    public List<AnswerVar> getAnswerVarWithAnswerKit(@PathVariable("id") Integer id) {
        return service.getAnswerVarWithAnswerKit(id);
    }

    @PutMapping
    public List<AnswerVar> addAnswerVar(@RequestBody AnswerVar answerVar) {
        LOG.info("add answerVar with {}", answerVar);
        service.addAnswerVar(answerVar);
        return service.getAnswerVarWithAnswerKit(answerVar.getAnswerKit().getId());
    }

    @DeleteMapping
    public List<AnswerVar> deleteAnswerVar(@RequestBody AnswerVar answerVar) {
        LOG.info("delete answerVar with id = {}", answerVar.getId());
        service.deleteAnswerVar(answerVar);
        return service.getAnswerVarWithAnswerKit(answerVar.getAnswerKit().getId());
    }
}
