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
    <script src="/public/js/common/service/service.js" type="text/javascript" defer></script>
    <script src="/public/js/common/view/view.js" type="text/javascript" defer></script>

    <script src="/public/js/constructor/questionSubMenu/service/service.js" type="text/javascript" defer></script>
    <script src="/public/js/constructor/questionSubMenu/util/util.js" type="text/javascript" defer></script>
    <script src="/public/js/constructor/questionSubMenu/view/view.js" type="text/javascript" defer></script>
</head>

<body onload="downloadPage(${question_id})">
<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>

    <label class="btn btn-info mynav icon-prev" for="navQuestionKit"><i
            class="glyphicon glyphicon-lock label-info"></i>&nbsp
        Методики</label>


    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Главная">
    </form>

    <form action="editQuestionKit" method="get">
        <input id="navQuestionKit" class="hidden" type="submit" name="viewAllUsers" value="методики">
    </form>

</nav>


<div class="view-box">
    <div class="menu">

        <h4>список подвопросов для : <span id="questionKit_name">${question_name}</span></h4>
        <p class="hidden" id="questionKit_id">${questionKit_id}</p>

        <button type="button" class="btn btn-lg btn-success custombtn" data-toggle="modal"
                data-target="#myModal" onclick="getModal()"><i class="glyphicon glyphicon-plus label-info "></i>&nbsp
            Добавить подвопрос к анкете
        </button>


    </div>

    <table id="entityT" class="table table-bordered table-stripped table-condensed">

        <thead>
        <tr class="success">
            <td>№</td>
            <td>вопрос</td>
            <td>Набор ответов</td>
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
                <h4 class="modal-title text-center" id="myModalLabel">Добавление</h4>
            </div>
            <div class="modal-body">

                <form role="form" class="form-horizontal" action="newAnswerKit" method="get">

                    <div class="changeDivId">
                        <div class="form-group has-feedback" id="divId">
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <input type="hidden" class="form-control"  name="superQuestionVarId" value="${question_id}" required>
                                    <input type="hidden" class="form-control"  name="questionKitId" value="${questionKit_id}" required>
                                    <input type="hidden" class="form-control"  name="id" required>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="form-group has-feedback">
                        <label  class="control-label col-xs-3">Наименование:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control"  name="name" required/>
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
                <h4 class="modal-title text-center" id="myDelModalLabel">Удаление вопроса</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal" id="delEntity">

                    <div class="form-group has-feedback">
                        <label for="delName" class="control-label col-xs-3">Наименование:</label>
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

<%--update--%>


<div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myUpdateModalLabel">Обновление</h4>
            </div>
            <div class="modal-body">

                <form role="form" class="form-horizontal" id="putEntity">

                    <div class="changeDivId hidden">
                        <div class="form-group has-feedback">
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <input type="text" class="form-control"  name="superQuestionVarId" id="superQuestionVarIdUpdate" value="${question_id}"  required>
                                    <input type="text" class="form-control"  name="questionKitId" id="questionKit_idUpdate" value="${questionKit_id}" required>
                                    <input type="text" class="form-control"  name="answerKitIdUpdate" id="answerKitIdUpdate" required>
                                    <input type="text" class="form-control" id="idUpdate" name="id" required>
                                    <input type="text" class="form-control" id="numberUpdate" name="number" required>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="form-group has-feedback">
                        <label for="nameUpdate" class="control-label col-xs-3">Наименование:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="nameUpdate" name="name" required/>
                            </div>

                        </div>
                    </div>

                    <div class="modal-footer">
                        <input id="saveUpdate" type="submit" class="btn btn-primary" value="Выполнить">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Завершить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
