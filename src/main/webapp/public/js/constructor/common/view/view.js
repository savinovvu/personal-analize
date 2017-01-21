function getModal(id) {
    document.getElementById('id').value = id;
    document.getElementById('name').value = "";
}

function getDelModal(id, name) {
    document.getElementById('delId').value = id;
    document.getElementById('delName').value = ($('#name-'+id).text());
}