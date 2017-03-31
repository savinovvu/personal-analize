package ru.inbox.savinov_vu.controller.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerKit;
import ru.inbox.savinov_vu.model.constructor.answer.AnswerType;
import ru.inbox.savinov_vu.model.constructor.question.QuestionKit;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.service.constructor.AnswerKit.AnswerKitService;
import ru.inbox.savinov_vu.service.constructor.quesiontKit.QuestionKitService;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class ConstructorController {
    @Autowired
    private QuestionVarService questionVarService;
    @Autowired
    private QuestionKitService questionKitService;
    @Autowired
    private AnswerKitService answerKitService;


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

    @GetMapping("newQuestionKit")
    public String newQuestionKit(HttpServletRequest request, Model model) {
        int id = 0;
        String name = request.getParameter("name");
        QuestionKit questionKit = questionKitService.addQuestionKit(new QuestionKit(id, name));
        return String.format("redirect:questionVarMenu?id=%s",questionKit.getId());
    }


    @GetMapping("questionVarMenu")
    public String continueQuestionVar(HttpServletRequest request, Model model) {
        int id = Integer.valueOf(request.getParameter("id"));
        QuestionKit questionKit = questionKitService.getById(id);
        model.addAttribute("questionKit_id", id);
        model.addAttribute("questionKit_name", questionKit.getName());
        return "constructor/questionVar/questionVarMenu";
    }

    @GetMapping("newAnswerKit")
    public String newAnswerKit(HttpServletRequest request, Model model) {
        String questionName = request.getParameter("name");
        String superQuestionVarIdString = request.getParameter("superQuestionVarId");
        Integer superQuestionVarId = superQuestionVarIdString == null ||"null".equals(superQuestionVarIdString)? null : Integer.valueOf(superQuestionVarIdString);
        Integer questionKitId = Integer.valueOf(request.getParameter("questionKitId"));
        AnswerKit answerKit = answerKitService.addAnswerKit(new AnswerKit("ответы для: " + questionName, AnswerType.RADIO));
        questionVarService.addQuestionVar(new QuestionVar(questionName, superQuestionVarId ,answerKit, new QuestionKit(questionKitId, null)));
        return String.format("redirect:answerVarMenu?id=%s&questionKitId=%s",answerKit.getId(),questionKitId);
    }


    @GetMapping("answerVarMenu")
    public String continueAnswerVar(HttpServletRequest request, Model model) {
        int id = Integer.valueOf(request.getParameter("id"));
        int questionKitId = Integer.valueOf(request.getParameter("questionKitId"));
        AnswerKit answerKit = answerKitService.getById(id);
        model.addAttribute("answerKit_id", id);
        model.addAttribute("questionKit_id", questionKitId);
        model.addAttribute("answerKit_name", answerKit.getName());
        return "constructor/answerVar/answerVarMenu";
    }


    @GetMapping("editQuestionSub")
    public String editQuestionSub(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        log.debug("\nget editQuestionSub with id ={}", id);
        model.addAttribute("id", id);
        model.addAttribute("question", questionVarService.findById(id).getName());
        return "constructor/questionSub/questionSub";
    }

    @GetMapping("questionSubMenu")
    public String questionSubMenu(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        int questionKitId = Integer.parseInt(request.getParameter("questionKitId"));
        String name = request.getParameter("name");
        log.debug("\nget editQuestionSubMenu with id ={}", id);
        model.addAttribute("question_id", id);
        model.addAttribute("question_name",name);
        model.addAttribute("questionKit_id", questionKitId);
        return "constructor/questionSub/questionSubMenu";
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
