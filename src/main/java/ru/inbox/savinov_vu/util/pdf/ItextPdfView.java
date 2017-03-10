package ru.inbox.savinov_vu.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.model.quiz.questionnaire.Questionnaire;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;



public class ItextPdfView extends AbstractITextPdfView {
    static final int FONT_SIZE_SMALL = 16;
    static final int FONT_SIZE_BIG = 32;
    static final int OFFSET = 40;
    static final String FONT_LOCATION = "/Fonts/TIMCYR_TTF/TIMCYR.TTF";

    final BaseFont timesNewRoman =
            BaseFont.createFont(
                    FONT_LOCATION,
                    BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

    final Font fontBig = new Font(timesNewRoman, FONT_SIZE_BIG);
    final Font fontSmall = new Font(timesNewRoman, 14);
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
        Paragraph title = new Paragraph("Id Тестирования = " + survey.getId(), fontSmall);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        Paragraph methodicals = new Paragraph("Используемая методика: " + survey.getQuestionKit().getName(), fontSmall);
        document.add(methodicals);

        Paragraph dateParagraph = new Paragraph("Дата Тестирования: " + survey.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), fontSmall);
        document.add(dateParagraph);

        List<Questionnaire> questionnaires = new ArrayList(Arrays.asList(model.get("questionnaires")));
        Paragraph countQuestionnaire = new Paragraph("Количество анкет: " + questionnaires.size(), fontSmall);
        document.add(countQuestionnaire);


        if (Objects.nonNull(survey.getDepartment())) {
            Paragraph departmentParagraph = new Paragraph("Подразделение: " + survey.getDepartment().getName(), fontSmall);
            document.add(departmentParagraph);
            if (Objects.nonNull(survey.getGroup())) {
                Paragraph groupParagraph = new Paragraph("Группа: " + survey.getGroup().getName(), fontSmall);
                document.add(groupParagraph);
            }
        }

        if (Objects.nonNull(survey.getComment()) && !"".equals(survey.getComment())) {
            Paragraph commentParagraph = new Paragraph("комментарий: " + survey.getComment(), fontSmall);
            commentParagraph.setSpacingAfter(sizeSpacingAfter);
            document.add(commentParagraph);

        }


        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{90, 60, 30});


        table.addCell(getNormalCell("Вопрос", 15));
        table.addCell(getNormalCell("Ответ", 15));
        table.addCell(getNormalCell("Кол-во", 15));

        Map<QuestionVar, Map<Answer, Long>> questionAnswerCountMap = (Map<QuestionVar, Map<Answer, Long>>) model.get("countAnswerByQuestionMap");


        for (Map.Entry<QuestionVar, Map<Answer, Long>> questionVarMapEntry : questionAnswerCountMap.entrySet()) {
            table.addCell(getNormalCell(questionVarMapEntry.getKey().getName(), 12));
            table.addCell(getNormalCell("", 12));
            table.addCell(getNormalCell("", 12));
            for (Map.Entry<Answer, Long> answerLongEntry : questionVarMapEntry.getValue().entrySet()) {
                table.addCell(getNormalCell("", 12));
                table.addCell(getNormalCell(answerLongEntry.getKey().getName(), 12));
                table.addCell(getNormalCell(String.valueOf(answerLongEntry.getValue()), 12));
            }
        }

        document.add(table);


    }

    private PdfPCell getNormalCell(String string, float size)
            throws DocumentException, IOException {
        if (string != null && "".equals(string)) {
            return new PdfPCell();
        }
        Font f = font12;
        if (size < 0) {
            f.setColor(BaseColor.RED);
            size = -size;
        }
        f.setSize(size);
        PdfPCell cell = new PdfPCell(new Phrase(string, f));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        return cell;
    }


}
