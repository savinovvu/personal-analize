

function viewGetQuestionKits(data) {
    alert("adf");
        $(".delKit").remove();
        var output = "";
        $.each(data, function (key, val) {
            output += "<option class='delKit' value='" + val.id + "'>" + val.name + "</option>";
        });
        $("#kit").append(output);
}


