function downloadPage() {
    getAll();
    getGroup()
}

function getGroup() {
    sendGetGroup("/personal/group/all", "GET");
}

function getAll() {
    send("/personal/person/all", "GET");
}


function putUser(id) {
    var data = {};
    if (id > 0) {
        data["id"] = id;
    } else {
        data["id"] = $("#userId").val();
    }

    data["userName"] = $("#name").val();
    data["roles"] = $("#roles").val();
    data["active"] = $("#active").val();
    send("/users", "PUT", data);
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
            alert("error");

        }

    });
    return false;
}

function sendGetGroup(url, type, jsonData) {

    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (data) {

            viewGroup(data);

        },
        error: function (x) {
            alert("error");

        }

    });
    return false;
}


function view(data) {

    $('#personT').DataTable({
        "data": data,
        "columns": [
            {"data": "id"},
            {"data": "name"},
            {
                "data": "group",
                "render": function (row, data, dataIndex) {
                    //
                    return dataIndex.id;
                }
            },

            {
                "defaultContent": "",
                "orderable": false,
                "render": function (row, data, dataIndex) {

                    return '<a class="btn btn-xs btn-primary" onclick="getModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myModal">Обновить</a>' +
                        '<a class="btn btn-xs btn-danger">Удалить</a>'
                }
            },
        ]
    });

}

function viewGroup(data) {

    $(".delGroup").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delGroup' value='" + val.name + "'>" + val.name + "</option>";
    });
    $("#groups").append(output);

}





