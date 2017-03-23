package ru.inbox.savinov_vu.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.inbox.savinov_vu.model.quiz.answer.Answer;
import ru.inbox.savinov_vu.model.quiz.question.Question;
import ru.inbox.savinov_vu.model.quiz.survey.Survey;
import ru.inbox.savinov_vu.service.ParentService;
import ru.inbox.savinov_vu.service.constructor.AnswerKit.AnswerKitService;
import ru.inbox.savinov_vu.service.constructor.AnswerVar.AnswerVarService;
import ru.inbox.savinov_vu.service.constructor.quesiontKit.QuestionKitService;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;
import ru.inbox.savinov_vu.service.personal.department.DepartmentService;
import ru.inbox.savinov_vu.service.personal.group.GroupService;
import ru.inbox.savinov_vu.service.personal.person.PersonService;
import ru.inbox.savinov_vu.service.quiz.answer.AnswerService;
import ru.inbox.savinov_vu.service.quiz.question.QuestionService;
import ru.inbox.savinov_vu.service.quiz.questionnaire.QuestionnaireService;
import ru.inbox.savinov_vu.service.quiz.survey.SurveyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


public class ItextPdfView extends AbstractITextPdfView {


    @Autowired
    DepartmentService departmentService;

    @Autowired
    GroupService groupService;

    @Autowired
    PersonService personService;

    @Autowired
    QuestionKitService questionKitService;

    @Autowired
    AnswerKitService answerKitService;

    @Autowired
    QuestionVarService questionVarService;

    @Autowired
    AnswerVarService answerVarService;

    @Autowired
    SurveyService surveyService;

    @Autowired
    QuestionnaireService questionnaireService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;


    static final String FONT_LOCATION = "/Fonts/TIMCYR_TTF/TIMCYR.TTF";

    final BaseFont timesNewRoman =
            BaseFont.createFont(
                    FONT_LOCATION,
                    BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

    final Font font14 = new Font(timesNewRoman, 14);
    final Font font11 = new Font(timesNewRoman, 11);


    final int sizeSpacingAfter = 8;


    public ItextPdfView() throws IOException, DocumentException {
    }


    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        switch ((PdfPrint) model.get("action")) {
            case Survey:
                buildSurveyPdfDocument(model, document);
                break;
            case DataBase:
                buildDataBasePdfDocument(model, document);
                break;
            default:
                throw new IllegalArgumentException();
        }


    }


    private void buildSurveyPdfDocument(Map<String, Object> model, Document document) throws DocumentException {
        Survey survey = (Survey) model.get("survey");
        Paragraph title = new Paragraph("Id Тестирования = " + survey.getId(), font14);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        Paragraph methodicals = new Paragraph("Используемая методика: " + survey.getName(), font14);
        document.add(methodicals);

        Paragraph dateParagraph = new Paragraph("Дата Тестирования: " + survey.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), font14);
        document.add(dateParagraph);

        Integer countQuestionnaires = (Integer) model.get("countQuestionnaires");
        Paragraph countQuestionnaire = new Paragraph("Количество анкет: " + countQuestionnaires, font14);
        document.add(countQuestionnaire);


        if (Objects.nonNull(survey.getDepartment())) {
            Paragraph departmentParagraph = new Paragraph("Подразделение: " + survey.getDepartment(), font14);
            document.add(departmentParagraph);
            if (Objects.nonNull(survey.getGroup())) {
                Paragraph groupParagraph = new Paragraph("Группа: " + survey.getGroup(), font14);
                document.add(groupParagraph);
            }
        }

        if (Objects.nonNull(survey.getComment()) && !"".equals(survey.getComment())) {
            Paragraph commentParagraph = new Paragraph("комментарий: " + survey.getComment(), font14);
            commentParagraph.setSpacingAfter(sizeSpacingAfter);
            document.add(commentParagraph);

        }


        Map<Question, Map<Answer, Long>> questionAnswerCountMap = (Map<Question, Map<Answer, Long>>) model.get("countAnswerByQuestionMap");

