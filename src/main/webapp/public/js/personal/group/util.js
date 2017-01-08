
function getModal(id) {
    document.getElementById('groupId').value = id;
    document.getElementById('name').value = "";
}

function getDelModal(id, name) {
    document.getElementById('groupDelId').value = id;
    document.getElementById('delName').value = ($('#name-'+id).text());
}




