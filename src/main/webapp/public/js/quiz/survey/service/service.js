function downloadPage() {
    getAll();
}

function getAll() {
    send(ajaxAPI.quiz.surveyAll, "GET", null, view);

}