<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>SurveyPage</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link href="/public/css/common/common.css" rel="stylesheet">
    <link href="/public/css/survey/survey.css" rel="stylesheet">
    <script type="text/javascript" src="webjars/jquery/3.1.1-1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
    <script src="/public/js/common/model/model.js" type="text/javascript"></script>
    <script src="/public/js/common/ajax/ajax.js" type="text/javascript"></script>

    <script src="/public/js/quiz/survey/service/service.js" type="text/javascript"></script>
    <script src="/public/js/quiz/survey/view/view.js" type="text/javascript"></script>
    <script src="/public/js/quiz/survey/util/util.js" type="text/javascript"></script>

</head>
<body onload=downloadPage()>
<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>
    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Главная">
    </form>
</nav>

<div class="view-box">
    <div class="menu">

        <button type="button" class="btn btn-lg btn-success custombtn " data-toggle="modal"
                data-target="#myModal" onclick="getModal()">
            Новое тестирование
        </button>


    </div>

    <table id="entityT">

        <thead>
        <tr>
            <td>id</td>
            <td>Методика</td>
            <td>Дата</td>
            <td>Количество анкет</td>
            <td>Подразделение</td>
            <td>Отдел</td>
            <td>Комментарий</td>
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
                <h4 class="modal-title text-center" id="myModalLabel">Начать новое тестирование</h4>
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
                        <label for="name" class="control-label col-xs-3">ФИО:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="name" name="name" required/>
                            </div>

                        </div>
                    </div>


                    <div class="form-group has-feedback">
                        <label for="grandSuperEntity" class="control-label col-xs-3">Подразделение:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                <select id="grandSuperEntity" class="form-control" name="department"
                                        onchange="getGroupWithDepartment()">
                                    <option disabled selected>Подразделение</option>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="form-group has-feedback">
                        <label for="superEntity" class="control-label col-xs-3">Отдел:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                <select id="superEntity" class="form-control" name="group">


                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <input id="save1" type="submit" class="btn btn-primary" value="Выполнить">
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
                <h4 class="modal-title text-center" id="myDelModalLabel">Удаление Тестирвания</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal" id="delEntity">


                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">ФИО:</label>
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
                        <input id="del1" type="submit" class="btn btn-danger" value="Удалить">
                        <input id="dismissButton" type="button" class="hidden" data-dismiss="modal">

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


</form>


</body>
</html>
