function send(url, type, jsonData, viewFunction) {
    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (data) {
            viewFunction(data);

        },
        error: function (x) {
            alert("error");

        }

    });
    return false;
}

