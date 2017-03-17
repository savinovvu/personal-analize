function downloadPage() {
    getAll();
    getDepartment();
}

jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var person = new Person($("#delId").val(), null, new Group(null, null));
        send(ajaxAPI.personal.person, "DELETE", person, view);

    });
});

function getDepartment() {
    send(ajaxAPI.personal.departmentAll, "GET", null, viewDepartment);
}


function getGroupWithDepartment() {
    var department = new Department(
        $('#grandSuperEntity').val(),
        $('#grandSuperEntity option:selected').text()
    );


    send(ajaxAPI.personal.group + "/" + department.id, "GET", null, viewGroup);
}


function getAll() {
    send(ajaxAPI.personal.personAll, "GET", null, view);
}


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var group = new Group(
            $('#superEntity').val(),
            $('#superEntity option:selected').text());

        var person = new Person(
            $("#id").val(),
            $("#name").val(),
            group
        );
        send(ajaxAPI.personal.person, "PUT", person, view);
        document.getElementById('name').value = "";
    });
});