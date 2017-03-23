package ru.inbox.savinov_vu.controller.rest.quiz.answer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AnswerRestController {
    private static final Logger LOG = LoggerFactory.getLogger(AnswerRestController.class);

    @Autowired
    private AnswerService service;


    @GetMapping("/all")
    public List<Answer> getAllAnswers() {
        log.debug("\nget all Answers");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public List<Answer> getAnswersWithQuestionnaire(@PathVariable("id") Integer id) {
        log.debug("\nget Questionnaires with Survey id = {}", id);
        return service.getAnswersWithQuestionnaire(id);
    }

    @PutMapping
    public String addAnswer(@RequestBody String json) throws IOException {
        List<Answer> answers = new ObjectMapper().readValue(json, new TypeReference<List<Answer>>() {
        });
        log.debug("\nadd answers with= {}", answers);
        Integer questionnaireNumber = service.addAnswer(answers);
        return "Анкета № " + questionnaireNumber + " добавлена";
    }

    @PostMapping
    public List<Answer> updateAnswer(@RequestBody Answer answer) throws IOException {
        log.debug("\nadd answers with= {}", answer);
        service.addAnswer(answer);
        return service.getAnswersWithQuestionnaire(answer.getQuestionnaire().getId());
    }

    @DeleteMapping
    public List<Answer> deleteAnswer(@RequestBody Answer answer) {
        log.debug("\ndelete answer with id = {}", answer.getId());
        service.deleteAnswer(answer);
        return service.getAnswersWithQuestionnaire(answer.getQuestionnaire().getId());
    }
}
