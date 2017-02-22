function downloadPage() {
    send(ajaxAPI.constructor.questionKitAll, "GET", null, viewQuestionKit);
}


function getQuestionVarsWithQuestionKit() {
    send(ajaxAPI.constructor.questionVar + "/" + getSelectedQuestionKit().id, "GET", null, viewQuestionVar);
}

function getQuestionSubsWithQuestionVar(id) {
    send(ajaxAPI.constructor.questionSub + "/" + id, "GET", null, viewQuestionSub);
}

function getSelectedQuestionKit() {

    var questionKit = new QuestionKit(
        $('#kit').val(),
        $('#kit option:selected').text()
    );
    return questionKit;
}


function getAnswer(question) {
    send(ajaxAPI.constructor.answerVar + "/" + question.answerKit.id, "GET", null, viewAnswer, question);
}

function getDepartment(department) {
    send(ajaxAPI.personal.departmentAll, "GET", null, viewGroupAndDepartment, "department" + department);
}



function getGroup(question) {
    var department = new Department(
        $('#department'+question).val(),
        $('#department'+question +' option:selected').text()
    );
    send(ajaxAPI.personal.group + "/"+ department.id , "GET", null, viewGroupAndDepartment, "group" + question);
}

function getPerson(question) {
    var group = new Group(
        $('#group'+question).val(),
        $('#group'+question +' option:selected').text()
    );
    send(ajaxAPI.personal.person + "/"+ group.id , "GET", null, viewPerson, "person" + question);
}

jQuery(function ($) {
    $('#surveyForm').submit(function (e) {
        e.preventDefault();
        alert(JSON.stringify($('#surveyForm').serializeArray()));

    });
});


