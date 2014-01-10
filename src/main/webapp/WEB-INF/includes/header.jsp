<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html ng-app="app">
<head>
    <title><spring:message code="title"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="pragma" content="no-cache" />

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/bootswatch/3.0.3/cerulean/bootstrap.min.css" rel="stylesheet">
    <link href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.css" rel="stylesheet">
    <link href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.print.css" rel="stylesheet">
    <link href="<c:url value="/resources/css/acsp.css"/>" rel="stylesheet">

    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/webfont/1.4.10/webfont.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular-route.min.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.6/angular-resource.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>
    <script type="text/javascript" src="//cdn.jsdelivr.net/restangular/1.1.3/restangular.min.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.7.0/ui-bootstrap.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.7.0/ui-bootstrap-tpls.js"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/calendar.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/datejs/1.0/date.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Mudar navegação</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/acsp/home">ACSP</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li class="${aeronaveMenu}">
                <a href="/acsp/aeronaves/spa">Aeronaves</a>
            </li>
            <li class="${instrutoresMenu}">
                <a href="/acsp/instrutores/spa">Instrutores</a>
            </li>
            <li class="${alunosMenu}">
                <a href="/acsp/alunos/spa">Alunos</a>
            </li>
            <li class="${sociosMenu}">
                <a href="/acsp/socios/spa">Sócios</a>
            </li>
             <li class="${aulasMenu}">
                <a href="/acsp/aulas/spa">Aulas</a>
            </li>
            <li class="${atendenteMenu}">
                <a href="/acsp/atendentes/spa">Atendentes</a>
            </li>
            <!--  li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Relatórios<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Relatório I</a></li>
                    <li><a href="#">Relatório II</a></li>
                    <li><a href="#">Relatório III</a></li>
                    <li><a href="#">Relatório IV</a></li>
                </ul>
            </li -->
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administrador<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="/acsp/alunos/spa">Manutenção de Alunos</a></li>
                    <li><a href="/acsp/instrutores/spa">Manutenção de Instrutores</a></li>
                    <li><a href="/acsp/atendentes/spa">Manutenção de Atendentes</a></li>
                    <li><a href="/acsp/aeronaves/spa">Manutenção de Aeronaves</a></li>
                    <li><a href="/acsp/aulas/spa">Manutenção de Aulas</a></li>
                    <li><a href="/acsp/agendamento/spa">Manutenção de Agendamentos</a></li>
                    <li><a href="#">Informações do Sistema</a></li>
                </ul>
            </li>
            <li>
                <c:if test="${pageContext.request.remoteUser != null}">
                    <c:url var="logoutUrl" value="/logout"/>
                    <form:form class="navbar-form pull-right" action="${logoutUrl}" method="post">
                        <input type="submit" value="Log out" class="btn btn-primary"/>
                    </form:form>
                </c:if>
            </li>
        </ul>
    </div><!-- /.navbar-collapse -->
</nav>
<!-- fim do menu -->
<br>
<br>
<br>
<div class="container">