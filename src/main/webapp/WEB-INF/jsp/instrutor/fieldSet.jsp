<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <form:hidden path="id"/>

    <div class="form-group">
        <form:errors path="*" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="nome">Nome</label>
        <form:input path="nome" id="nome" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="rg">RG</label>
        <form:input path="rg" id="rg" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="cpf">CPF</label>
        <form:input path="cpf" id="cpf" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="alistamentoMilitar">Alistamento Militar</label>
        <form:input path="alistamentoMilitar" id="alistamentoMilitar" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="escolaridade">Escolaridade</label>
        <form:select items="${escolaridades}" path="escolaridade" id="escolaridade" itemValue="id" itemLabel="descricao" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="tituloEleitor">Título de Eleitor</label>
        <form:input path="tituloEleitor" id="tituloEleitor" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="codigoANAC">Código ANAC</label>
        <form:input path="codigoANAC" id="codigoANAC" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="nomePista">Nome de Pista</label>
        <form:input path="nomePista" id="nomePista" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="cht">CHT</label>
        <form:input path="cht" id="cht" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="cma">CMA</label>
        <form:input path="cma" id="cma" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="quantidadeHorasMinistrada">Quantidade de Horas Ministradas</label>
        <form:input path="quantidadeHorasMinistrada" id="quantidadeHorasMinistrada" cssClass="form-control"/>
    </div>

    <div class="checkbox">
        <label for="ativo">
            <form:checkbox path="ativo" id="ativo" />
            Ativo
        </label>
    </div>