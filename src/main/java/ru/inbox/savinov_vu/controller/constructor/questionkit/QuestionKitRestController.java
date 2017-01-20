package ru.inbox.savinov_vu.controller.constructor.questionkit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.service.constructor.quesiontKit.QuestionKitService;

import java.util.List;

@RestController
@RequestMapping(value = "/constructor/questionKit", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionKitRestController {

    @Autowired
    private QuestionKitService service;

    private static final Logger LOG = LoggerFactory.getLogger(QuestionKitRestController.class);

    @GetMapping(value = "/all")
    public List<QuestionKit> getAllAnswerVariant() {
        LOG.info("get all questionkits");
        return service.getAllQuestionKits();

    }

}
