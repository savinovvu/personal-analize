package ru.inbox.savinov_vu.controller.rest.quiz.question;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.service.quiz.question.QuestionService;

@RestController
@RequestMapping(value = "/quiz/question", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class QuestionRestController {

    @Autowired
    QuestionService service;

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable("id") Integer id) {
        log.debug("get question with id = {}", id);
        return service.findOne(id);

    }
}

