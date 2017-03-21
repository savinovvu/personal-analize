function view(data) {

    var table = $('#entityT').DataTable();
    table.destroy();

    $('#entityT').DataTable({
        "data": data,
        "columns": [

            {
                "data": "number",
                "render": function (row, data, dataIndex) {
                    return '<p id="id-' + dataIndex.id + '">' + row + '</p>' +
                        '<p  class="hidden" id="questionKitId-' + dataIndex.id + '">' + dataIndex.questionKitId + '</p>' +
                         '<p id="id-' + dataIndex.id + '" class="hidden">' + dataIndex.id + '</p>';

                }
            },


            {
                "data": "createDate",
                "render": function (row, data, dataIndex) {
                    return '<p id="date-' + dataIndex.id + '">' + row + '</p>';

                }
            },


            {
                "defaultContent": "",
                "orderable": false,
                "render": function (row, data, dataIndex) {

                    return '<a  class="btn btn-xs btn-danger cuctombtnwithoutshadow" onclick="getDelModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myDelModal">Удалить</a>' +
                        '<form method="get" action="continueQuiz"><input class="hidden" name="id" value="' + dataIndex.id + '"> <input type="submit" class="hidden" id="continue-' + dataIndex.id + '"></form>' +
                        '<form method="get" action="/pdf/quiz/survey/' + dataIndex.id + '.pdf"><input type="submit" id="pdf-' + dataIndex.id + '" class="hidden"></form> ';

                }
            },
        ]
    });

}


