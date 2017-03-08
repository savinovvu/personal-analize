package ru.inbox.savinov_vu.controller.pdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.inbox.savinov_vu.service.quiz.questionnaire.QuestionnaireService;


@Controller
public class SurveyPdfController {

    @Autowired
    QuestionnaireService service;

    @GetMapping(value = "pdf/quiz/survey/{id}")
    public void editOrder(Model model, @PathVariable("id") int id) {
        model.addAttribute("questionnaires", service.getQuestionnairesWithSurvey(id));
    }


}
