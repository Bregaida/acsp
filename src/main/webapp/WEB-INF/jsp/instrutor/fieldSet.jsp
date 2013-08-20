<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="instrutorForm" method="POST" commandName="instrutor" cssClass="form-horizontal">
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
		
		<label for="alistamentoMilitar" class="col-lg-2 control-label">Alistamento Militar</label>
        <div class="col-lg-10">
            <form:input path="alistamentoMilitar" id="alistamentoMilitar" cssClass="form-control"/>
        </div>
        
        <label for="escolaridade" class="col-lg-2 control-label">Escolaridade</label>
        <div class="col-lg-10">
        	<!-- Não pegou o enum -->
        	 <!-- form:select items="escolaridade" path="escolaridade.id" id="escolaridade" itemValue="id" itemLabel="descricao" cssClass="form-control"/> -->
        </div>
		

		<label for="tituloEleitor" class="col-lg-2 control-label">Título de Eleitor</label>
        <div class="col-lg-10">
            <form:input path="tituloEleitor" id="tituloEleitor" cssClass="form-control"/>
        </div>

        <label for="codigoANAC" class="col-lg-2 control-label">Código ANAC</label>
        <div class="col-lg-10">
            <form:input path="codigoANAC" id="codigoANAC" cssClass="form-control"/>
        </div>
        
        <label for="nomePista" class="col-lg-2 control-label">Nome de Pista</label>
        <div class="col-lg-10">
            <form:input path="nomePista" id="nomePista" cssClass="form-control"/>
        </div>
        
        <label for="cht" class="col-lg-2 control-label">CHT</label>
        <div class="col-lg-10">
            <form:input path="cht" id="cht" cssClass="form-control"/>
        </div>
         
        <label for="cma" class="col-lg-2 control-label">CMA</label>
        <div class="col-lg-10">
            <form:input path="cma" id="cma" cssClass="form-control"/>
        </div>
        
         <label for="quantidadeHorasMinistrada" class="col-lg-2 control-label">Quantidade de Horas Ministradas</label>
        <div class="col-lg-10">
            <form:input path="quantidadeHorasMinistrada" id="quantidadeHorasMinistrada" cssClass="form-control"/>
        </div>
        
        <label for="ativo" class="col-lg-2 control-label">Ativo</label>
        <div class="col-lg-10">
            <form:checkbox path="ativo" id="ativo" cssClass="form-control"/>
        </div>
         
        
    </div>
    <div class="btn-group pull-right">
        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </div>
</form:form>