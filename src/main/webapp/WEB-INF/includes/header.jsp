<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Aeroclube de São Paulo - Bem Vindo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="pragma" content="no-cache" />

    <!-- Bootstrap -->
    <link href="/acsp/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/acsp/resources/css/navbar.css" rel="stylesheet">
    <!--
    <link href="/acsp/resources/css/grid.css" rel="stylesheet">
    -->
</head>
<body>

<nav class="navbar" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Mudar navegação</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">ACSP</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li class="active">
                <a href="/acsp/home">Inicio</a>
            </li>
            <li>
                <a href="/acsp/aeronaves">Aeronaves</a>
            </li>
            <li>
                <a href="/acsp/alunos">Alunos</a>
            </li>
            <li>
                <a href="/acsp/aulas">Aulas</a>
            </li>
            <li>
                <a href="/acsp/agenda">Agenda</a>
            </li>
            <li>
                <a href="/acsp/socios">Sócios</a>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Relatórios<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Relatório I</a></li>
                    <li><a href="#">Relatório II</a></li>
                    <li><a href="#">Relatório III</a></li>
                    <li><a href="#">Relatório IV</a></li>
                </ul>
            </li>
        </ul>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Pesquisar">
            </div>
            <button type="submit" class="btn btn-default">Busca</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Administrador<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Manutenção de Usuários</a></li>
                    <li><a href="#">Manutenção de Instrutores</a></li>
                    <li><a href="#">Manutenção de Pista</a></li>
                    <li><a href="#">Informações do Sistema</a></li>
                </ul>
            </li>
        </ul>
    </div><!-- /.navbar-collapse -->
</nav>
<!-- fim do menu -->

<div class="container">