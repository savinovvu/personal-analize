function view(data) {
    var table = $('#entityT').DataTable();
    table.destroy();

    $('#entityT').DataTable({
        "data": data,
        "columns": [
            {"data": "id"},

            {
                "data": "name",
                "render": function (row, data, dataIndex) {


                    return '<p id="name-' + dataIndex.id + '">' + dataIndex.name + '</p>';

                }
            },


            {
                "defaultContent": "",
                "orderable": false,
                "render": function (row, data, dataIndex) {


                    return '<a class="btn btn-xs btn-primary" onclick="getModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myModal">Обновить</a>' +
                        '<a  class="btn btn-xs btn-danger" onclick="getDelModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myDelModal">Удалить</a>';
                }
            },
        ]
    });

}

function getModal(id) {
    document.getElementById('id').value = id;
    document.getElementById('name').value = "";
}

function getDelModal(id, name) {
    document.getElementById('delId').value = id;
    document.getElementById('delName').value = ($('#name-'+id).text());
}