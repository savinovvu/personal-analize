package ru.inbox.savinov_vu.controller.testing.buildAnket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.model.testing.buildAnket.AnswerVariant;

import java.util.List;

@RestController
@RequestMapping(value = "/buildAnket/answer", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnswerVariantRestController {

    private static final Logger LOG = LoggerFactory.getLogger(AnswerVariantRestController.class);

    @GetMapping(value = "/all")
    public List<String> getAllAnswerVariant() {

        LOG.info("get all groups");
        return AnswerVariant.getInstance().getAnswer();

    }
}
