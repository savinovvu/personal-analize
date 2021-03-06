function downloadPage() {
    getAll();
}

jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var department = new Department(
            $("#delId").val(), null
        );
        send(ajaxAPI.personal.department, "DELETE", department, view);
    });
});


function getAll() {
    send(ajaxAPI.personal.departmentAll, "GET", null, view);
}


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var department = new Department(
            $('#id').val(),
            $("#name").val()
        );
        send(ajaxAPI.personal.department, "PUT", department, view);
        document.getElementById('name').value = "";
    });
});



