function downloadPage(id) {
    getAnswerVarsfromAnswerKit(id)
}

function getAnswerVarsfromAnswerKit(id) {
    send("/constructor/answerVar/" + id, "GET", null, view)
}

function updateAnswerType() {
    var answerType = $('#answerView').val();
    var answerKit = new AnswerKit(
        $('#answerKit_id').text(),
        $('#answerKit_name').text(),
        answerType
    );
    send(ajaxAPI.constructor.answerKit, "PUT", answerKit, successUpdateAnswerKit);
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();


        var answerVar = new AnswerVar(
            $("#delId").val(), null, getSelectedAnswerKit()
        );
        send("/constructor/answerVar", "DELETE", answerVar, view);
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
        send("/constructor/answerVar", "PUT", answerVar, view);
        document.getElementById('name').value = "";
    });
});

function getSelectedAnswerKit() {
    return new AnswerKit($('#answerKit_id').text());
}

