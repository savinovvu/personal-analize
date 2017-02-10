function downloadPage() {
    getAll();
    getDepartment();
}


jQuery(function ($) {
    $("#delGroup").submit(function (e) {
        e.preventDefault();
        $("#dismissButton").click();
        var group = new Group($("#groupDelId").val(), null, new Department(null, null));
        send("/personal/group", "DELETE", group, view);

    });
});

function getDepartment() {
    sendGetDepartment("/personal/department/all", "GET", null, view);
}

function getAll() {
    send("/personal/group/all", "GET", null, view);
}


jQuery(function ($) {
    $("#putGroup").submit(function (e) {
        e.preventDefault();
        var department = new Department(
            $('#department').val(),
            $('#department option:selected').text());

        var group = new Group(
            $("#groupId").val(),
            $("#name").val(),
            department
        );
        send("/personal/group", "PUT", group, view);
        document.getElementById('name').value = "";
    });
});


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
              alert("error");

        }

    });
    return false;
}


function sendGetDepartment(url, type, jsonData) {

    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (data) {
            viewDepartment(data);

        },
        error: function (x) {
               alert("error");

        }

    });
    return false;
}


function view(data) {
    var table = $('#groupT').DataTable();
    table.destroy();

    $('#groupT').DataTable({
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
                "data": "department",
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

    $(".delDepartment").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delDepartment' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#department").append(output);

}











