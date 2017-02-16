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
        $("#"+ subQuestionListId).remove();
        $("#question-" + data[0].questionVar.id).append("<ol id='"+subQuestionListId+"'></ol>");
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

/*    CHECKBOX, RADIO, SELECT , FREE, EMPTY, NAME*/
var i = 0;
function viewAnswer(/*data,*/ question, prefixId) {
 /*   if(i == 0){
        i++
        alert(JSON.stringify(data));
    }*/
 var data = null;

    viewForm(question, prefixId);
    switch (question.answerKit.answerType) {
        case "CHECKBOX" :
            viewAnswerCheckbox(data, question.id, prefixId);
            break;
        case "RADIO":
            viewAnswerRadio(data, question.id, prefixId);
            break;
        case "SELECT":
            viewAnswerSelect(data, question.id, prefixId);
            break;
        case "FREE":
            viewAnswerFree(data, question.id, prefixId);
            break;
        case "EMPTY":
            viewAnswerEmpty(data, question.id, prefixId);
            break;
        case "NAME":
            viewAnswerName(data, question.id, prefixId);
            break;
    }
}

function viewForm(question, prefixId) {
    var output = "<form id='form"+prefixId+ question.id +"'></form>";
    $("#"+prefixId + question.id).append(output);
}




