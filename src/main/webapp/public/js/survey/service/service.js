function downloadPage() {
    send(ajaxAPI.constructor.questionKitAll, "GET", null, viewQuestionKit);
}


function getQuestionVarsWithQuestionKit() {
    send(ajaxAPI.constructor.questionVar + "/" + getSelectedQuestionKit().id, "GET", null, viewQuestionVar);
}

function getQuestionSubsWithQuestionVar(id) {
    send(ajaxAPI.constructor.questionSub + "/" + id, "GET", null, viewQuestionSub);
}

function getSelectedQuestionKit() {

    var questionKit = new QuestionKit(
        $('#kit').val(),
        $('#kit option:selected').text()
    );
    return questionKit;
}


function getAnswer(question) {
    send(ajaxAPI.constructor.answerVar + "/" +question.answerKit.id, "GET", null, viewAnswer, question);
}
