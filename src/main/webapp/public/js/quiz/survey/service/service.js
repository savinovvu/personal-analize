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
       Number($('#department').children(':selected').attr('id')),
        $('#department option:selected').text()
    );

    send(ajaxAPI.personal.group + "/" + department.id, "GET", null, viewGroupWithDepartment);
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var survey = new Survey(
            $("#delId").val()
        );
        send(ajaxAPI.quiz.survey, "DELETE", survey, view);
    });
});