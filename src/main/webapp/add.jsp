<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
    <div class="row" style="padding-top: 20px">
        <div class="col col-md-10 col-lg-10 col-sm-12">
            <form:form method="POST" modelAttribute="threadForm" class="form-signin">
                <h2 class="form-signin-heading">Add new thread!</h2>
                <spring:bind path="title">
                    <div class="form-group" ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="title" class="form-control" placeholder="Title"
                                    autofocus="true"></form:input>
                        <form:errors path="title"></form:errors>
                    </div>
                </spring:bind>

                <spring:bind path="content">
                    <div class="form-group" ${status.error ? 'has-error' : ''}">
                        <form:textarea type="text" path="content" class="form-control" placeholder="Content"
                                    rows="5" autofocus="true"></form:textarea>
                        <form:errors path="content"></form:errors>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            </form:form>
        </div>
    </div>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
