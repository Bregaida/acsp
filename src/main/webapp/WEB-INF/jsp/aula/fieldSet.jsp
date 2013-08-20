<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="aulaForm" method="POST" commandName="aula" cssClass="form-horizontal">
    <form:errors/>
    <div class="form-group">

        <div class="row col-md-9">
            <div class="form-group">
                <label for="materia" class="col-lg-2 control-label">Matéria</label>
                <div class="col-lg-10">
                    <form:input path="materia" id="materia" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="row col-md-9">
            <div class="form-group">
                <label for="quantidadeHorasNecessarias" class="col-lg-2 control-label">Quantidade de Horas para instrução</label>
                <div class="col-lg-10">
                    <form:input path="quantidadeHorasNecessarias" id="quantidadeHorasNecessarias" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="row col-md-9">
            <div class="form-group">
                <label for="aeronave" class="col-lg-2 control-label">Aeronaves</label>
                <div class="col-lg-10">
                    <%--  <form:checkboxes path="aeronaves.id" id="aeronave" items="${listaDeAeronaves}" itemValue="id" itemLabel="modelo" />--%>
                    <form:select path="aeronaves" id="aeronave" items="${listaDeAeronaves}" itemValue="id" itemLabel="modelo" />
                </div>
            </div>
        </div>
    </div>
    <div class="btn-group pull-right">
        <button type="button" class="btn btn-default">Limpar</button>
        <button type="submit" class="btn btn-default">Enviar</button>
    </div>

</form:form>