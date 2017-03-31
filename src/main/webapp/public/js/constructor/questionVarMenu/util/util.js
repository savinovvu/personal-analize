
function getUpdateModal(id) {
    document.getElementById('idUpdate').value = id;
    document.getElementById('superQuestionVarIdUpdate').value = $('#superQuestionVarId-' + id).text();
    document.getElementById('nameUpdate').value = $('#name-' + id).text();
    document.getElementById('numberUpdate').value = $('#number-' + id).text();
    document.getElementById('answerKitIdUpdate').value = $('#answerKitId-' + id).val();

}

