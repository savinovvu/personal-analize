package ru.inbox.savinov_vu.controller.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {

    private static final Logger LOG = LoggerFactory.getLogger(SurveyController.class);


    @GetMapping("/conductSurvey")
    public String start(Model model) {
        LOG.info("get survey page");
        return "survey/survey";
    }
}
