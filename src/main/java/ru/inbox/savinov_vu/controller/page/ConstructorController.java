package ru.inbox.savinov_vu.controller.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class ConstructorController {
    @Autowired
    private QuestionVarService service;


    @GetMapping("editQuestionKit")
    public String editQuestionKit() {
        log.debug("\nget editQuestionKit");
        return "constructor/questionKit/questionKit";
    }

    @GetMapping("editQuestionVar")
    public String editQuestionVar() {
        log.debug("\nget editQuestionVar");
        return "constructor/questionVar/questionVar";
    }

    @GetMapping("editQuestionSub")
    public String editQuestionSub(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        log.debug("\nget editQuestionSub with id ={}", id);
        model.addAttribute("id", id);
        model.addAttribute("question", service.findById(id).getName());
        return "constructor/questionSub/questionSub";
    }

    @GetMapping("editAnswerKit")
    public String editAnswerKit() {
        log.debug("\nget editAnswerKit");
        return "constructor/answerKit/answerKit";
    }

    @GetMapping("editAnswerVar")
    public String editAnswerVar() {
        log.debug("\nget editAnswerVar");
        return "constructor/answerVar/answerVar";
    }
}
