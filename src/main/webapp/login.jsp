<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="resources/ico/favicon.png">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/login.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form name='f' action="j_spring_security_check" method='POST' class="form-signin">
        <h2 class="form-signin-heading">Login</h2>
        <input type="text" name="j_username" class="form-control" placeholder="Email address" autofocus>
        <input type="password" name="j_password" class="form-control" placeholder="Password">
        <label class="checkbox">
            <input type="checkbox" value="remember-me"> Manter logado
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/js/respond.min.js"></script>
</body>
</html>
