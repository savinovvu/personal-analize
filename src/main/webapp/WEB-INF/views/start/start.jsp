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
    <link href="/public/css/start/start.css" rel="stylesheet">

</head>
<body>
<div class="parent">
<div class="menu">

    <form action="editDepartment" method="get">
        <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Подразделения">
    </form>

    <form action="editGroup" method="get">
        <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Отделы">
    </form>


    <form action="editPerson" method="get">
        <input class="btn btn-primary" type="submit" name="viewAllUsers" value="Люди">
    </form>










</div>
</div>





</body>
</html>
