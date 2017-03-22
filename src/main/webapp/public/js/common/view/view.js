function getModal(id, number) {
    document.getElementById('id').value = id;
    document.getElementById('name').value = "";

    if (typeof  number !== "undefined") {
        document.getElementById('number').value = number;
    } else {
        document.getElementById('number').value = null;
    }


}

function getDelModal(id) {
    document.getElementById('delId').value = id;
    document.getElementById('delName').value = $('#name-' + id).text();
    document.getElementById('delNumber').value = $('#number-' + id).text();
}