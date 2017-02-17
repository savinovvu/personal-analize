<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>StartPage</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link href="/public/css/common/common.css" rel="stylesheet">
    <link href="/public/css/start/start.css" rel="stylesheet">

</head>
<body>
<div class="parent">
    <div class="menu">

        <form action="conductSurvey" method="get">
            <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Тестирование">
        </form>

        <form action="conductSurvey" method="get">
            <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Архив">
        </form>

        <form action="editQuestionKit" method="get">
            <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Конструирование">
        </form>

        <form action="editPerson" method="get">
            <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Персонал">
        </form>

        <form action="import" method="get">
            <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Импорт и экспорт БД">
        </form>




    </div>
</div>



</body>
</html>
