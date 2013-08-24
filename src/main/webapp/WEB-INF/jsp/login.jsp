<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/acsp/resources/ico/favicon.png">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="/acsp/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/acsp/resources/css/login.css" rel="stylesheet">

</head>

<body>

<div class="container">
    <c:if test="${param.error != null}"> 2
        <div class="alert alert-error">
            Invalid username and password.
        </div>
    </c:if>
    <c:if test="${param.logout != null}"> 3
        <div class="alert alert-success">
            You have been logged out.
        </div>
    </c:if>
    <c:url value="/login" var="loginUrl"/>
    <form:form name="f" action="${loginUrl}" method="post" cssClass="form-signin">
        <h2 class="form-signin-heading">Login</h2>
        <input type="text" name="username" class="form-control" placeholder="Email address" autofocus>
        <input type="password" name="password" class="form-control" placeholder="Password">
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Manter logado
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form:form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/acsp/resources/js/respond.min.js"></script>
</body>
</html>