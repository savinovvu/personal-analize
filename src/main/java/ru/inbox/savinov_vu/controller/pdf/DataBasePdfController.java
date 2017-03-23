package ru.inbox.savinov_vu.controller.pdf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inbox.savinov_vu.service.pdf.PdfPrint;

@Controller
@Slf4j
public class DataBasePdfController {

    @GetMapping(value = "pdf/dataBase")
    public void getPdfSurvey(Model model) {
        model.addAttribute("action", PdfPrint.DataBase);
    }
}