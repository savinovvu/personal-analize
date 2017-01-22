function send(url, type, jsonData, getJsonData) {

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

function sendGetAnswerKits(url, type, jsonData) {
    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (data) {

            viewGetAnswerKits(data);

        },
        error: function (x) {
            alert("error");

        }

    });
    return false;
}