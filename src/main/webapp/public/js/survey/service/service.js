function downloadPage() {
     send(ajaxAPI.constructor.questionKitAll, "GET", null, viewQuestionKits);
}



function getQuestionVarsfromQuestionKit() {
    send(ajaxAPI.constructor.questionVar +"/" + getSelectedQuestionKit().id, "GET", null, viewSurvey )
}



function getSelectedQuestionKit() {

    var questionKit = new QuestionKit(
        $('#kit').val(),
        $('#kit option:selected').text()
    );
    return questionKit;
}