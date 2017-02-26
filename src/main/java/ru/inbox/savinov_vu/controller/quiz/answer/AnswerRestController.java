package ru.inbox.savinov_vu.controller.quiz.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.service.quiz.answer.AnswerService;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz/answer", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnswerRestController {

    @Autowired
    private AnswerService service;

    private static final Logger LOG = LoggerFactory.getLogger(AnswerRestController.class);

    @GetMapping("/all")
    public List<Answer> getAllQuestionnaire() {
        LOG.info("get all Answers");
        return service.getAllAnswers();
    }

    @GetMapping("/{id}")
    public List<Answer> getAnswerVarWithAnswerKit(@PathVariable("id") Integer id) {
        LOG.info("get Questionnaires with Survey id = {}", id);
        return service.getAnswersWithQuestion(id);
    }

    @PutMapping
    public List<Answer> addAnswerVar(@RequestBody Answer answer) {
        LOG.info("add answer with {}", answer);
        service.addAnswer(answer);
        return service.getAllAnswers();
    }

    @DeleteMapping
    public List<Answer> deleteAnswerVar(@RequestBody Answer answer) {
        LOG.info("delete answer with id = {}", answer.getId());
        service.deleteAnswer(answer);
        return service.getAllAnswers();
    }
}
