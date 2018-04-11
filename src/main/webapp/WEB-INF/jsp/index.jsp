<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/js/appLogic.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/mstyle.css"></link>
</head>
<body ng-app="myApp">

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Well Kom:)</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#!Home">Ana Ekran</a></li>
            <li><a href="#allbooks">Tüm Kayıtlar</a></li>
            <li><a href="#!newBook">Yeni Kayıt</a></li>
            <li><a href="#!managers">Yönetim</a></li>

        </ul>
    </div>
</nav>


<div ng-view></div>


<script>


</script>

</body>
</html>
