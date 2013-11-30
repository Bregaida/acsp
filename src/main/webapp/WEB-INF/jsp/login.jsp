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

    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/acsp/resources/css/login.css" rel="stylesheet">

</head>

<body>

<div class="container">
    <c:if test="${param.error != null}">
        <div class="alert alert-error">
            Usuário e/ou senha inválidos.
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            Você saiu do sistema com sucesso.
        </div>
    </c:if>
    <c:url value="/login" var="loginUrl"/>
    <form:form name="f" action="${loginUrl}" method="post" cssClass="form-signin">
        <h2 class="form-signin-heading">Login</h2>
        <input type="text" name="username" class="form-control" placeholder="Email address" autofocus>
        <input type="password" name="password" class="form-control" placeholder="Password">
        <!--
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Manter logado
        </label>
        -->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form:form>

    <small class="pull-right">Usuários disponíveis admin/admin1 ou user/user1</small>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>
