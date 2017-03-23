package ru.inbox.savinov_vu.controller.rest.constructor.answerkit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;
import ru.inbox.savinov_vu.service.constructor.AnswerKit.AnswerKitService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/answerKit", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class AnswerKitRestController {

    @Autowired
    private AnswerKitService service;

    @GetMapping(value = "/all")
    public List<AnswerKit> getAllAnswerKits() {
        log.debug("\nget all questionkits");
        return service.getAll();

    }

    @PutMapping
    public List<AnswerKit> addAnswerKit(@RequestBody AnswerKit answerKit) {
        log.debug("\nput questionKit {}", answerKit);
        service.addAnswerKit(answerKit);
        return service.getAll();

    }

    @DeleteMapping
    public List<AnswerKit> deleteAnswerKit(@RequestBody AnswerKit answerKit) {
        log.debug("\ndelete questionKit {}", answerKit);
        service.deleteAnswerKit(answerKit);
        return service.getAll();

    }
}
