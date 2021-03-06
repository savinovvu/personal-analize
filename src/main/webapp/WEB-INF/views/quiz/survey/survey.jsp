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
    <script type="text/javascript" src="webjars/jquery/3.1.1-1/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js" defer></script>
    <script src="/public/js/common/model/model.js" type="text/javascript" defer></script>
    <script src="/public/js/common/ajax/ajax.js" type="text/javascript" defer></script>
    <script src="/public/js/common/view/view.js" type="text/javascript" defer></script>

    <script src="/public/js/quiz/survey/service/service.js" type="text/javascript" defer></script>
    <script src="/public/js/quiz/survey/view/view.js" type="text/javascript" defer></script>
    <script src="/public/js/quiz/survey/util/util.js" type="text/javascript" defer></script>

</head>
<body onload=downloadPage()>
<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>
    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Главная">
    </form>
</nav>

<div class="view-box menu2">
    <div class="menu">

        <button type="button" class="btn btn-lg btn-success custombtn " data-toggle="modal"
                data-target="#myModal" onclick="getModal(0)">
            Новое тестирование
        </button>


    </div>

    <table id="entityT" class="table table-bordered table-stripped table-condensed">

        <thead>
        <tr class="success">
            <td style="width:5%;">id</td>
            <td style="width:20%;">Методика</td>
            <td style="width:20%;">Дата</td>
            <td style="width:5%;">Заполнено</td>
            <td style="width:20%;">Подразделение</td>
            <td style="width:40%;">Комментарий</td>
            <td style="width:20%;">Действие</td>
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
                <form role="form" class="form-horizontal" method="get" action="newQuiz">

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
                        <label for="questionKit" class="control-label col-xs-3"> Методика:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                <select id="questionKit" name="questionKit" class="form-control" required>
                                </select>
                            </div>

                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="questionKit" class="control-label col-xs-3"> Дата:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                <input type="date" name="createDate" class="form-control">
                            </div>

                        </div>
                    </div>


                    <div class="form-group has-feedback">
                        <label for="department" class="control-label col-xs-3">Подразделение:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                                <select id="department" class="form-control getDepartment" name="department"
                                        onchange="getGroupWithDepartment('department')">
                                    <option value="" selected>Не выбрано</option>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="form-group has-feedback">
                        <label for="group" class="control-label col-xs-3">Отдел:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                                <select id="group" class="form-control getGroup" name="group">
                                    <option value="" selected>Не выбран</option>

                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="comment" class="control-label col-xs-3">Комментарий:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                <textarea name="comment" rows="10" class="form-control" id="comment"></textarea>

                            </div>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <input id="save1" type="submit" class="btn btn-primary" value="Начать">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
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
                <h4 class="modal-title text-center" id="myDelModalLabel">Удаление Тестирования</h4>
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
                        <label for="delName" class="control-label col-xs-3">Методика:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
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

<%--update modal window--%>
<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myUpdateModalLabel">Обновить информацию</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal" id="updateEntity">

                    <div class="form-group has-feedback">
                        <label for="delName" class="control-label col-xs-3">Id:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="text" class="form-control" id="idUpdate" name="id" readonly required>
                            </div>

                        </div>
                    </div>

                    <div class="form-group has-feedback hidden">
                        <label for="delName" class="control-label col-xs-3">questionKitId:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="text" class="form-control" id="questionKitIdUpdate" name="questionKitId"
                                       readonly required>
                            </div>

                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="delName" class="control-label col-xs-3">Методика:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="text" class="form-control" id="nameUpdate" name="name" readonly required/>
                            </div>

                        </div>
                    </div>


                    <div class="form-group has-feedback">
                        <label for="questionKit" class="control-label col-xs-3"> Дата:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                <input type="date" id="dateUpdate" name="createDate" class="form-control">
                            </div>

                        </div>
                    </div>


                    <div class="form-group has-feedback">
                        <label for="department" class="control-label col-xs-3">Подразделение:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                                <select id="departmentUpdate" class="form-control getDepartment" name="department"
                                        onchange="getGroupWithDepartment('departmentUpdate')">
                                    <option value="noChange"   selected>Не менять</option>
                                    <option value="" >Не выбрано</option>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="form-group has-feedback">
                        <label for="group" class="control-label col-xs-3">Отдел:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                                <select id="groupUpdate" class="form-control getGroup" name="group">
                                    <option value="noChange" class="delGroup2"selected>Не менять</option>
                                    <option value="">Не выбран</option>

                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <label for="comment" class="control-label col-xs-3">Комментарий:</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                                <textarea name="comment" rows="10" class="form-control" id="commentUpdate"></textarea>

                            </div>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <input id="update" type="submit" class="btn btn-primary" value="Обновить">
                        <button type="button" id="updateDismissButton" class="btn btn-primary" data-dismiss="modal">
                            Отмена
                        </button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>


</body>
</html>
