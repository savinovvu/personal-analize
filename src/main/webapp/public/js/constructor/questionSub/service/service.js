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
        var question = new QuestionVar($("#delId").val(), null, null, null, questionVarId);
        send(ajaxAPI.constructor.questionSub, "DELETE", question, view);
    });
});


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var question = new QuestionVar(
            $('#id').val(),
            $("#name").val(),
            getSelectedAnswerKit(),
            null,
            questionVarId
        );
        send(ajaxAPI.constructor.questionSub, "PUT", question, view);
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



