function downloadPage() {
     send("/constructor/questionKit/all", "GET", null, viewGetQuestionKits);
}



function getQuestionVarsfromQuestionKit() {
    send("/constructor/questionVar/" + getSelectedQuestionKit().id, "GET", null, )
}



function getSelectedQuestionKit() {

    var questionKit = new QuestionKit(
        $('#superEntity').val(),
        $('#superEntity option:selected').text()
    );
    return questionKit;
}