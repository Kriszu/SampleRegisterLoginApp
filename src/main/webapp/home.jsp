<%@ page import="org.jsoup.Connection" %>
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</c:if>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="home">Home</a></li>
            <li><a href="#Profile">${pageContext.request.userPrincipal.name}</a></li>
            <li><a href="add">Add</a></li>
            <li><a onclick="document.forms['logoutForm'].submit()">>Log out</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col col-md-10 col-lg-10 col-sm-12">
            <div class="row" style="padding-top: 10px;">
                <h3>This is title of thread</h3>
            </div>
            <div class="row">
                <h5><small>Create by: Janusz3000 24.10.2017 15:47</small></h5>
            </div>
            <div class="row">


                <button class="btn btn-default btn-xs">Go to Thread!</button>
            </div>
        </div>
    </div>

    <c:if test="${fn:length(threadList)!=null}">
    <c:forEach items="${threadList}" var ="threads">
        <div class="row">
            <div class="col col-md-10 col-lg10 col-sm-12">
                <div class="row" style="padding-top: 10px">
                <h3><c:out value="${threads.title}"></c:out></h3>
                </div>
                <div class="row">
                    <h5><small><c:out value="${threads.user.username}"></c:out></small></h5>
                </div>
                <div class="row">
                    <h5><small>Created: <c:out value="${threads.date}"></c:out></small></h5>
                </div>
                <div class="row">
                    <p><c:out value="${threads.content}"></c:out></p>
                    <form action="http://localhost:8080/thread/${threads.id}">
                        <input type="submit" value="Go to Thread" />
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
    </c:if>
<%--
<h1>This is home ${pageContext.request.userPrincipal.name}</h1>
--%>
--%>

<%--    <ul>
        <c:forEach var="listvalue" items="${lists}">
            <li>${listvalue}</li>
        </c:forEach>
    </ul>--%>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
