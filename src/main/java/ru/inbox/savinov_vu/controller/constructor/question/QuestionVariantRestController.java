package ru.inbox.savinov_vu.controller.constructor.question;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerSource;

import java.util.Map;

@RestController
@RequestMapping(value = "/buildAnket/question", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionVariantRestController {
    private static final Logger LOG = LoggerFactory.getLogger(QuestionVariantRestController.class);

    @GetMapping(value = "/all")
    public Map<String, AnswerSource> getAllAnswerVariant() {
        LOG.info("get all groups");
        return null;

    }

}
