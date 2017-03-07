package ru.inbox.savinov_vu.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConstructorController {
    @Autowired
    private QuestionVarService service;

    private static final Logger LOG = LoggerFactory.getLogger(StartController.class);

    @GetMapping("editQuestionKit")
    public String editQuestionKit(Model model) {
        LOG.debug("get editQuestionKit");
        return "constructor/questionKit/questionKit";
    }

    @GetMapping("editQuestionVar")
    public String editQuestionVar(Model model) {
        LOG.debug("get editQuestionVar");
        return "constructor/questionVar/questionVar";
    }

    @GetMapping("editQuestionSub")
    public String editQuestionSub(HttpServletRequest request, Model model ) {
        int id = Integer.parseInt(request.getParameter("id"));
        LOG.debug("get editQuestionSub with id ={}", id);
        model.addAttribute("id", id);
        model.addAttribute("question", service.findById(id).getName());
        return "constructor/questionSub/questionSub";
    }

    @GetMapping("editAnswerKit")
    public String editAnswerKit(Model model) {
        LOG.debug("get editAnswerKit");
        return "constructor/answerKit/answerKit";
    }

    @GetMapping("editAnswerVar")
    public String editAnswerVar(Model model) {
        LOG.debug("get editAnswerVar");
        return "constructor/answerVar/answerVar";
    }
}
