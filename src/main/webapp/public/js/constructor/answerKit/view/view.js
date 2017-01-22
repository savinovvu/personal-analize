function view(data) {
    var table = $('#entityT').DataTable();
    table.destroy();

    $('#entityT').DataTable({
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

                "data": "answerType",
                "render": function (row, data, dataIndex) {
                    switch (row) {
                        case 'CHECKBOX':
                            return  '<p id="answerType-' + dataIndex.id + '">Несколько ответов</p>';
                        case 'RADIO':
                            return  '<p id="answerType-' + dataIndex.id + '">Единственный ответ</p>';
                        case 'SELECT':
                            return  '<p id="answerType-' + dataIndex.id + '">Вылетающий список</p>';
                        case 'FREE':
                            return  '<p id="answerType-' + dataIndex.id + '">Свободный ввод</p>';
                        case 'EMPTY':
                            return '<p id="answerType-' + dataIndex.id + '">Пустой</p>';
                        case 'NAME':
                            return '<p id="answerType-' + dataIndex.id + '">База имен</p>';
                    }

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