        writeQuestionAndAnswer(document, questionAnswerCountMap);
    }

    private void writeQuestionAndAnswer(Document document, Map<Question, Map<Answer, Long>> questionAnswerCountMap) throws DocumentException {
        Question savedSuperQuestion = new Question();
        for (Map.Entry<Question, Map<Answer, Long>> questionMapEntry : questionAnswerCountMap.entrySet()) {
            writeQuestion(document, savedSuperQuestion, questionMapEntry);
            for (Map.Entry<Answer, Long> answerLongEntry : questionMapEntry.getValue().entrySet()) {
                writeAnswer(document, answerLongEntry);
            }
            Paragraph emptyParagraph = new Paragraph(" ");
            emptyParagraph.setSpacingAfter(sizeSpacingAfter);
            document.add(emptyParagraph);
        }
    }

    private void writeQuestion(Document document, Question savedSuperQuestion, Map.Entry<Question, Map<Answer, Long>> questionMapEntry) throws DocumentException {
        Question question = questionMapEntry.getKey();
        AddSuperQuestion(savedSuperQuestion, question, document);
        document.add(getQuestionParagraph(question));
    }

    private Paragraph getQuestionParagraph(Question question) {
        if (Objects.isNull(question.getSuperQuestionId())) {
            return new Paragraph(question.getNumber() + ". " + question.getName(), font14);
        } else {
            return new Paragraph("     " + question.getNumber() + ". " + question.getName(), font14);
        }
    }

    private void writeAnswer(Document document, Map.Entry<Answer, Long> answerLongEntry) throws DocumentException {
        Paragraph answerParagrapg = new Paragraph("                " + answerLongEntry.getKey().getName() + " - " + answerLongEntry.getValue(), font14);
        document.add(answerParagrapg);
    }


    private void AddSuperQuestion(Question savedSuperQuestion, Question currentQuestion, Document document) throws DocumentException {

        if (Objects.nonNull(currentQuestion.getSuperQuestionId())) {
            if (!currentQuestion.getSuperQuestionId().equals(savedSuperQuestion.getId())) {
                Question byId = questionService.findOne(currentQuestion.getSuperQuestionId());
                savedSuperQuestion.setId(byId.getId()).setName(byId.getName()).setNumber(byId.getNumber());
                Paragraph questionParagraph = new Paragraph(savedSuperQuestion.getNumber() + ". " + savedSuperQuestion.getName(), font14);
                document.add(questionParagraph);
            }
        }
    }

    private void buildDataBasePdfDocument(Map<String, Object> model, Document document) throws DocumentException {
        List<String> tableNames = Arrays.asList("department", "groups", "persons", "answerkits",
                "questionkits", "answervars", "questionvars", "surveys", "questionnaires", "questions", "answers");
        Map<String, String> tableFieldsMap = initializeTableFieldsMap(tableNames);
        Map<String, ParentService> tableServiceMap = initializeTableServiceMap(tableNames);

        for (Map.Entry<String, String> pair : tableFieldsMap.entrySet()) {
            StringBuilder builder = new StringBuilder(String.format("INSERT INTO %s (%s)", pair.getKey(), pair.getValue()));
            String values = String.valueOf(tableServiceMap.get(pair.getKey()).getAll()
                    .stream().map(value -> value.toString())
                    .reduce((t, u) -> t.toString() + "," + u.toString()).orElse(";"));
            builder.append(values + ";");
            Paragraph paragraph = new Paragraph("\n" + builder.toString(), font11);
            document.add(paragraph);
        }


    }

    private Map<String, ParentService> initializeTableServiceMap(List<String> tableNames) {
        Map<String, ParentService> tableServiceMap = new LinkedHashMap<>();
        tableServiceMap.put(tableNames.get(0), departmentService);
        tableServiceMap.put(tableNames.get(1), groupService);
        tableServiceMap.put(tableNames.get(2), personService);

        tableServiceMap.put(tableNames.get(3), answerKitService);
        tableServiceMap.put(tableNames.get(4), questionKitService);
        tableServiceMap.put(tableNames.get(5), answerVarService);
        tableServiceMap.put(tableNames.get(6), questionVarService);

        tableServiceMap.put(tableNames.get(7), surveyService);
        tableServiceMap.put(tableNames.get(8), questionnaireService);
        tableServiceMap.put(tableNames.get(9), questionService);
        tableServiceMap.put(tableNames.get(10), answerService);
        return tableServiceMap;
    }

    private Map<String, String> initializeTableFieldsMap(List<String> tableNames) {
        Map<String, String> tableFieldsMap = new LinkedHashMap<>();
        tableFieldsMap.put(tableNames.get(0), "id, name");
        tableFieldsMap.put(tableNames.get(1), "id, name, department_id");
        tableFieldsMap.put(tableNames.get(2), "id, name, group_id");

        tableFieldsMap.put(tableNames.get(3), "id, name, answerType");
        tableFieldsMap.put(tableNames.get(4), "id, name");
        tableFieldsMap.put(tableNames.get(5), "id, name, answerkit_id");
        tableFieldsMap.put(tableNames.get(6), "id, number, name, superQuestionVarId, answerkit_id, questionkit_id");

        tableFieldsMap.put(tableNames.get(7), "id, name, comment, createDate, questionKitId, department, groupName");
        tableFieldsMap.put(tableNames.get(8), "id, number, createDate, survey_id");
        tableFieldsMap.put(tableNames.get(9), "id, number, name, questionVarId, superQuestionVarId, survey_id");
        tableFieldsMap.put(tableNames.get(10), "id, name, questionnaire_id, question_id");
        return tableFieldsMap;
    }


}


