<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<form:hidden path="id"/>


<div class="form-group">
    <label for="materia"><spring:message code="aula.materia"/></label>
    <form:input path="materia" id="materia" cssClass="form-control"/>
    <form:errors path="materia" cssClass="help-block alert-danger"/>
</div>

<div class="form-group">
    <label for="quantidadeHorasNecessarias"><spring:message code="aula.quantidadeHorasNecessarias"/></label>
    <form:input path="quantidadeHorasNecessarias" id="quantidadeHorasNecessarias" cssClass="form-control"/>
    <form:errors path="quantidadeHorasNecessarias" cssClass="help-block alert-danger"/>
</div>

<div class="form-group">
    <label for="aeronave"><spring:message code="aula.aeronaves"/></label>
    <ul class="form-inline">
        <form:checkboxes path="aeronaves" id="aeronave" items="${listaDeAeronaves}" itemValue="id" element="li class='checkbox-inline'" />
    </ul>
</div>