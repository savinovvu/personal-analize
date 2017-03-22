function viewSurvey(data) {
    getQuestionVarsWithQuestionKit(data.questionKitId);
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
        var questionVarId = data[0].questionVar;
        var subQuestionListId = "subQuestionList-" + questionVarId;
        $("#" + subQuestionListId).remove();
        $("#question-" + data[0].questionVar).append("<ol id='" + subQuestionListId + "'></ol>");
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
    var input = "<input type='checkbox' onclick='deleteFlashVariants(\"checkboxVar\"+" + question.id + "," + question.id + ")'  name='" + question.id + "' value='нет ответа' class='checkboxNoVar" + question.id + " myCheckbox" + question.id + "' checked>";

    var output = "<div class='checkbox'><label>" + input + "Нет ответа</label></div>";
    $.each(answerVars, function (key, val) {
        input = "<input type='checkbox' onclick='deleteFlashVariants(\"checkboxNoVar\"+" + question.id + "," + question.id + ")' class='checkboxVar" + question.id + " myCheckbox" + question.id + "' name='" + question.id + "' value='" + val.name + "'>";
        output += "<div class='checkbox'><label>" + input + val.name + " </label></div>";
    });
    $("#answerDiv" + prefix + question.id).append(output);
}


function viewAnswerRadio(answerVars, question, prefix) {
    var input = "<input type='radio' name='" + question.id + "' value='нет ответа' checked>";
    var output = "<div class='radio'><label>" + input + "Нет ответа</label></div>";
    $.each(answerVars, function (key, val) {
        input = "<input type='radio' name='" + question.id + "' value='" + val.name + "'>";
        output += "<div class='radio'><label>" + input + val.name + " </label></div>";
    });
    $("#answerDiv" + prefix + question.id).append(output);
}


function viewAnswerSelect(answerVars, question, prefix) {
    var output = '<div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>';
    output += "<select class='form-control' name='" + question.id + "'>";
    output += "<option value='нет ответа'>Нет ответа</option>";
    $.each(answerVars, function (key, val) {
        output += "<option value='" + val.name + "'>" + val.name + "</option>";
    });
    output += "</select></div>";
    $("#answerDiv" + prefix + question.id).append(output);
}

function viewAnswerFree(question, prefix) {
    var input = '<span class="input-group-addon"><i class="glyphicon glyphicon-question-sign"></i></span>';
    input += '<textarea class="form-control" id="textArea-' + question.id + '" rows="2" name="' + question.id + '" onfocus="deleteNoAnswer(\'textArea-' + question.id + '\')" onblur="getNoAnswer(\'textArea-' + question.id + '\')" >Нет ответа</textarea>';
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
    var option = "<option value='нет ответа' selected>нет ответа</option>";
    inputPerson += "<select id='person" + prefix + question.id + "' name='" + question.id + "' class='form-control'>" + option + "</select>";
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

function viewQuestionnaireCount(data) {
    $("#delNumberQuestionnaire").remove();
    $("#numberOfQuestionnaire").append("<span id=delNumberQuestionnaire>" + (data + 1) + "<\/span>");
}










