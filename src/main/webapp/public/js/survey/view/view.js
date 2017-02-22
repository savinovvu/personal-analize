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
            viewAnswerCheckbox(data, question, question.prefix);
            break;
        case "RADIO":

            viewAnswerRadio(data, question, question.prefix);
            break;
        case "SELECT":
            viewAnswerSelect(data, question, question.prefix);
            break;
        case "FREE":
            viewAnswerFree(question, question.prefix);
            break;
        case "EMPTY":
            return;
        case "NAME":
            viewAnswerName(question, question.prefix);
            break;
    }
}

function viewAnswerDiv(question, prefixId) {
    var output = "<div id='answerDiv" + prefixId + question.id + "'></div>";
    $("#" + prefixId + question.id).append(output);
}


function viewAnswerCheckbox(answerVars, question, prefix) {
    $.each(answerVars, function (key, val) {
        var input = "<input type='checkbox' name='" + question.name + "' value='" + val.name + "'>";
        var output = "<div class='checkbox'><label>" + input + val.name + " </label></div>";
        $("#answerDiv" + prefix + question.id).append(output);
    });
}

function viewAnswerRadio(answerVars, question, prefix) {
    $.each(answerVars, function (key, val) {
        var input = "<input type='radio' name='" + question.name + "' value='" + val.name + "'>";
        var output = "<div class='radio'><label>" + input + val.name + " </label></div>";
        $("#answerDiv" + prefix + question.id).append(output);
    });
}

function viewAnswerSelect(answerVars, question, prefix) {
    var output = '<div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>';
    output += "<select class='form-control' name='" + question.name + "'>";

    $.each(answerVars, function (key, val) {
        output += "<option value='" + val.id + "'>" + val.name + "</option>";
    });
    output += "</select></div>";
    $("#answerDiv" + prefix + question.id).append(output);
}

function viewAnswerFree(question, prefix) {
    var input = '<span class="input-group-addon"><i class="glyphicon glyphicon-question-sign"></i></span>';
    input += '<textarea class="form-control" rows="2" name="' + question.name + '"></textarea>';
    var output = '<div><div class="input-group">' + input + '</div></div>';
    $("#answerDiv" + prefix + question.id).append(output);
}

function viewAnswerName(question, prefix) {
    var output = "<div class='input-group'>" + getInputDepartment(question.id, prefix) + "</div>";
    output += "<div class='input-group'>" + getInputGroup(question.id, prefix) + "</div>";
    output += "<div class='input-group'>" + getInputPerson(question, prefix) + "</div>";
    $("#answerDiv" + prefix + question.id).append(output);
    getDepartment(prefix + question.id);

}

function getInputDepartment(questionId, prefix) {
    var inputDepartment = '<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>';
    inputDepartment += "<select id='department" + prefix + questionId + "' onchange='getGroup(\"" + prefix + questionId + "\")' class='form-control'></select>";
    return inputDepartment;
}

function getInputGroup(questionId, prefix) {
    var inputGroup = '<span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>';
    inputGroup += "<select id='group" + prefix + questionId + "' onchange='getPerson(\"" + prefix + questionId + "\")' class='form-control'></select>";
    return inputGroup;
}

function getInputPerson(question, prefix) {

    var inputPerson = '<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>';
    var  option = "<option value='нет ответа' selected>нет ответа</option>";
    inputPerson += "<select id='person" + prefix + question.id + "' name='" + question.name + "' class='form-control'>"+option+"</select>";
    return inputPerson;
}


function viewGroupAndDepartment(data, selectId) {
    $("." + selectId).remove();
    var output = "<option value='' disabled selected>сделайте выбор</option>";
    $.each(data, function (key, val) {
        output += "<option class='" + selectId + "' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#" + selectId).append(output);
}

function viewPerson(data, selectId) {
    $("." + selectId).remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='" + selectId + "' value='" + val.name + "'>" + val.name + "</option>";
    });
    $("#" + selectId).append(output);
}










