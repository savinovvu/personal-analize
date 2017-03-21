function downloadPage(id) {
    getAllQuestionnairesWithSurveyId(id);
}

function getAllQuestionnairesWithSurveyId(id){
    send(ajaxAPI.quiz.questionnaire + "/" + id, "GET", null, view);
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var survey = new Survey($("#surveyId").text());
        var quesitonnaire = new Questionnaire(
            $("#delId").val(), null, null, survey
        );

        send(ajaxAPI.quiz.questionnaire, "DELETE", quesitonnaire, view);
    });
});