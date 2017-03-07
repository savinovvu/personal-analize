package ru.inbox.savinov_vu.controller.quiz.answer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.service.quiz.answer.AnswerService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/quiz/answer", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnswerRestController {
    private static final Logger LOG = LoggerFactory.getLogger(AnswerRestController.class);

    @Autowired
    private AnswerService service;


    @GetMapping("/all")
    public List<Answer> getAllAnswers() {
        LOG.debug("get all Answers");
        return service.getAllAnswers();
    }

    @GetMapping("/{id}")
    public List<Answer> getAnswersWithQuestionnaire(@PathVariable("id") Integer id) {
        LOG.debug("get Questionnaires with Survey id = {}", id);
        return service.getAnswersWithQuestionnaire(id);
    }

    @PutMapping
    public String addAnswer(@RequestBody String json) throws IOException {
        List<Answer> answers = new ObjectMapper().readValue(json, new TypeReference<List<Answer>>() {
        });
        LOG.debug("add answers with= {}", answers);
       Integer questionnaireNumber =  service.addAnswer(answers);
        return "Анкета № " + questionnaireNumber + " добавлена" ;
    }

    @DeleteMapping
    public List<Answer> deleteAnswer(@RequestBody Answer answer) {
        LOG.debug("delete answer with id = {}", answer.getId());
        service.deleteAnswer(answer);
        return service.getAllAnswers();
    }
}
