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
    <script src="/public/js/personal/group/group.js" type="text/javascript"></script>
    <script src="/public/js/personal/group/util.js" type="text/javascript"></script>

</head>

<body onload="downloadPage()">



<div class="view-box">
    <div class="menu">

        <!-- Кнопка для открытия модального окна -->
        <button type="button" class="btn btn-lg btn-success custombtn" data-toggle="modal"
                data-target="#myModal" onclick="getModal()">
            Добавить группу
        </button>


        <div class="showUserDiv">
            <form id="showUser"></form>

        </div>
    </div>

    <table id="personT">

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
            <!-- Заголовок модального окна -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myModalLabel">Добавление/Обновление группы</h4>
            </div>
            <!-- Основная часть модального окна, содержащая форму для регистрации -->
            <div class="modal-body">
                <!-- Форма для регистрации -->
                <form role="form" class="form-horizontal" onsubmit="putGroup()">

                    <!-- Блок для ввода id -->
                    <div class="changeDivId">
                        <div class="form-group has-feedback" id="divId">
                            <div class="col-xs-6">
                                <div class="input-group">
                                    <input type="hidden" class="form-control" id="groupId" name="id" required>
                                </div>
                            </div>
                        </div>
                    </div>


                    <!-- Блок для ввода ФИО -->

                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">Группа:</label>
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
                        <label for="department" class="control-label col-xs-3">Подразделение</label>

                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>

                                <select id="department" class="form-control" name="department">



                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- Конец блока для ввода отдела-->

                    <%-- Скрытый блог данных об отделах--%>


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

<%--Блок удаления--%>

<div class="modal fade" id="myDelModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Заголовок модального окна -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h4 class="modal-title text-center" id="myDelModalLabel">Удаление Группы</h4>
            </div>
            <!-- Основная часть модального окна, содержащая форму для удаления -->
            <div class="modal-body">
                <!-- Форма для регистрации -->
                <form role="form" class="form-horizontal" onsubmit="delGroup()">


                    <!-- Блок для ввода ФИО -->

                    <div class="form-group has-feedback">
                        <label for="name" class="control-label col-xs-3">Группа:</label>
                        <div class="col-xs-6">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                                <input type="hidden" class="form-control" id="groupDelId" name="id" readonly required>
                                <input type="text" class="form-control" id="delName" name="name"  readonly  required/>
                            </div>

                        </div>
                    </div>
                    <!-- Конец блока для ввода ФИО-->




                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Отмена</button>
                        <input  type="submit" class="btn btn-danger" value="Удалить">
                    </div>
                </form>
            </div>
            <!-- Нижняя часть модального окна -->

        </div>
    </div>
</div>



</body>
</html>
