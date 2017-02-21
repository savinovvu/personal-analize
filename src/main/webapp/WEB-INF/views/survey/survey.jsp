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

    <script src="/public/js/survey/service/service.js" type="text/javascript"></script>
    <script src="/public/js/survey/view/view.js" type="text/javascript"></script>

</head>
<body onload=downloadPage()>
<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>
    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Главная">
    </form>
</nav>

<div class="select-box">
    <select id="kit" class="form-control" name="group"
            onchange="getQuestionVarsWithQuestionKit()">
        <option disabled selected>Выберете анкету</option>
    </select>
</div>
<br>
<br>
<br>

<form id="surveyForm">
<ol id="questionList">

</ol>
</form>


</body>
</html>
