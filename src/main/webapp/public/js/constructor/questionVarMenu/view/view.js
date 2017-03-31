function view(data) {
    var table = $('#entityT').DataTable();
    table.destroy();

    $('#entityT').DataTable({
        "data": data,
        "columns": [
            {
                "data": "number",
                "render": function (row, data, dataIndex) {
                    return "<p id='number-" + dataIndex.id + "'>"+row+"</p>" +
                        "<p class='hidden' id='superQuestionVarId-"+dataIndex.id+"'>"+dataIndex.questionVar+"</p>";
                }
            },

            {
                "data": "name",
                "render": function (row, data, dataIndex) {
                    var output = '<label class="btn btn-link" for="form-' + dataIndex.id + '" id="name-' + dataIndex.id + '">' + dataIndex.name + '</label>';
                    output += '<form class="hidden"  action="questionSubMenu" method="get">';
                    output += '<input name="id" value="' + dataIndex.id + '">';
                    output += '<input name="name" value="' + row + '">';
                    output += '<input name="questionKitId" value="' + dataIndex.questionKit.id + '">';
                    output += '<input id="form-' + dataIndex.id + '" type="submit">';
                    output += '<form>';
                    return output;
                }
            },

            {
                "data": "answerKit",
                "render": function (row, data, dataIndex) {
                    return '<label  class="btn btn-link" for="nameAnswerKitSubmit-' + dataIndex.id + '" id="nameAnswerKit-' + dataIndex.id + '">' + row.name + '</label>' +
                        '<form class="hidden" method="get" action="answerVarMenu">' +
                        '<input type="text" name="id" id="answerKitId-' + dataIndex.id + '" value="' + row.id + '">' +
                        '<input type="text" name="questionKitId" value="' + dataIndex.questionKit.id+ '">' +
                        '<input type="submit" id="nameAnswerKitSubmit-' + dataIndex.id + '">' +
                        '</form>' + convertAnswerTypeToText(row.answerType, dataIndex);

                }
            },


            {
                "defaultContent": "",
                "orderable": false,
                "render": function (row, data, dataIndex) {


                    return '<a class="btn btn-xs btn-primary" onclick="getUpdateModal(' + dataIndex.id + ',' + dataIndex.number + ')" data-toggle="modal" data-target="#myUpdateModal">Обновить</a>' +
                        '<a  class="btn btn-xs btn-danger" onclick="getDelModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myDelModal">Удалить</a>';
                }
            },
        ]
    });

}


