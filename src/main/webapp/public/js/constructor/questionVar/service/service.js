function downloadPage() {
    sendGetQuestionKits("/constructor/questionKit/all", "GET");

}

function getQuestionVarsfromQuestionKit() {
    send("/constructor/questionVar/" + getSelectedAnswerKit().id, "GET")
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();


        var answerVar = new AnswerVar(
            $("#delId").val(), null, getSelectedAnswerKit()
        );


        send("/constructor/answerVar", "DELETE", answerVar);
    });
});


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var answerVar = new AnswerVar(
            $('#id').val(),
            $("#name").val(),
            getSelectedAnswerKit()
        );

        send("/constructor/answerVar", "PUT", answerVar);
        document.getElementById('name').value = "";
    });
});

function getSelectedAnswerKit() {

    var answerKit = new AnswerKit(
        $('#superEntity').val(),
        $('#superEntity option:selected').text()
    );
    return answerKit;
}