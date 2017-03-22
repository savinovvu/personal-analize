<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Меню анкет</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link href="/public/css/common/common.css" rel="stylesheet">
    <link href="/public/css/survey/survey.css" rel="stylesheet">
    <script type="text/javascript" src="webjars/jquery/3.1.1-1/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js" defer></script>
    <script src="/public/js/common/model/model.js" type="text/javascript" defer></script>
    <script src="/public/js/common/ajax/ajax.js" type="text/javascript" defer></script>
    <script src="/public/js/common/view/view.js" type="text/javascript" defer></script>

    <script src="/public/js/quiz/answerAndQuestions/service/service.js" type="text/javascript" defer></script>
    <script src="/public/js/quiz/answerAndQuestions/view/view.js" type="text/javascript" defer></script>
    <script src="/public/js/quiz/answerAndQuestions/util/util.js" type="text/javascript" defer></script>
</head>

<body onload=downloadPage(${questionnaireId})>

<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>

    <label class="btn btn-info mynav" for="survey"><i class="glyphicon glyphicon-list label-info "></i>&nbsp
        Тестирование</label>

    <label class="btn btn-info mynav" for="questionnaires"><i class="glyphicon glyphicon-list label-info "></i>&nbsp
        Список анкет</label>

    <label class="btn btn-info mynav" for="continueQuiz"><i class="glyphicon glyphicon-list label-info "></i>&nbsp
        Продолжить</label>

    <label class="btn btn-info mynav" for="pdf"><i class="glyphicon glyphicon-list label-info "></i>&nbsp
        PDF</label>

    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Главная">
    </form>

    <form action="conductSurvey" method="get">
        <input id="survey" class="hidden" type="submit" name="viewAllUsers">
    </form>

    <form class="hidden" action="questionnaire" method="get">'
        <input id="questionnaires" type="submit">
        <input name="id" value="${surveyId}" type="text">
    </form>

    <form action="continueQuiz" method="get">
        <input id="continueQuiz" class="hidden" type="submit" name="viewAllUsers">
        <input type="hidden" name="id" value="${surveyId}">
    </form>

    <form method="get" action="/pdf/quiz/survey/${surveyId}.pdf">
        <input type="submit" id="pdf" class="hidden">
    </form>


</nav>
<p style="font-size: 20px"> Тестирование № <span id="surveyId">${surveyId}</span>, методика: ${surveyName}, Дата начала
    тестирования: ${surveyDate} </p>
<p style="font-size: 20px"> Анкета №<span id="questionnaireNumber">${questionnaireNumber}</span>, Дата заполнения
    анкеты: ${questionnaireDate} </p> <span class="hidden" id="questionnaireId">${questionnaireId}</span>

<div class="view-box menu2">
    <table id="entityT" class="table table-bordered table-stripped table-condensed">

        <thead>
        <tr class="success">

            <td>id</td>
            <td>Вопрос</td>
            <td>Ответ</td>
            <td style="width: 10%">Действие</td>
        </tr>
        </thead>
    </table>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myModalLabel">Обновление ответа</h4>
            </div>
            <div class="modal-body">

                <form role="form" class="form-horizontal" id="putEntity">

                    <div class="form-group has-feedback">
                        <label for="delId" class="control-label col-xs-3">Id:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="text" class="form-control" id="id" name="id" readonly required>
                            </div>

                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="question" class="control-label col-xs-3">Вопрос:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="text" class="form-control" id="question" name="question" readonly required/>
                                <input class="hidden" type="text" class="form-control" id="questionId" name="questionId" readonly required/>
                            </div>

                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="answer" class="control-label col-xs-3">Ответ:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="answer" name="name"  required />
                            </div>

                        </div>
                    </div>


                    <div class="modal-footer">
                        <input id="save" type="submit" class="btn btn-primary" value="Выполнить">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Завершить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>




<div class="modal fade" id="myDelModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myDelModalLabel">Удаление ответа</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal" id="delEntity">


                    <div class="form-group has-feedback">
                        <label for="delId" class="control-label col-xs-3">Id:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="text" class="form-control" id="delId" name="id" readonly required>
                            </div>

                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="delQuestion" class="control-label col-xs-3">Вопрос:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="text" class="form-control" id="delQuestion" name="name" readonly required/>
                            </div>

                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="delAnswer" class="control-label col-xs-3">Ответ:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="text" class="form-control" id="delAnswer" name="name" readonly required/>
                            </div>

                        </div>
                    </div>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
                        <input id="del1" type="submit" class="btn btn-danger" value="Удалить">
                        <input id="dismissButton" type="button" class="hidden" data-dismiss="modal">

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
