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
                    return '<label class="btn btn-link" for="questionVarMenu-' + dataIndex.id + '" id="name-' + dataIndex.id + '">' + dataIndex.name + '</label>' +
                        '<form class="hidden" action="questionVarMenu" method="get"><input type="submit" id="questionVarMenu-' + dataIndex.id + '">' +
                        '<input type="text" name="id" value="' + dataIndex.id + '"></form>';
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
