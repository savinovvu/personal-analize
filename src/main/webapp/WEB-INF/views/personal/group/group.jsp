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

    <link href="/public/css/personal/admin.css" rel="stylesheet">
    <script type="text/javascript" src="webjars/jquery/3.1.1-1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
    <script src="/public/js/common/model/model.js" type="text/javascript"></script>
    <script src="/public/js/common/ajax/ajax.js" type="text/javascript"></script>

    <script src="/public/js/personal/group/service/groupService.js" type="text/javascript"></script>
    <script src="/public/js/personal/group/view/groupView.js" type="text/javascript"></script>

</head>

<body onload="downloadPage()">

<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>
    <label class="btn btn-info mynav icon-prev" for="navDepartment"><i
            class="glyphicon glyphicon-th-large label-info"></i>&nbsp
        Подразделения</label>
    <label class="btn btn-info mynav icon-bar" for="navGroup"><i class="glyphicon glyphicon-th-list label-info"></i>&nbsp
        Группы</label>
    <label class="btn btn-info mynav" for="navPerson"><i class="glyphicon glyphicon-user label-info"></i>&nbsp
        Персонал</label>

    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Подразделения">
    </form>

    <form action="editDepartment" method="get">
        <input id="navDepartment" class="hidden" type="submit" name="viewAllUsers" value="Подразделения">
    </form>
    <form action="editGroup" method="get">
        <input id="navGroup" class="hidden" type="submit" name="viewAllUsers" value="Отделы">
    </form>

    <form action="editPerson" method="get">
        <input id="navPerson" class="hidden" type="submit" name="viewAllUsers" value="Люди">
    </form>
</nav>
<div class="view-box">
    <div class="menu">

        <button type="button" class="btn btn-lg btn-success custombtn" data-toggle="modal"
                data-target="#myModal" onclick="getModal()">
            Добавить группу
        </button>


        <div class="showUserDiv">
            <form id="showUser"></form>

        </div>
    </div>

    <table id="entityT">

        <thead>
        <tr>
            <td>id</td>
            <td>Группа</td>
            <td>Подразделение</td>
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
                <h4 class="modal-title text-center" id="myModalLabel">Добавление/Обновление группы</h4>
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
                        <label for="name" class="control-label col-xs-3">Группа:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="name" name="name" required/>
                            </div>

                        </div>
                    </div>


                    <div class="form-group has-feedback">
                        <label for="superEntity" class="control-label col-xs-3">Подразделение</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                <select id="superEntity" class="form-control" name="superEntity">


                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="modal-footer">
                        <input id="save" type="submit" class="btn btn-primary" value="Готово">
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
                <h4 class="modal-title text-center" id="myDelModalLabel">Удаление Группы</h4>
            </div>
            <div class="modal-body">
                <form role="form" class="form-horizontal" id="delEntity">


                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">Группа:</label>
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
