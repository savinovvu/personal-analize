function getDelModal(id) {
    document.getElementById('delId').value = id;
    document.getElementById('delAnswer').value = ($('#answer-' + id).text());
    document.getElementById('delQuestion').value = ($('#question-' + id).text());
}