package ru.inbox.savinov_vu.controller.constructor.answerkit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.service.constructor.AnswerKit.AnswerKitService;

@RestController
@RequestMapping(value = "/constructor/answerVar", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnswerKitRestController {

    @Autowired
    private AnswerKitService service;
    private static final Logger LOG = LoggerFactory.getLogger(AnswerKitRestController.class);
}
