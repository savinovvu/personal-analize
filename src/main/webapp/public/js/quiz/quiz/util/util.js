function deleteFlashVariants(checkBoxClass) {
    $("." + checkBoxClass).prop("checked", false);
}

function viewMessage(data, id) {
    alert(data);
    getNumberOfQuestionnaire(id);
}

function getAnswerList(formData) {
    var survey_id = formData[0].value;
    formData.splice(0, 1);
    var survey = new Survey(survey_id);
    var questionnaire = new Questionnaire(null, null, null, survey);
    var answerList = [];
    $.each(formData, function (key, val) {
        var question = new Question(null, null, null, val.name);
        var answer = new Answer(null, val.value, question, questionnaire);
        answerList.push(answer);
    });
    return answerList;

}


function deleteNoAnswer(id) {
    if (document.getElementById(id).value === "Нет ответа") {
        document.getElementById(id).value = '';
    }
}

function getNoAnswer(id) {
    if (document.getElementById(id).value === "") {
        document.getElementById(id).value = 'Нет ответа';
    }
}
