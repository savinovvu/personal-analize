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

function getGroupWithDepartment(id) {
    var department = new Department(
       Number($('#' + id).children(':selected').attr('id')),
        $('#'+id+' option:selected').text()
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

jQuery(function ($) {
    $("#updateEntity").submit(function (e) {
        e.preventDefault();

        $("#updateDismissButton").click();
        var id = $("#idUpdate").val();
        var department = $("#departmentUpdate").val() === "noChange"? $("#department-" +id).text():  $("#departmentUpdate").val();
        var group =  $("#groupUpdate").val() === "noChange"? $("#group-" +id).text():  $("#groupUpdate").val();
        department = "" === department ? null: department;
        group = "" == group || department === null ? null : group;


        var survey = new Survey(
            id,
            $("#nameUpdate").val(),
            $("#dateUpdate").val(),
            department,
            group,
            $("#commentUpdate").val(),
            $("#questionKitIdUpdate").val()
        );
        send(ajaxAPI.quiz.survey, "PUT", survey, view);
    });
});



