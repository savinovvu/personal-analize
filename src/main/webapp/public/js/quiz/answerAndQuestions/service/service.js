function downloadPage(id) {
    getAllAnswerWithQuestionnaireId(id);
}


function getAllAnswerWithQuestionnaireId(id) {
send(ajaxAPI.quiz.answer + "/" + id, "GET", null, view);
}

jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var questionnaire = new Questionnaire($("#questionnaireId").text());
        var answer = new Answer($("#delId").val(),null,null, questionnaire);

     send(ajaxAPI.quiz.answer, "DELETE", answer, view);
    });
});

jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var questionnaire = new Questionnaire($("#questionnaireId").text());
        var question = new Question($("#questionId").val());
        var answer = new Answer($("#id").val(),$("#answer").val(),question, questionnaire);
        send(ajaxAPI.quiz.answer, "POST", answer, view);
    });
});