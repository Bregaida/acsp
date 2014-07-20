<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <form:hidden path="agenda.id"/>

    <div class="form-group">
        <label><spring:message code="agenda.dataReserva"/></label>
        <form:input path="agenda.dataReserva" id="dataReservaId" cssClass="form-control datepicker-input" maxlength="10"/>
        <form:errors path="agenda.dataReserva" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
    	<label for="aluno"><spring:message code="agenda.aluno"/></label>
    	<form:select path="agenda.aluno" id="aluno" cssClass="form-control">
            <form:option value="" label="--- Selecione ---" />
            <form:options items="${listaDeAlunos}" itemValue="id" itemLabel="nome" />
    	</form:select>
    	<form:errors path="agenda.aluno" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
    	<label for="aeronave"><spring:message code="agenda.aeronave"/></label>
        <form:select id="aeronave" name="aeronaveId" path="agenda.aeronave" cssClass="form-control">
            <form:option value="" label="--- Selecione ---"/>
            <form:options items="${listaDeAeronaves}" itemValue="id"/>
        </form:select>
        <form:errors path="agenda.aeronave" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="horario"><spring:message code="agenda.horario"/></label>
        <form:select path="agenda.horario" id="horario" items="${listaDeHorarios}" itemValue="id" itemLabel="horarioAgenda" cssClass="form-control" />
        <form:errors path="agenda.horario" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="qtdeHoras"><spring:message code="agenda.qtdeHoras"/></label>
        <form:input path="agenda.qtdeHoras" id="qtdeHoras" cssClass="form-control"/>
        <form:errors path="agenda.qtdeHoras" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="aula"><spring:message code="agenda.aula"/></label>
        <form:select path="agenda.aula" id="aula" items="${listaDeAulas}" itemValue="id" itemLabel="materia" cssClass="form-control" />
    </div>

    <div class="form-group">
        <label for="instrutor"><spring:message code="agenda.instrutor"/></label>
        <form:select path="agenda.instrutor" id="instrutor" items="${listaDeInstrutores}" itemValue="id" itemLabel="nome" cssClass="form-control" />
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="agenda.flag360milhas" value="true"/>
            <spring:message code="agenda.360Milhas"/>
        </label>
    </div>