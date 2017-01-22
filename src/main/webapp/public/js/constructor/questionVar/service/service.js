function downloadPage() {
    sendGetQuestionKits("/constructor/questionKit/all", "GET");
    sendGetAnswerKits("/constructor/answerKit/all", "GET");

}

function getQuestionVarsfromQuestionKit() {
    send("/constructor/questionVar/" + getSelectedQuestionKit().id, "GET")
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();


        var questionVar = new QuestionVar(
            $("#delId").val(), null, null, getSelectedQuestionKit()
        );

        send("/constructor/questionVar", "DELETE", questionVar);
    });
});


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var questionVar = new QuestionVar(
            $('#id').val(),
            $("#name").val(),
            getSelectedAnswerKit(),
            getSelectedQuestionKit()
        );

        send("/constructor/questionVar", "PUT", questionVar);
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

function getSelectedQuestionKit() {

    var questionKit = new QuestionKit(
        $('#superEntity').val(),
        $('#superEntity option:selected').text()
    );
    return questionKit;
}