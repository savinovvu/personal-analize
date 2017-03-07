function downloadPage(id) {
    send(ajaxAPI.quiz.survey + "/" + id, "GET", null, viewSurvey);
}


function getQuestionVarsWithQuestionKit(id) {
    send(ajaxAPI.constructor.questionVar + "/" + id, "GET", null, viewQuestionVar);
}

function getQuestionSubsWithQuestionVar(id) {
      send(ajaxAPI.constructor.questionSub + "/" + id, "GET", null, viewQuestionSub);
}


function getAnswer(question) {
    send(ajaxAPI.constructor.answerVar + "/" + question.answerKit.id, "GET", null, viewAnswer, question);
}

function getDepartment(department) {
    send(ajaxAPI.personal.departmentAll, "GET", null, viewGroupAndDepartment, "department" + department);
}


function getGroup(question) {
    var department = new Department(
        $('#department' + question).val(),
        $('#department' + question + ' option:selected').text()
    );
    send(ajaxAPI.personal.group + "/" + department.id, "GET", null, viewGroupAndDepartment, "group" + question);
}

function getPerson(question) {
    var group = new Group(
        $('#group' + question).val(),
        $('#group' + question + ' option:selected').text()
    );
    send(ajaxAPI.personal.person + "/" + group.id, "GET", null, viewPerson, "person" + question);
}

jQuery(function ($) {
    $('#surveyForm').submit(function (e) {
        e.preventDefault();
        var data = $('#surveyForm').serializeArray();
        data = JSON.stringify(getAnswerList(data));
        send(ajaxAPI.quiz.answer, "PUT", data, viewMessage )
    });
});


