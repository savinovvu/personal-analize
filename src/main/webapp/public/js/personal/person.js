function mydownloadTable() {
    alert("hahahaah");

    $('personT').DataTable({
        "bServerSide": true,
        "ajax": {
            "url": "/personal/person/all",
            "contentType": "application/json",
            "type": "GET",
            "data": function (d) {
                alert("данные получены");
                return JSON.stringify(d);
            }
        }

        ,
        "sAjaxSource": "data.json",
        "sAjaxDataProp": "",
        "bPaginate": false,
        "bInfo": false,
        "aoColumns": [
            {
                "mData": "id"
            },
            {
                "mData": "name"
            }


        ]
    });
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

/*
 function renderEditBtn(data, type, row) {
 if (type == 'display') {
 return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ');">'+i18n['common.update']+'</a>';
 }
 }

 function renderDeleteBtn(data, type, row) {
 if (type == 'display') {
 return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ');">'+i18n['common.delete']+'</a>';
 }
 }*/

function view(data) {
    alert("во вьюхе");

    $('#personT').DataTable({
        "data": data,
        "columns": [
            {"data": "id"},
            {"data": "name"},

            {
                "defaultContent": "",
                "orderable": false,
                "render": function (row, data, dataIndex) {
                    return '<a class="btn btn-xs btn-primary  " ">Обновить</a>' +
                        '<a class="btn btn-xs btn-danger  " ">Удалить</a>'
                }
            },

           /* {
                "defaultContent": "",
                "orderable": false,
                "render": function (row, data, dataIndex) {
                    return  '<a class="btn btn-xs btn-danger" ">Удалить</a>'
                }

             }*/
        ]
    });

    /* $(".data").remove();
     $.each(data, function (key, val) {

     var output = "";

     output = "<tr class='data'>" +
     "<form id=\"form-" + val.id + "\">";

     output += "<td>";
     output += "<input type=\"text\"  name=\"id\" id=\"id-" + val.id + "\" value=\"" + val.id + "\" readonly />";
     output += "</td>";

     output += "<td>";
     output += "<input type=\"text\"  name=\"userName\" id=\"userName-" + val.id + "\" value=\"" + val.userName + "\"  readonly/>";
     output += "</td>";

     output += "<td>";
     output += "<input type=\"text\"  name=\"roles\" id=\"roles-" + val.id + "\" value=\"" + val.roles + "\"  readonly/>";
     output += "</td>";


     if (val.active == true) {
     output += "<td>" +
     "<input type=\"button\" value=\"Запретить\" class=\"btn btn-danger\" onclick=\"changeActive(" + val.id + " , false)\">" +
     "</td>";
     }

     if (val.active == false) {
     output += "<td>" +
     "<input type=\"button\" value=\"Разрешить\" class=\"btn btn-success\" onclick=\"changeActive(" + val.id + ", true)\">" +
     "</td>";
     }



     output += '<td>' +
     '<button type="button" class="btn btn-success" onclick="addBlockAndNullName(' + val.id + ')"  data-toggle="modal"  data-target="#myModal"' +
     '>Обновить</button>' +
     '</td>';

     output += "</form> " +
     "</tr>";

     $("#userT").append(output);


     });*/


}
