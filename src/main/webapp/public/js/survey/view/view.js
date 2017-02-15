function viewQuestionKits(data) {
    $(".delKit").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delKit' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#kit").append(output);
}

function viewSurvey(data) {
    $(".delQuestion").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<li class='delQuestion'>";
        output += val.name;
        output += "</li>";
    });
    $("#questionList").append(output);

}


