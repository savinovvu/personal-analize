


    function downloadPage() {
        getAll();
        getDepartment();
    }

        jQuery(function ($) {
            $("#delPerson").submit(function (e) {
                e.preventDefault();
                $("#dismissButton").click();
                var person = new Person($("#personDelId").val(), null, new Group(null, null));
                send("/personal/person", "DELETE", person);

            });
        });

    function getDepartment() {

        sendGetDepartment("/personal/department/all", "GET");

    }


    function getGroupWithDepartment() {
        var department = new Department(
            $('#department').val(),
            $('#department option:selected').text()
        );

        sendGetGroup("/personal/group/department", "POST", department);
    }


    function getAll() {
        send("/personal/person/all", "GET");
    }


     jQuery(function ($) {
         $("#putPerson").submit(function (e) {
             e.preventDefault();

             var group = new Group(
                 $('#group').val(),
                 $('#group option:selected').text());

             var person = new Person(
                 $("#personId").val(),
                 $("#name").val(),
                 group
             );
             send("/personal/person", "PUT", person);
             document.getElementById('name').value = "";
         });
     });



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

    function sendGetDepartment(url, type, jsonData) {

        $.ajax({

            url: url,
            type: type,
            contentType: 'application/json',
            data: JSON.stringify(jsonData),
            success: function (data) {

                viewDepartment(data);

            },
            error: function (x) {
                   alert("error");

            }

        });
        return false;
    }


    function view(data) {
        var table = $('#personT').DataTable();
        table.destroy();

        $('#personT').DataTable({
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
                    "data": "group",
                    "render": function (row, data, dataIndex) {
                        return row.name;
                    }
                },

                {
                    "data": "group",
                    "render": function (row, data, dataIndex) {
                        return row.department.name;
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

    function viewDepartment(data) {

        $(".delDepartment").remove();
        var output = "";
        $.each(data, function (key, val) {
            output += "<option class='delDepartment' value='" + val.id + "'>" + val.name + "</option>";
        });
        $("#department").append(output);

    }

    function viewGroup(data) {
        $(".delGroup").remove();
        var output = "";
        $.each(data, function (key, val) {
            output += "<option class='delGroup' value='" + val.id + "'>" + val.name + "</option>";
        });
        $("#group").append(output);
    }




