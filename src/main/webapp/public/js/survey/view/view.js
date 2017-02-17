function viewQuestionKit(data) {
    $(".delKit").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delKit' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#kit").append(output);
}

function viewQuestionVar(data) {
    $(".delQuestion").remove();
    $.each(data, function (key, val) {
        var output = "";
        output += "<li id='question-" + val.id + "' class='delQuestion'>";
        output += val.name;
        output += "</li>";
        $("#questionList").append(output);
        getQuestionSubsWithQuestionVar(val.id);
        val.prefix = "question-";
        getAnswer(val);

    });


}

function viewQuestionSub(data) {
    if (data.length > 0) {
        var prefix = "subQuestion-";
        var questionVarId = data[0].questionVar.id;
        var subQuestionListId = "subQuestionList-" + questionVarId;
        $("#" + subQuestionListId).remove();
        $("#question-" + data[0].questionVar.id).append("<ol id='" + subQuestionListId + "'></ol>");
        $.each(data, function (key, val) {
            var output = "";
            output += "<li id='subQuestion-" + val.id + "' class='delSubQuestion'>";
            output += val.name;
            output += "</li>";
            $("#" + subQuestionListId).append(output);
            val.prefix = prefix;
            getAnswer(val);

        });
    }
}


var i = 0;
function viewAnswer(data, question) {

    viewForm(question, question.prefix);
    switch (question.answerKit.answerType) {
        case "CHECKBOX" :
            viewAnswerCheckbox(data, question.id, question.prefix);
            break;
        case "RADIO":

            viewAnswerRadio(data, question.id, question.prefix);
            break;
        case "SELECT":
            viewAnswerSelect(data, question.id, question.prefix);
            break;
        case "FREE":
            viewAnswerFree(question.id, question.prefix);
            break;
        case "EMPTY":
            return;
        case "NAME":
            viewAnswerName(data, question.id, question.prefix);
            break;
    }
}

function viewForm(question, prefixId) {
    var output = "<form id='form" + prefixId + question.id + "'></form>";
    $("#" + prefixId + question.id).append(output);
}


function viewAnswerCheckbox(answerVars, questionId, prefix) {
    $.each(answerVars, function (key, val) {
        var input = "<input type='checkbox' name='" + questionId + "' value='" + val.name + "'>";
        var output = "<div class='checkbox'><label>" + input + val.name + " </label></div>";
        $("#form" + prefix + questionId).append(output);
    });
}

function viewAnswerRadio(answerVars, questionId, prefix) {
    $.each(answerVars, function (key, val) {
        var input = "<input type='radio' name='" + questionId + "' value='" + val.name + "'>";
        var output = "<div class='radio'><label>" + input + val.name + " </label></div>";
        $("#form" + prefix + questionId).append(output);
    });
}
function viewAnswerSelect(answerVars, questionId, prefix) {


}

function viewAnswerFree(questionId, prefix) {
    var input = '<textarea class="form-control" rows="2" name="' + questionId + '"></textarea>';
    var output = '<div><div class="form-group">' + input + '</div></div>';
    $("#form" + prefix + questionId).append(output);
}

function viewAnswerName(answerVars, questionId, prefix) {

}





