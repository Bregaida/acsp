<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <form:hidden path="id"/>

    <div class="form-group">
        <label for="nome"><spring:message code="aluno.nome"/></label>
        <form:input path="nome" id="nome" cssClass="form-control"/>
        <form:errors path="nome" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="rg"><spring:message code="aluno.rg"/></label>
        <form:input path="rg" id="rg" cssClass="form-control"/>
        <form:errors path="rg" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="cpf"><spring:message code="aluno.cpf"/></label>
        <form:input path="cpf" id="cpf" cssClass="form-control cpf" size="14" maxlength="14"/>
        <form:errors path="cpf" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="alistamentoMilitar"><spring:message code="aluno.alistamentoMilitar"/></label>
        <form:input path="alistamentoMilitar" id="alistamentoMilitar" cssClass="form-control"/>
        <form:errors path="alistamentoMilitar" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="escolaridade"><spring:message code="aluno.Escolaridade"/></label>
        <form:select items="${escolaridades}" path="escolaridade" id="escolaridade" itemValue="id" itemLabel="descricao" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="tituloEleitor"><spring:message code="aluno.tituloEleitor"/></label>
        <form:input path="tituloEleitor" id="tituloEleitor" cssClass="form-control"/>
        <form:errors path="tituloEleitor" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="codigoANAC"><spring:message code="aluno.codigoANAC"/></label>
        <form:input path="codigoANAC" id="codigoANAC" cssClass="form-control"/>
        <form:errors path="codigoANAC" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="nomePista"><spring:message code="aluno.nomePista"/></label>
        <form:input path="nomePista" id="nomePista" cssClass="form-control"/>
        <form:errors path="nomePista" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="cht"><spring:message code="aluno.CHT"/></label>
        <form:input path="cht" id="cht" cssClass="form-control"/>
        <form:errors path="cht" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="cma"><spring:message code="aluno.CMA"/></label>
        <form:input path="cma" id="cma" cssClass="form-control"/>
        <form:errors path="cma" cssClass="help-block alert-danger"/>
    </div>

    <div class="checkbox">
        <label for="ativo">
            <form:checkbox path="ativo" id="ativo"/>
            <spring:message code="aluno.ativo"/>
        </label>
    </div>