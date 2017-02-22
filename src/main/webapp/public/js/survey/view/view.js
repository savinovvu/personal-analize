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


function viewAnswer(data, question) {

    viewAnswerDiv(question, question.prefix);
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
            viewAnswerName(question.id, question.prefix);
            break;
    }
}

function viewAnswerDiv(question, prefixId) {
    var output = "<div id='answerDiv" + prefixId + question.id + "'></div>";
    $("#" + prefixId + question.id).append(output);
}


function viewAnswerCheckbox(answerVars, questionId, prefix) {
    $.each(answerVars, function (key, val) {
        var input = "<input type='checkbox' name='" + questionId + "' value='" + val.name + "'>";
        var output = "<div class='checkbox'><label>" + input + val.name + " </label></div>";
        $("#answerDiv" + prefix + questionId).append(output);
    });
}

function viewAnswerRadio(answerVars, questionId, prefix) {
    $.each(answerVars, function (key, val) {
        var input = "<input type='radio' name='" + questionId + "' value='" + val.name + "'>";
        var output = "<div class='radio'><label>" + input + val.name + " </label></div>";
        $("#answerDiv" + prefix + questionId).append(output);
    });
}

function viewAnswerSelect(answerVars, questionId, prefix) {
    var output = '<div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>';
    output += "<select class='form-control' name='" + questionId + "'>";

    $.each(answerVars, function (key, val) {
        output += "<option value='" + val.id + "'>" + val.name + "</option>";
    });
    output += "</select></div>";
    $("#answerDiv" + prefix + questionId).append(output);
}

function viewAnswerFree(questionId, prefix) {
    var input = '<span class="input-group-addon"><i class="glyphicon glyphicon-question-sign"></i></span>';
    input += '<textarea class="form-control" rows="2" name="' + questionId + '"></textarea>';
    var output = '<div><div class="input-group">' + input + '</div></div>';
    $("#answerDiv" + prefix + questionId).append(output);
}

function viewAnswerName(questionId, prefix) {
    var output = "<div class='input-group'>" + getInputDepartment(questionId, prefix) + "</div>";
    output += "<div class='input-group'>" + getInputGroup(questionId, prefix) + "</div>";
    output += "<div class='input-group'>" + getInputPerson(questionId, prefix) + "</div>";
    $("#answerDiv" + prefix + questionId).append(output);
    getDepartment(prefix + questionId);

}

function getInputDepartment(questionId, prefix) {
    var inputDepartment = '<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>';
    var  option = "<option value='нет ответа' selected>сделайте выбор</option>";
    inputDepartment += "<select id='department" + prefix + questionId + "' onchange='getGroup(\"" + prefix + questionId + "\")' class='form-control'>"+option+"</select>";
    return inputDepartment;
}

function getInputGroup(questionId, prefix) {
    var inputGroup = '<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>';
    var  option = "<option value='нет ответа' selected>сделайте выбор</option>";
    inputGroup += "<select id='group" + prefix + questionId + "' onchange='getPerson(\"" + prefix + questionId + "\")' class='form-control'>"+option+"</select>";
    return inputGroup;
}

function getInputPerson(questionId, prefix) {

    var inputPerson = '<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>';
    var  option = "<option value='нет ответа' selected>сделайте выбор</option>";
    inputPerson += "<select id='person" + prefix + questionId + "' name='" + questionId + "' class='form-control'>"+option+"</select>";
    return inputPerson;
}


function viewOption(data, selectId) {
    $("." + selectId).remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='" + selectId + "' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#" + selectId).append(output);
}









