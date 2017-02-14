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
                "data": "group",
                "render": function (row, data, dataIndex) {
                    return row.department.name;
                }
            },


            {
                "data": "group",
                "render": function (row, data, dataIndex) {
                    return row.name;
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

function viewDepartment(data) {

    $(".delGrandSuperEntity").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delGrandSuperEntity' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#grandSuperEntity").append(output);

}

function viewGroup(data) {
    $(".delSuperEntity").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delSuperEntity' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#superEntity").append(output);
}


function getModal(id) {
    document.getElementById('id').value = id;
    document.getElementById('name').value = "";
}

function getDelModal(id, name) {
    document.getElementById('delId').value = id;
    document.getElementById('delName').value = ($('#name-' + id).text());
}


