package ru.inbox.savinov_vu.controller.page;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {


    private static final Logger LOG = LoggerFactory.getLogger(StartController.class);


    @GetMapping("/")
    public String start() {
        LOG.debug("get startPage");
        return "start/start";
    }

}