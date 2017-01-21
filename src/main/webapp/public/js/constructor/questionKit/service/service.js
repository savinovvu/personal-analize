function downloadPage() {
    getAll();
}

function getAll() {
    send("/constructor/questionKit/all", "GET");
}

jQuery(function ($) {
    $("#delDepartment").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var department = new Department(
            $("#delId").val(), null
        );
        send("/personal/department", "DELETE", department);
    });
});


jQuery(function ($) {
    $("#putDepartment").submit(function (e) {
        e.preventDefault();

        var department = new Department(
            Number($('#id').val()),
            $("#name").val()
        );
        send("/personal/department", "PUT", department);
        document.getElementById('name').value = "";
    });
});