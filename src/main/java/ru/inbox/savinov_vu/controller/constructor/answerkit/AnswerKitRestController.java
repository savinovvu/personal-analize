package ru.inbox.savinov_vu.controller.constructor.answerkit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;
import ru.inbox.savinov_vu.service.constructor.AnswerKit.AnswerKitService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/answerKit", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnswerKitRestController {

    @Autowired
    private AnswerKitService service;
    private static final Logger LOG = LoggerFactory.getLogger(AnswerKitRestController.class);

    @GetMapping(value = "/all")
    public List<AnswerKit> getAllAnswerKits() {
        LOG.debug("get all questionkits");
        return service.getAllAnswerKits();

    }

    @PutMapping
    public List<AnswerKit> addAnswerKit(@RequestBody AnswerKit answerKit) {
        LOG.debug("put questionKit {}", answerKit);
        service.addAnswerKit(answerKit);
        return service.getAllAnswerKits();

    }

    @DeleteMapping
    public List<AnswerKit> deleteAnswerKit(@RequestBody AnswerKit answerKit) {
        LOG.debug("delete questionKit {}", answerKit);
        service.deleteAnswerKit(answerKit);
        return service.getAllAnswerKits();

    }
}
