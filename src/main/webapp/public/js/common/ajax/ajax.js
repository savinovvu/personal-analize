

var ajaxAPI = {

    "constructor" : {
        "answerKit": "/constructor/answerKit",
        "answerKitAll": "/constructor/answerKit/all",
        "answerVar": "/constructor/answerVar",
        "questionKit": "/constructor/questionKit",
        "questionKitAll": "/constructor/questionKit/all",
        "questionVar": "/constructor/questionVar"
    },
    "personal": {
        "department" : "/personal/department",
        "departmentAll": "/personal/department/all",
        "group": "/personal/group",
        "groupAll": "/personal/group/all",
        "person": "/personal/person",
        "personAll": "/personal/person/all",
    }




};



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