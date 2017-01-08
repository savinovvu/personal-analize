function downloadPage() {
    getAll();
}

function delDepartment(id) {
    var department = new Department(
        $("#departmentDelId").val(),null
    );
    send("/personal/department", "DELETE", department);
}


function getAll() {
    send("/personal/department/all", "GET");
}


function putDepartment() {
    var department = new Department(
        Number($('#departmentId').val()),
        $("#name").val()
    );
    send("/personal/department", "PUT", department);
}


function send(url, type, jsonData) {

    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (data) {

            view(data);

        },
        error: function (x) {
            //  alert("error");

        }

    });
    return false;
}


function view(data) {

    $('#departmentT').DataTable({
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







