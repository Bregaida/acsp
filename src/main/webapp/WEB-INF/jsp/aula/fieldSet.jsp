<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:hidden path="id"/>


<div class="form-group">
    <label for="materia">Matéria</label>
    <form:input path="materia" id="materia" cssClass="form-control"/>
    <form:errors path="materia" cssClass="help-block alert-danger"/>
</div>

<div class="form-group">
    <label for="quantidadeHorasNecessarias">Quantidade de Horas para instrução</label>
    <form:input path="quantidadeHorasNecessarias" id="quantidadeHorasNecessarias" cssClass="form-control"/>
    <form:errors path="quantidadeHorasNecessarias" cssClass="help-block alert-danger"/>
</div>

<div class="form-group">
    <label for="aeronave">Aeronaves</label>
    <form:select path="aeronaves" id="aeronave" items="${listaDeAeronaves}" itemValue="id" itemLabel="modelo" cssClass="form-control" />
</div>