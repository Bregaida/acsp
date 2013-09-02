<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <form:hidden path="id" />

    <div class="form-group">
        <label><spring:message code="atendente.nome"/></label>
        <form:input path="nome" cssClass="form-control"/>
        <form:errors path="nome" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label><spring:message code="atendente.rg"/></label>
        <form:input path="rg" cssClass="form-control"/>
        <form:errors path="rg" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label><spring:message code="atendente.cpf"/></label>
        <form:input path="cpf" cssClass="form-control cpf" size="14" maxlength="14"/>
        <form:errors path="cpf" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label><spring:message code="atendente.alistamentoMilitar"/></label>
        <form:input path="alistamentoMilitar" cssClass="form-control"/>
        <form:errors path="alistamentoMilitar" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label><spring:message code="atendente.escolaridade"/></label>
        <form:select items="${escolaridades}" path="escolaridade" itemValue="id" itemLabel="descricao" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label><spring:message code="atendente.tituloEleitor"/></label>
        <form:input path="tituloEleitor" cssClass="form-control"/>
        <form:errors path="tituloEleitor" cssClass="help-block alert-danger"/>
    </div>

    <div class="checkbox">
        <label for="ativo">
            <form:checkbox path="ativo" id="ativo"/>
            Ativo
        </label>
    </div>
