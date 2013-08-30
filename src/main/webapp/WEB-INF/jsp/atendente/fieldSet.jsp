<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <form:hidden path="id" />

  
    <div class="form-group">
        <label for="nome"><spring:message code="atendente.nome"/></label>
        <form:input path="nome" id="nome" cssClass="form-control"/>
        <form:errors path="nome" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="rg"><spring:message code="atendente.rg"/></label>
        <form:input path="rg" id="rg" cssClass="form-control"/>
        <form:errors path="rg" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="cpf"><spring:message code="atendente.cpf"/></label>
        <form:input path="cpf" id="cpf" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="alistamentoMilitar"><spring:message code="atendente.alistamantoMilitar"/></label>
        <form:input path="alistamentoMilitar" id="alistamentoMilitar" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="escolaridade"><spring:message code="atendente.escolaridade"/></label>
        <form:select items="${escolaridades}" path="escolaridade" id="escolaridade" itemValue="id" itemLabel="descricao" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="tituloEleitor"><spring:message code="atendente.tituloEleitor"/></label>
        <form:input path="tituloEleitor" id="tituloEleitor" cssClass="form-control"/>
    </div>

    <div class="checkbox">
        <label for="ativo">
            <form:checkbox path="ativo" id="ativo"/>
            Ativo
        </label>
    </div>