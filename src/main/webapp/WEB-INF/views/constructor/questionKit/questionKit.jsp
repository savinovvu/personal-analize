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
    <script src="/public/js/util/model/model.js" type="text/javascript"></script>
    <script src="/public/js/personal/department/department.js" type="text/javascript"></script>
    <script src="/public/js/personal/department/util.js" type="text/javascript"></script>

</head>

<body onload="downloadPage()">
<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp Главная</label>
    <label class="btn btn-info mynav icon-prev" for="navDepartment"><i class="glyphicon glyphicon-th-large label-info"></i>&nbsp
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

        <!-- Кнопка для открытия модального окна -->
        <button type="button" class="btn btn-lg btn-success custombtn" data-toggle="modal"
                data-target="#myModal" onclick="getModal()">
            Добавить Подразделение
        </button>


    </div>

    <table id="departmentT">

        <thead>
        <tr>
            <td>id</td>
            <td>Подразделение</td>
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
                <h4 class="modal-title text-center" id="myModalLabel">Добавление/Обновление подразделения</h4>
            </div>
            <!-- Основная часть модального окна, содержащая форму для регистрации -->
            <div class="modal-body">
                <!-- Форма для регистрации -->
                <form role="form" class="form-horizontal" id="putDepartment">

                    <!-- Блок для ввода id -->
                    <div class="changeDivId">
                        <%--<div class="form-group" id="divId">--%>
                        <div class="form-group has-feedback" id="divId">
                            <%--     <label for="personId" class="control-label col-xs-3">id:</label>--%>
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <input type="hidden" class="form-control" id="departmentId" name="id" required>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Блок для ввода названия -->

                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">Наименование:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input type="text" class="form-control" id="name" name="name" required/>
                            </div>

                        </div>
                    </div>
                    <!-- Конец блока для ввода названия-->


                    <div class="modal-footer">
                        <input id="save" type="submit" class="btn btn-primary" value="Выполнить">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Завершить</button>
                    </div>
                </form>
            </div>
            <!-- Нижняя часть модального окна -->

        </div>
    </div>
</div>

<%--Блок удаления--%>

<div class="modal fade" id="myDelModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Заголовок модального окна -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myDelModalLabel">Удаление подразделения</h4>
            </div>
            <!-- Основная часть модального окна, содержащая форму для удаления -->
            <div class="modal-body">
                <!-- Форма для регистрации -->
                <form role="form" class="form-horizontal" id="delDepartment">


                    <!-- Блок для ввода Наименования -->

                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">ФИО:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="hidden" class="form-control" id="departmentDelId" name="id" readonly
                                       required>
                                <input type="text" class="form-control" id="delName" name="name" readonly required/>
                            </div>

                        </div>
                    </div>
                    <!-- Конец блока для ввода Наименования-->


                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
                        <input type="submit" class="btn btn-danger" value="Удалить">
                        <input id="dismissButton" type="button" class="hidden" data-dismiss="modal">

                    </div>
                </form>
            </div>
            <!-- Нижняя часть модального окна -->


        </div>
    </div>
</div>


</body>
</html>
