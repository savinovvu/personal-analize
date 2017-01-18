package ru.inbox.savinov_vu.controller.start;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {


    private static final Logger LOG = LoggerFactory.getLogger(StartController.class);



    @GetMapping("/")
    public String start(Model model) {
        LOG.info("get startPage");
        return "start/start";
    }

    @GetMapping("editQuestionKit")
    public String editQuestionKit(Model model) {
        LOG.info("get editQuestionKit");
        return "constructor/questionKit/questionKit";
    }

    @GetMapping("editQuestionVar")
    public String editQuestionVar(Model model) {
        LOG.info("get editQuestionVar");
        return "constructor/questionVar/questionVar";
    }

    @GetMapping("editAnswerKit")
    public String editAnswerKit(Model model) {
        LOG.info("get editAnswerKit");
        return "constructor/answerKit/answerKit";
    }

    @GetMapping("editAnswerVar")
    public String editAnswerVar(Model model) {
        LOG.info("get editAnswerVar");
        return "constructor/answerVar/answerVar";
    }



    @GetMapping("editDepartment")
    public String personalDepartment(Model model) {
        LOG.info("get editDepartment page");
        return "personal/department/department";
    }

    @GetMapping("editGroup")
    public String personalGroup(Model model) {
        LOG.info("get editGroup page");
        return "personal/group/group";
    }

    @GetMapping("editPerson")
    public String personalPerson(Model model) {
        LOG.info("get editPerson page");
        return "personal/person/person";
    }









}