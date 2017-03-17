function downloadPage() {
    sendGetQuestionKits(ajaxAPI.constructor.questionKitAll, "GET");
    sendGetAnswerKits(ajaxAPI.constructor.answerKitAll, "GET");

}

function getQuestionVarsfromQuestionKit() {
    send(ajaxAPI.constructor.questionVar + "/" + getSelectedQuestionKit().id, "GET")
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();


        var questionVar = new QuestionVar(
            $("#delId").val(), null, null, getSelectedQuestionKit()
        );

        send(ajaxAPI.constructor.questionVar, "DELETE", questionVar);
    });
});


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var questionVar = new QuestionVar(
            $('#id').val(),
            $("#name").val(),
            getSelectedAnswerKit(),
            getSelectedQuestionKit(),
            null,
            $('#number').val()
        );
        send(ajaxAPI.constructor.questionVar, "PUT", questionVar);
        document.getElementById('name').value = "";
        document.getElementById('number').value = null;
    });
});

function getSelectedAnswerKit() {

    var answerKit = new AnswerKit(
        $('#answerKits').val(),
        $('#answerKits option:selected').text()
    );
    return answerKit;
}

function getSelectedQuestionKit() {

    var questionKit = new QuestionKit(
        $('#superEntity').val(),
        $('#superEntity option:selected').text()
    );
    return questionKit;
}