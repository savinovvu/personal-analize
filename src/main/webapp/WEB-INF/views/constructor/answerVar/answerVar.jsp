
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
    <script type="text/javascript" src="webjars/jquery/3.1.1-1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
    <script src="/public/js/util/model/model.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>

    <label class="btn btn-info mynav icon-prev" for="navQuestionKit"><i
            class="glyphicon glyphicon-lock label-info"></i>&nbsp
        Типы анкет</label>

    <label class="btn btn-info mynav icon-prev" for="navQuestionVar"><i
            class="glyphicon glyphicon-question-sign label-info"></i>&nbsp
        Вопросы</label>

    <label class="btn btn-info mynav icon-bar" for="navAnswerKit"><i class="glyphicon glyphicon-cog label-info"></i>&nbsp
        Наборы ответов</label>

    <label class="btn btn-info mynav" for="navAnswerVar"><i class="glyphicon glyphicon-ok label-info"></i>&nbsp
        Ответы</label>

    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Главная">
    </form>

    <form action="editQuestionKit" method="get">
        <input id="navQuestionKit" class="hidden" type="submit" name="viewAllUsers" value="Название анкет">
    </form>

    <form action="editQuestionVar" method="get">
        <input id="navQuestionVar" class="hidden" type="submit" name="viewAllUsers" value="Вопросы">
    </form>

    <form action="editAnswerKit" method="get">
        <input id="navAnswerKit" class="hidden" type="submit" name="viewAllUsers" value="Наборы ответов">
    </form>

    <form action="editAnswerVar" method="get">
        <input id="navAnswerVar" class="hidden" type="submit" name="viewAllUsers" value="Ответы">
    </form>
</nav>
</body>
</html>
