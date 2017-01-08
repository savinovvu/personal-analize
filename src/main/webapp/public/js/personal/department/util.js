
function getModal(id) {
    document.getElementById('departmentId').value = id;
    document.getElementById('name').value = "";
}

function getDelModal(id, name) {
    document.getElementById('departmentDelId').value = id;
    document.getElementById('delName').value = ($('#name-'+id).text());
}




