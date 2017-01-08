function downloadPage() {
    getAll();
}

function delDepartment() {
    var person = new Person(Number($("#personDelId").val()),null,new Group(null, null));
    send("/personal/department", "DELETE", person);

}


function getAll() {
    send("/personal/department/all", "GET");
}


function putDepartment() {
    var department = new Department(
        Number($('#departmentId').val()),
        $("#name").val()
    );
   /* var group = new Group(
        Number($('#group').val()),
        $('#group option:selected').text());

    var person = new Person(
        Number($("#personId").val()),
        $("#name").val(),
        group
    );*/
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







