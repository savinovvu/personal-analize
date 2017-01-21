function downloadPage() {
    getAll();
}

function getAll() {
    send("/constructor/answerKit/all", "GET");
}

jQuery(function ($) {
    $("#delEntity").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var questionKit = new QuestionKit(
            $("#delId").val(), null
        );
        send("/constructor/answerKit", "DELETE", questionKit);
    });
});


jQuery(function ($) {
    $("#putEntity").submit(function (e) {
        e.preventDefault();

        var questionKit = new QuestionKit(
            $('#id').val(),
            $("#name").val()
        );
        send("/constructor/answerKit", "PUT", questionKit);
        document.getElementById('name').value = "";
    });
});