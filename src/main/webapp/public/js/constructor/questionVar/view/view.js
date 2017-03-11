function view(data) {
    var table = $('#entityT').DataTable();
    table.destroy();

    $('#entityT').DataTable({
        "data": data,
        "columns": [
            {"data": "number"},
            {
                "data": "name",
                "render": function (row, data, dataIndex) {
                    var output = '<label class="btn btn-link" for="form-' + dataIndex.id + '" id="name-' + dataIndex.id + '">' + dataIndex.name + '</label>';
                    output += '<form class="hidden"  action="/editQuestionSub" method="get">';
                    output += '<input name="id" value="' + dataIndex.id + '">';
                    output += '<input id="form-' + dataIndex.id + '" type="submit">';
                    output += '<form>';
                    return output;
                }
            },

            {
                "data": "answerKit",
                "render": function (row, data, dataIndex) {
                    return '<p id="name-' + dataIndex.id + '">' + row.name + '</p>';

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

function viewGetQuestionKits(data) {

    $(".delSuperEntity").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delSuperEntity' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#superEntity").append(output);

}

function viewGetAnswerKits(data) {

    $(".delAnswerKits").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delAnswerKits' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#answerKits").append(output);

}
