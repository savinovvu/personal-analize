function downloadPage() {
    getAll();
    getQuestionKits();
    getDepartments();
}

function getAll() {
    send(ajaxAPI.quiz.surveyAll, "GET", null, view);

}

function getQuestionKits() {
    send(ajaxAPI.constructor.questionKitAll, "GET", null, viewQuestionKits);
}

function getDepartments() {
    send(ajaxAPI.personal.departmentAll, "GET", null, viewDepartment);
}

function getGroupWithDepartment() {
    var department = new Department(
        $('#department').val(),
        $('#department option:selected').text()
    );

    send(ajaxAPI.personal.group + "/" + department.id, "GET", null, viewGroupWithDepartment);

}