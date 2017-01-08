
function getModal(id) {
    document.getElementById('personId').value = id;
    document.getElementById('name').value = "";
}

function getDelModal(id, name) {
    document.getElementById('personDelId').value = id;
    document.getElementById('delName').value = ($('#name-'+id).text());
}




