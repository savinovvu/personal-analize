package ru.inbox.savinov_vu.controller.quiz.question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.service.quiz.question.QuestionService;

import java.util.List;

@RestController
@RequestMapping(value = "/quiz/question", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionRestController {

    @Autowired
    private QuestionService service;

    private static final Logger LOG = LoggerFactory.getLogger(QuestionRestController.class);

    @GetMapping("/all")
    public List<Question> getAllQuestion() {
        LOG.info("get all Question");
        return service.getAllQuestions();
    }

    @GetMapping("/{id}")
    public List<Question> getQuestionWithQuestionnaire(@PathVariable("id") Integer id) {
        LOG.info("get Questions with Questionnaire id = {}", id);
        return service.getQuestionsWithQuestionnaire(id);
    }

    @PutMapping
    public List<Question> addQuestion(@RequestBody Question question) {
        LOG.info("add question with {}", question);
        service.addQuestion(question);
        return service.getAllQuestions();
    }

    @DeleteMapping
    public List<Question> deleteQuestion(@RequestBody Question question) {
        LOG.info("delete question with id = {}", question.getId());
        service.deleteQuestion(question);
        return service.getAllQuestions();
    }

}
