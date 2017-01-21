function downloadPage() {
    getAll();
}

function getAll() {
    send("/constructor/questionKit/all", "GET");
}

jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var questionKit = new QuestionKit(
            $("#delId").val(), null
        );
        send("/constructor/questionKit", "DELETE", questionKit);
    });
});


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var questionKit = new QuestionKit(
            $('#id').val(),
            $("#name").val()
        );

        alert(JSON.stringify(questionKit));
        send("/constructor/questionKit", "PUT", questionKit);
        document.getElementById('name').value = "";
    });
});