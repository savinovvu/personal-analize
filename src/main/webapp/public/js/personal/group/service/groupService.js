function downloadPage() {
    getAll();
    getDepartment();
}


jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var group = new Group($("#delId").val(), null, new Department(null, null));
        send(ajaxAPI.personal.group, "DELETE", group, view);

    });
});

function getDepartment() {
    send(ajaxAPI.personal.departmentAll, "GET", null, viewDepartment);
}

function getAll() {
    send(ajaxAPI.personal.groupAll, "GET", null, view);
}


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();
        var department = new Department(
            $('#superEntity').val(),
            $('#superEntity option:selected').text());

        var group = new Group(
            $("#id").val(),
            $("#name").val(),
            department
        );
        send(ajaxAPI.personal.group, "PUT", group, view);
        document.getElementById('name').value = "";
    });
});