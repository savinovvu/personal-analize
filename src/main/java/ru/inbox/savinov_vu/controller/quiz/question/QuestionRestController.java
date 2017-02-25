package ru.inbox.savinov_vu.controller.quiz.question;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/quiz/question", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionRestController {
}
