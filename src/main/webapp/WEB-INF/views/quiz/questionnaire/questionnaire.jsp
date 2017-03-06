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

    <script src="/public/js/quiz/questionnaire/service/service.js" type="text/javascript"></script>
    <script src="/public/js/quiz/questionnaire/view/view.js" type="text/javascript"></script>
    <script src="/public/js/quiz/questionnaire/util/util.js" type="text/javascript"></script>

</head>
<body onload=downloadPage(${survey_id})>
<nav class="navbar navbar-form">

    <label class="btn btn-info mynav" for="start"><i class="glyphicon glyphicon-home label-info "></i>&nbsp
        Главная</label>

    <label class="btn btn-info mynav" for="survey"><i class="glyphicon glyphicon-list label-info "></i>&nbsp
        Тестирование</label>

    <form action="/" method="get">
        <input id="start" class="hidden" type="submit" name="viewAllUsers" value="Главная">
    </form>


    <form action="conductSurvey" method="get">
        <input id="survey" class="hidden" type="submit" name="viewAllUsers">
    </form>
</nav>

<p>Ориентировочный номер анкеты: ${numberOfQuestionnaire}</p>

<br>
<br>
<br>


<form id="surveyForm">
    <input type="hidden" name="survey_id" value="${survey_id}">
    <br>
    <br>

    <ol id="questionList">

    </ol>

    <input type="submit" class="btn btn-primary right-position" value="Готово">

</form>


</body>
</html>
