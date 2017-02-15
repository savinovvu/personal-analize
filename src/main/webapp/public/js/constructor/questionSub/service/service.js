var questionVarId;

function downloadPage(id) {
    send(ajaxAPI.constructor.answerKitAll, "GET", null, viewGetAnswerKits);
    getQuestionSubsWithQuestionVar(id);
    questionVarId = id;
}

function getQuestionSubsWithQuestionVar(id) {
    send(ajaxAPI.constructor.questionSub + "/" + id, "GET", null, view);
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var question = new QuestionSub($("#delId").val(), null, null, getQuestionVar());
        send(ajaxAPI.constructor.questionSub, "DELETE", question, view);
    });
});


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var questionSub = new QuestionSub(
            $('#id').val(),
            $("#name").val(),
            getSelectedAnswerKit(),
            getQuestionVar()
        );
        send(ajaxAPI.constructor.questionSub, "PUT", questionSub, view);
        document.getElementById('name').value = "";
    });
});

function getSelectedAnswerKit() {
    var answerKit = new AnswerKit(
        $('#answerKits').val(),
        $('#answerKits option:selected').text()
    );
    return answerKit;
}

function getQuestionVar() {
    var questionVar = new QuestionVar(questionVarId);
    return questionVar;
}

