package ru.inbox.savinov_vu.controller.rest.constructor.questionkit;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.service.constructor.quesiontKit.QuestionKitService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/questionKit", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class QuestionKitRestController {

    @Autowired
    private QuestionKitService service;


    @GetMapping(value = "/all")
    public List<QuestionKit> getAllQuestionKits() {
        log.debug("\nget all questionkits");
        return service.getAllQuestionKits();

    }

   @PutMapping
    public List<QuestionKit> addQuestionKit(@RequestBody QuestionKit questionKit) {
       log.debug("\nput questionKit {}", questionKit);
       service.addQuestionKit(questionKit);
        return service.getAllQuestionKits();

    }

   @DeleteMapping
    public List<QuestionKit> deleteQuestionKit(@RequestBody QuestionKit questionKit) {
       log.debug("\ndelete questionKit {}", questionKit);
       service.deleteQuestionKit(questionKit);
       return service.getAllQuestionKits();

    }

}
