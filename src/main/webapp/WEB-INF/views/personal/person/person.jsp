<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>UserManage</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">

    <link href="/public/css/personal/admin.css" rel="stylesheet">
    <script type="text/javascript" src="webjars/jquery/3.1.1-1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
    <script src="/public/js/util/model/model.js" type="text/javascript"></script>
    <script src="/public/js/personal/person/person.js" type="text/javascript"></script>
    <script src="/public/js/personal/person/util.js" type="text/javascript"></script>

</head>

<body onload="downloadPage()">



<div class="view-box">
    <div class="menu">

        <!-- Кнопка для открытия модального окна -->
        <button type="button" class="btn btn-lg btn-success custombtn" data-toggle="modal"
                data-target="#myModal" onclick="getModal(0)">
            Добавить пользователя
        </button>


        <div class="showUserDiv">
            <form id="showUser"></form>

        </div>
    </div>

    <table id="personT">

        <thead>
        <tr>
            <td>id</td>
            <td>ФИО</td>
            <td>Отдел</td>
            <td>Действие</td>
        </tr>
        </thead>
    </table>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Заголовок модального окна -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myModalLabel">Добавление/Обновление пользователя</h4>
            </div>
            <!-- Основная часть модального окна, содержащая форму для регистрации -->
            <div class="modal-body">
                <!-- Форма для регистрации -->
                <form role="form" class="form-horizontal" onsubmit="putUser()">

                    <!-- Блок для ввода id -->
                    <div class="changeDivId">
                        <%--<div class="form-group" id="divId">--%>
                        <div class="form-group has-feedback" id="divId">
                       <%--     <label for="personId" class="control-label col-xs-3">id:</label>--%>
                            <div class="col-xs-6">
                                <div class="input-group">
                       <%--             <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>--%>


                                    <input type="hidden" class="form-control" id="personId" name="id" required>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Блок для ввода ФИО -->

                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">ФИО:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="name" name="name" required/>
                            </div>

                        </div>
                    </div>
                    <!-- Конец блока для ввода ФИО-->


                    <%--Блок ввод отдела--%>
                    <div class="form-group has-feedback">
                        <label for="group" class="control-label col-xs-3">Отдел</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                <select id="group" class="form-control" name="group"  required>



                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- Конец блока для ввода отдела-->

                    <%--Скрытый блог данных об отделах--%>
                 <%--   <div class="hiddenGroupDiv" id="hiddenGroupDiv">

                    </div>
--%>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
                        <input id="save" type="submit" class="btn btn-primary" value="Готово">
                    </div>
                </form>
            </div>
            <!-- Нижняя часть модального окна -->

        </div>
    </div>
</div>


</body>
</html>
