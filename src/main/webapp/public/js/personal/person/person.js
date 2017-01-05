
function getGroupData(){
    alert("показываю");
}

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


function putUser() {
    var data = {};
    data["id"] = $("#personId").val();
    data["name"] = $("#name").val();
    data["group"] = $("#group").val();
    alert("data: " + data);

    send("/personal/person", "PUT", data);
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
                    return row.name;
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
    output = "";

    $(".hidden").remove();
    $.each(data, function (key, val) {
        output += "<input type='text' class='delGroupId' value='" + val.id + "'disabled>";
    });
    $("#hiddenGroupDiv").append(output);


}





