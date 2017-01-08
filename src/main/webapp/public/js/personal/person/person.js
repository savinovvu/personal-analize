function downloadPage() {
    getAll();
    getGroup();
}

function delPerson() {
    var person = new Person(Number($("#personDelId").val()),null,new Group(null, null));
    send("/personal/person", "DELETE", person);

}

function getGroup() {
    sendGetGroup("/personal/group/all", "GET");
}

function getAll() {
    send("/personal/person/all", "GET");
}


function putPerson() {
    var group = new Group(
        Number($('#group').val()),
        $('#group option:selected').text());

    var person = new Person(
        Number($("#personId").val()),
        $("#name").val(),
        group
    );

    send("/personal/person", "PUT", person);
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
         //   alert("error");

        }

    });
    return false;
}


function view(data) {

    $('#personT').DataTable({
        "data": data,
        "columns": [
            {"data": "id"},
            {
                "data": "name",
                "render": function (row, data, dataIndex) {
return                         '<p id="name-' + dataIndex.id + '">' + dataIndex.name + '</p>';

                }
            },

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
                        '<a  class="btn btn-xs btn-danger" onclick="getDelModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myDelModal">Удалить</a>';


                }
            },
        ]
    });

}

function viewGroup(data) {
    $(".delGroup").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delGroup' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#group").append(output);

}





