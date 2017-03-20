function view(data) {
    var table = $('#entityT').DataTable();
    table.destroy();

    $('#entityT').DataTable({
        "data": data,
        "columns": [
            {
                "data": "id",
                "render": function (row, data, dataIndex) {
                    return '<p id="id-' + dataIndex.id + '">' + row + '</p>' +
                        '<p  class="hidden" id="questionKitId-' + dataIndex.id + '">' + dataIndex.questionKitId + '</p>';

                }
            },

            {
                "data": "name",
                "render": function (row, data, dataIndex) {
                    return '<p id="name-' + dataIndex.id + '">' + row + '</p>';
                }
            },

            {
                "data": "createDate",
                "render": function (row, data, dataIndex) {
                    return '<p id="date-' + dataIndex.id + '">' + row + '</p>';

                }
            },

            {
                "data": "count",
                "render": function (row, data, dataIndex) {
                    var output = '<label class="btn btn-link" for="form-' + dataIndex.id + '" id="count-' + dataIndex.id + '">' + row + '</label>';

                    output += '<form class="hidden"  action="questionnaireMenu/' + dataIndex.id + '" method="get">';
                    output += '<input id="form-' + dataIndex.id + '" type="submit">';
                    output += '<form>';
                    return output;

                }
            },

            {
                "data": "department",
                "render": function (row, data, dataIndex) {
                    if (row === null) {
                        return null;
                    }
                    if (dataIndex.group === null) {
                        return '<p id="department-' + dataIndex.id + '">' + row + '</p>';
                    }
                    return '<p id="department-' + dataIndex.id + '">' + row + '</p>' +
                        '<p id="group-' + dataIndex.id + '">' + dataIndex.group + '</p>';

                }
            },


            {
                "data": "comment",
                "render": function (row, data, dataIndex) {
                    return '<p id="comment-' + dataIndex.id + '">' + row + '</p>';

                }
            },

            {
                "defaultContent": "",
                "orderable": false,
                "render": function (row, data, dataIndex) {

                    return '<label for="continue-' + dataIndex.id + '" class="btn btn-xs btn-primary cuctombtnwithoutshadow">Продолжить</label>' +
                        '<label for="pdf-' + dataIndex.id + '" class="btn btn-xs btn-info cuctombtnwithoutshadow" >PDF</label>' +
                        '<a   class="btn btn-xs btn-warning cuctombtnwithoutshadow" onclick="getUpdateModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myUpdateModal">Обновить данные</a>' +
                        '<a  class="btn btn-xs btn-danger cuctombtnwithoutshadow" onclick="getDelModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myDelModal">Удалить</a>' +
                        '<form method="get" action="continueQuiz"><input class="hidden" name="id" value="' + dataIndex.id + '"> <input type="submit" class="hidden" id="continue-' + dataIndex.id + '"></form>' +
                        '<form method="get" action="/pdf/quiz/survey/' + dataIndex.id + '.pdf"><input type="submit" id="pdf-' + dataIndex.id + '" class="hidden"></form> ';

                }
            },
        ]
    });

}

function viewQuestionKits(data) {
    $(".delquestionKit").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delquestionKit' value='" + val.id + "'>" + val.name + "</option>";
    });
    $("#questionKit").append(output);
}

function viewDepartment(data) {
    $(".delDepartment").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delDepartment' id='" + val.id + "' value='" + val.name + "'>" + val.name + "</option>";
    });
    $(".getDepartment").append(output);

}

function viewGroupWithDepartment(data) {
    $(".delGroup").remove();
    var output = "";
    $.each(data, function (key, val) {
        output += "<option class='delGroup' value='" + val.name + "'>" + val.name + "</option>";
    });
    $(".getGroup").append(output);
}