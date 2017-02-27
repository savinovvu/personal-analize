function downloadPage() {
    getAll();
    getQuestionKits();
    getDepartments();
}

function getAll() {
    send(ajaxAPI.quiz.surveyAll, "GET", null, view);

}

function getQuestionKits() {
    send(ajaxAPI.constructor.questionKitAll, "GET", null, viewQuestionKits)
}

function getDepartments() {
    send(ajaxAPI.constructor.questionKitAll, "GET", null, viewDepartment())
}