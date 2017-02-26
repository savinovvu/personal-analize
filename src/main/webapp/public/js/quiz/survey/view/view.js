function view(data) {
    var table = $('#entityT').DataTable();
    table.destroy();

    $('#entityT').DataTable({
        "data": data,
        "columns": [
            {"data": "id"},
            {
                "data": "questionKit",
                "render": function (row, data, dataIndex) {
                    var output = '<label for="form-' + dataIndex.id + '" id="name-' + dataIndex.id + '">' + row.name + '</label>';
                    output += '<form class="hidden"  action="quiz/pdf/' + id + '" method="get">';
                    output += '<input id="form-' + dataIndex.id + '" type="submit">';
                    output += '<form>';
                    return output;
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
                    return '<p id="count-' + dataIndex.id + '">' + row + '</p>';

                }
            },

            {
                "data": "department",
                "render": function (row, data, dataIndex) {
                    if (row === null) {
                        return null;
                    }
                    if (dataIndex.group === null) {
                        return '<p id="department-' + dataIndex.id + '">' + row.name + '</p>';
                    }
                    return '<p id="department-' + dataIndex.id + '">' + row.name + '</p>' +
                        '<p id="group-' + dataIndex.id + '">' + dataIndex.group.name+ '</p>';

                }
            },


            {
                "data": "comment",
                "render": function (row, data, dataIndex) {
                    return '<p id="name-' + dataIndex.id + '">' + row + '</p>';

                }
            },

            {
                "defaultContent": "",
                "orderable": false,
                "render": function (row, data, dataIndex) {


                    return '<a class="btn btn-xs btn-primary cuctombtnwithoutshadow" onclick="getModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myModal">Продолжить</a>' +
                        '<a  class="btn btn-xs btn-info cuctombtnwithoutshadow" onclick="getDelModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myDelModal">PDF</a>' +
                        '<a  class="btn btn-xs btn-danger cuctombtnwithoutshadow" onclick="getDelModal(' + dataIndex.id + ')" data-toggle="modal" data-target="#myDelModal">Удалить</a>';

                }
            },
        ]
    });

}