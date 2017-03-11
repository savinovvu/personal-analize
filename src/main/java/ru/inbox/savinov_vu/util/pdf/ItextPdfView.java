package ru.inbox.savinov_vu.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


public class ItextPdfView extends AbstractITextPdfView {
    @Autowired
    QuestionVarService service;


    static final int FONT_SIZE_SMALL = 16;
    static final int FONT_SIZE_BIG = 32;
    static final int OFFSET = 40;
    static final String FONT_LOCATION = "/Fonts/TIMCYR_TTF/TIMCYR.TTF";

    final BaseFont timesNewRoman =
            BaseFont.createFont(
                    FONT_LOCATION,
                    BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

    final Font fontBig = new Font(timesNewRoman, FONT_SIZE_BIG);
    final Font font14 = new Font(timesNewRoman, 14);
    final Font font12 = new Font(timesNewRoman, 12);
    final Font font8 = new Font(timesNewRoman, 8);

    final int sizeSpacingAfter = 8;
    final Font font1 = new Font(timesNewRoman,
            FONT_SIZE_BIG, Font.BOLD);
    final Font font2 = new Font(timesNewRoman,
            FONT_SIZE_SMALL, Font.ITALIC | Font.UNDERLINE);

    public ItextPdfView() throws IOException, DocumentException {
    }


    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Survey survey = (Survey) model.get("survey");
        Paragraph title = new Paragraph("Id Тестирования = " + survey.getId(), font14);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        Paragraph methodicals = new Paragraph("Используемая методика: " + survey.getQuestionKit().getName(), font14);
        document.add(methodicals);

        Paragraph dateParagraph = new Paragraph("Дата Тестирования: " + survey.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), font14);
        document.add(dateParagraph);

        List<Questionnaire> questionnaires = new ArrayList(Arrays.asList(model.get("questionnaires")));
        Paragraph countQuestionnaire = new Paragraph("Количество анкет: " + questionnaires.size(), font14);
        document.add(countQuestionnaire);


        if (Objects.nonNull(survey.getDepartment())) {
            Paragraph departmentParagraph = new Paragraph("Подразделение: " + survey.getDepartment().getName(), font14);
            document.add(departmentParagraph);
            if (Objects.nonNull(survey.getGroup())) {
                Paragraph groupParagraph = new Paragraph("Группа: " + survey.getGroup().getName(), font14);
                document.add(groupParagraph);
            }
        }

        if (Objects.nonNull(survey.getComment()) && !"".equals(survey.getComment())) {
            Paragraph commentParagraph = new Paragraph("комментарий: " + survey.getComment(), font14);
            commentParagraph.setSpacingAfter(sizeSpacingAfter);
            document.add(commentParagraph);

        }


        Map<QuestionVar, Map<Answer, Long>> questionAnswerCountMap = (Map<QuestionVar, Map<Answer, Long>>) model.get("countAnswerByQuestionMap");

        writeQuestionAndAnswer(document, questionAnswerCountMap);


    }

    private void writeQuestionAndAnswer(Document document, Map<QuestionVar, Map<Answer, Long>> questionAnswerCountMap) throws DocumentException {
        QuestionVar savedSuperQuestion = new QuestionVar();
        for (Map.Entry<QuestionVar, Map<Answer, Long>> questionVarMapEntry : questionAnswerCountMap.entrySet()) {
            writeQuestion(document, savedSuperQuestion, questionVarMapEntry);
            for (Map.Entry<Answer, Long> answerLongEntry : questionVarMapEntry.getValue().entrySet()) {
                writeAnswer(document, answerLongEntry);
            }
            Paragraph emptyParagraph = new Paragraph(" ");
            emptyParagraph.setSpacingAfter(sizeSpacingAfter);
            document.add(emptyParagraph);
        }
    }

    private void writeQuestion(Document document, QuestionVar savedSuperQuestion, Map.Entry<QuestionVar, Map<Answer, Long>> questionVarMapEntry) throws DocumentException {
        QuestionVar question = questionVarMapEntry.getKey();
        AddSuperQuestion(savedSuperQuestion, question, document);
        document.add(getQuestionParagraph(question));
    }

    private Paragraph getQuestionParagraph(QuestionVar question) {
        if (Objects.isNull(question.getSuperQuestionVarId())) {
            return new Paragraph( question.getNumber() + ". " + question.getName(), font14);
        } else {
            return new Paragraph("     " + question.getNumber() + ". " + question.getName(), font14);
        }
    }

    private void writeAnswer(Document document, Map.Entry<Answer, Long> answerLongEntry) throws DocumentException {
        Paragraph answerParagrapg = new Paragraph("                " + answerLongEntry.getKey().getName() + " - " + answerLongEntry.getValue(), font14);
        document.add(answerParagrapg);
    }


    private void AddSuperQuestion(QuestionVar savedSuperQuestion, QuestionVar currentQuestion, Document document) throws DocumentException {

        if (Objects.nonNull(currentQuestion.getSuperQuestionVarId())) {
            if (!currentQuestion.getSuperQuestionVarId().equals(savedSuperQuestion.getId())) {
                QuestionVar byId = service.findById(currentQuestion.getSuperQuestionVarId());
                savedSuperQuestion.setId(byId.getId()).setName(byId.getName()).setNumber(byId.getNumber());
                Paragraph questionParagraph = new Paragraph(savedSuperQuestion.getNumber() + ". " + savedSuperQuestion.getName(), font14);
                document.add(questionParagraph);
            }
        }
    }

}


