function downloadPage(id) {

    getQuestionVarsfromQuestionKit(id);
}

function getQuestionVarsfromQuestionKit(id) {

    send(ajaxAPI.constructor.questionVar + "/" + id, "GET", null, view)
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();


        var questionVar = new QuestionVar(
            $("#delId").val(), null, null, getSelectedQuestionKit()
        );

        send(ajaxAPI.constructor.questionVar, "DELETE", questionVar, view);
    });
});


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();
        var id = $('#idUpdate').val();

        var questionVar = new QuestionVar(
            id,
            $("#nameUpdate").val(),
            getSelectedAnswerKit(),
            getSelectedQuestionKit(),
            $("#superQuestionVarIdUpdate").val(),
            $('#numberUpdate').val()
        );
        send(ajaxAPI.constructor.questionVar, "PUT", questionVar, view);
    });
});



function getSelectedAnswerKit() {
    return new AnswerKit($("#answerKitIdUpdate").val());
}

function getSelectedQuestionKit() {
   return new QuestionKit($('#questionKit_idUpdate').val());
}