<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="alunoForm" method="POST" commandName="aluno" cssClass="form-horizontal">
    <form:errors/>
    <div class="form-group">

        <label for="nome" class="col-lg-2 control-label">Nome</label>
        <div class="col-lg-10">
            <form:input path="nome" id="nome" cssClass="form-control"/>
        </div>

        <label for="rg" class="col-lg-2 control-label">RG</label>
        <div class="col-lg-10">
            <form:input path="rg" id="rg" cssClass="form-control"/>
        </div>

        <label for="cpf" class="col-lg-2 control-label">CPF</label>
        <div class="col-lg-10">
            <form:input path="cpf" id="cpf" cssClass="form-control"/>
        </div>

        <label for="codigoANAC" class="col-lg-2 control-label">Código ANAC</label>
        <div class="col-lg-10">
            <form:input path="codigoANAC" id="codigoANAC" cssClass="form-control"/>
        </div>
    </div>
    <div class="btn-group pull-right">
        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </div>
</form:form>