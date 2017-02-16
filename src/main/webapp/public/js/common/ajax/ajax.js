var ajaxAPI = {

    "constructor": {
        "answerKit": "/constructor/answerKit",
        "answerKitAll": "/constructor/answerKit/all",
        "answerVar": "/constructor/answerVar",
        "questionKit": "/constructor/questionKit",
        "questionKitAll": "/constructor/questionKit/all",
        "questionVar": "/constructor/questionVar",
        "questionSub": "/constructor/questionSub",
    },
    "personal": {
        "department": "/personal/department",
        "departmentAll": "/personal/department/all",
        "group": "/personal/group",
        "groupAll": "/personal/group/all",
        "person": "/personal/person",
        "personAll": "/personal/person/all"
    }


};


function send(url, type, jsonData, viewFunction, additionData) {
    $.ajax({

        url: url,
        type: type,
        contentType: 'application/json',
        data: JSON.stringify(jsonData),
        success: function (data) {

            viewFunction(data, additionData);

        },
        error: function (x) {
            alert("error");

        }

    });
    return false;
}

function sendSynch(url, type, jsonData, viewFunction) {
 return  $.ajax({

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

    }).responseText;
}