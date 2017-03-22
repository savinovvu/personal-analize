function view(data) {


    // alert(JSON.stringify(data));
    var table = $('#entityT').DataTable();
    table.destroy();

    $('#entityT').DataTable({
        "data": data,
        "columns": [

            {
                "data": "id",
                "render": function (row, data, dataIndex) {
                    return '<p   id="id-' + dataIndex.id + '">' + row + '</p>';


                }
            },


            {
                "data": "question",
                "render": function (row, data, dataIndex) {
                    var output = "";
                    var superQuestion = "";

                    if (row.superQuestionId != null) {
                        var superQuestion = JSON.parse(sendSynch( ajaxAPI.quiz.question + "/" + row.superQuestionId, "GET", null, getData));

                        superQuestion = superQuestion.name;
                    }
                    output += '<p id="question-' + dataIndex.id + '">'+superQuestion + ' <br> ' + row.name + '</p>';
                    return output;

                }
            },


            {
                "data": "name",
                "render": function (row, data, dataIndex) {
                    return '<p id="answer-' + dataIndex.id + '">' + row + '</p>';

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
        ],
        //   "order": [[2, "desc"]]
    });

}

function getData(data) {

    return data;
}