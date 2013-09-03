<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <form:hidden path="id"/>

    
    <div class="form-group">
        <label for="certificadoMatricula"><spring:message code="aeronave.certificadoMatricula"/></label>
        <form:input path="certificadoMatricula" id="certificadoMatricula" cssClass="form-control"/>
        <form:errors path="certificadoMatricula" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="marca"><spring:message code="aeronave.marca"/></label>
        <form:input path="marca" id="marca" cssClass="form-control"/>
        <form:errors path="marca" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="modelo"><spring:message code="aeronave.modelo"/></label>
        <form:input path="modelo" id="modelo" cssClass="form-control"/>
        <form:errors path="modelo" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="dentel"><spring:message code="aeronave.dentel"/></label>
        <form:input path="dentel" id="dentel" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="fiam"><spring:message code="aeronave.fiam"/></label>
        <form:input path="fiam" id="fiam" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="apoliceSeguro"><spring:message code="aeronave.apoliceSeguro"/></label>
        <form:input path="apoliceSeguro" id="apoliceSeguro" cssClass="form-control"/>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="fichaPesoBalanceamento" value="true" id="fichaPesoBalanceamento" />
            <spring:message code="aeronave.fichaPesoBalanceamento"/>
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="manualVoo" value="true" id="manualVoo" />
            <spring:message code="aeronave.manualVoo"/>
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="checkList" value="true" id="checkList" />
            <spring:message code="aeronave.checkList"/>
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="nsca3_5" value="true" id="nsca3_5" />
            <spring:message code="aeronave.nsca3_5"/>
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="nsca3_7" value="true" id="nsca3_7" />
            <spring:message code="aeronave.nsca3_7"/>
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="diarioBordo" value="true" id="diarioBordo" />
            <spring:message code="aeronave.diarioBordo"/>
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="ativo" value="true" id="ativo" />
            <spring:message code="aeronave.ativo"/>
        </label>
    </div>

    <div class="form-group">
        <label for="motivoInatividade"><spring:message code="aeronave.motivoInatividade"/></label>
        <form:input path="motivoInatividade" id="motivoInatividade" cssClass="form-control"/>
    </div>