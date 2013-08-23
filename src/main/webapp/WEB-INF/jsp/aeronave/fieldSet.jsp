<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <div class="form-group">
        <form:errors/>
    </div>

    <div class="form-group">
        <label for="certificadoMatricula">Certificado de Matrícula</label>
        <form:input path="certificadoMatricula" id="certificadoMatricula" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="marca">Marca</label>
        <form:input path="marca" id="marca" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="modelo">Modelo</label>
        <form:input path="modelo" id="modelo" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="dentel">DENTEL</label>
        <form:input path="dentel" id="dentel" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="fiam">FIAM</label>
        <form:input path="fiam" id="fiam" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="apoliceSeguro">Apólice de Seguro</label>
        <form:input path="apoliceSeguro" id="apoliceSeguro" cssClass="form-control"/>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="fichaPesoBalanceamento" value="true" id="fichaPesoBalanceamento" />
            Possui Ficha de Balanceamento?
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="manualVoo" value="true" id="manualVoo" />
            Possui Manual de Vôo?
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="checkList" value="true" id="checkList" />
            Possui Check List?
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="nsca3_5" value="true" id="nsca3_5" />
            Possui NSCA 3-5?
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="nsca3_7" value="true" id="nsca3_7" />
            Possui NSCA 3-7?
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="diarioBordo" value="true" id="diarioBordo" />
            Possui Diário de Bordo?
        </label>
    </div>

    <div class="checkbox">
        <label>
            <form:checkbox path="ativo" value="true" id="ativo" />
            Aeronave Ativa?
        </label>
    </div>

    <div class="form-group">
        <label for="motivoInatividade">Motivo da inatividade</label>
        <form:input path="motivoInatividade" id="motivoInatividade" cssClass="form-control"/>
    </div>