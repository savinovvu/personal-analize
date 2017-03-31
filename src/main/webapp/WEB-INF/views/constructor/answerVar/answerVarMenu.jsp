<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>UserManage</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link href="/public/css/common/common.css" rel="stylesheet">
    <script type="text/javascript" src="webjars/jquery/3.1.1-1/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js" defer></script>
    <script src="/public/js/common/model/model.js" type="text/javascript" defer></script>

    <script src="/public/js/common/ajax/ajax.js" type="text/javascript" defer></script>
    <script src="/public/js/common/util/util.js" type="text/javascript" defer></script>
    <script src="/public/js/common/view/view.js" type="text/javascript" defer></script>

    <script src="/public/js/constructor/answerVarMenu/service/service.js" type="text/javascript" defer></script>
    <script src="/public/js/constructor/answerVarMenu/ajax/ajax.js" type="text/javascript" defer></script>
    <script src="/public/js/constructor/answerVarMenu/view/view.js" type="text/javascript" defer></script>

</head>


<body onload="downloadPage(${answerKit_id})">
<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>

    <label class="btn btn-info mynav icon-prev" for="navQuestionKit"><i
            class="glyphicon glyphicon-lock label-info"></i>&nbsp
        Методики</label>

    <label class="btn btn-info mynav icon-prev" for="navQuestionVar"><i
            class="glyphicon glyphicon-question-sign label-info"></i>&nbsp
        Вопросы</label>

    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Главная">
    </form>

    <form action="editQuestionKit" method="get">
        <input id="navQuestionKit" class="hidden" type="submit" name="viewAllUsers" value="Методики">
    </form>

    <form class="hidden" action="questionVarMenu" method="get">
        <input type="text" name="id" value="${questionKit_id}">
        <input id="navQuestionVar"  type="submit" name="viewAllUsers" value="Вопросы">
    </form>

</nav>

<div class="view-box">
    <div class="menu">
        <h4><span id="answerKit_name">${answerKit_name}</span></h4>
        <p class="hidden" id="answerKit_id">${answerKit_id}</p>


        <label for="answerView" class="control-label col-xs-3">Тип ответов:</label>
        <div class="col-xs-6">
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <select id="answerView" class="form-control" onchange="updateAnswerType()">
                    <option  selected disabled>не менять</option>
                    <option value="CHECKBOX">Несколько ответов</option>
                    <option value="RADIO">Единственный ответ</option>
                    <option value="SELECT">Вылетающий список</option>
                    <option value="FREE">Свободный ввод</option>
                    <option value="EMPTY">Пустой</option>
                    <option value="NAME">База имен</option>
                </select>
            </div>

        </div>


        <button type="button" class="btn btn-lg btn-success custombtn" data-toggle="modal"
                data-target="#myModal" onclick="getModal()"><i class="glyphicon glyphicon-plus label-info "></i>&nbsp
            Добавить ответ в набор
        </button>


    </div>

    <table id="entityT" class="table table-bordered table-stripped table-condensed">

        <thead>
        <tr class="success">
            <td>id</td>
            <td>Вариант ответа</td>
            <td>Действие</td>
        </tr>
        </thead>
    </table>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myModalLabel">Добавление/Обновление ответа</h4>
            </div>
            <div class="modal-body">

                <form role="form" class="form-horizontal" id="putEntity">

                    <div class="changeDivId">
                        <div class="form-group has-feedback" id="divId">
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <input type="hidden" class="form-control" id="id" name="id" required>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">Наименование:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="name" name="name" required/>
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
                        <label for="name" class="control-label col-xs-3">Наименование:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="hidden" class="form-control" id="delId" name="id" readonly required>
                                <input type="text" class="form-control" id="delName" name="name" readonly required/>
                            </div>

                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
                        <input type="submit" class="btn btn-danger" value="Удалить">
                        <input id="dismissButton" type="button" class="hidden" data-dismiss="modal">

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>
