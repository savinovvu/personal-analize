function getDelModal(id) {
    document.getElementById('delId').value = id;
    document.getElementById('delAnswer').value = $('#answer-' + id).text();
    document.getElementById('delQuestion').value = $('#question-' + id).text();
}

function getModal(id) {
    document.getElementById('id').value = id;
    document.getElementById('answer').value = $('#answer-' + id).text();
    document.getElementById('question').value = $('#question-' + id).text();
    document.getElementById('questionId').value = $('#questionId-' + id).text();

}