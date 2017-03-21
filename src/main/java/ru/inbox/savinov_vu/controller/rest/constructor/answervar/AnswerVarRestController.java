package ru.inbox.savinov_vu.controller.rest.constructor.answervar;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerVar;
import ru.inbox.savinov_vu.service.constructor.AnswerVar.AnswerVarService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/answerVar", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AnswerVarRestController {

    @Autowired
    private AnswerVarService service;


    @GetMapping("/{id}")
    public List<AnswerVar> getAnswerVarWithAnswerKit(@PathVariable("id") Integer id) {
        log.debug("\nget answerVars with answerKit_id = {}", id);
        return service.getAnswerVarWithAnswerKit(id);
    }

    @PutMapping
    public List<AnswerVar> addAnswerVar(@RequestBody AnswerVar answerVar) {
        log.debug("\nadd answerVar with {}", answerVar);
        service.addAnswerVar(answerVar);
        return service.getAnswerVarWithAnswerKit(answerVar.getAnswerKit().getId());
    }

    @DeleteMapping
    public List<AnswerVar> deleteAnswerVar(@RequestBody AnswerVar answerVar) {
        log.debug("\ndelete answerVar with id = {}", answerVar.getId());
        service.deleteAnswerVar(answerVar);
        return service.getAnswerVarWithAnswerKit(answerVar.getAnswerKit().getId());
    }
}
