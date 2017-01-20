package ru.inbox.savinov_vu.controller.constructor.question;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.service.constructor.quesiontKit.QuesitionKitService;

import java.util.List;

@RestController
@RequestMapping(value = "/buildAnket/question/questionKit", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionKitRestController {

    @Autowired
    private QuesitionKitService service;

    private static final Logger LOG = LoggerFactory.getLogger(QuestionKitRestController.class);

    @GetMapping(value = "/all")
    public List<QuestionKit> getAllAnswerVariant() {
        LOG.info("get all groups");
        return null;

    }

}
