<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="aeronaveForm" method="POST" commandName="aeronave" cssClass="form-horizontal">
    <form:errors/>
    <div class="form-group">

        <div class="row col-md-9">
            <div class="form-group">
                <label for="certificadoMatricula" class="col-lg-2 control-label">Certificado de Matrícula</label>
                <div class="col-lg-10">
                    <form:input path="certificadoMatricula" id="certificadoMatricula" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="row col-md-9">
            <div class="form-group">
                <label for="marca" class="col-lg-2 control-label">Marca</label>
                <div class="col-lg-10">
                    <form:input path="marca" id="marca" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="row col-md-9">
            <div class="form-group">
                <label for="modelo" class="col-lg-2 control-label">Modelo</label>
                <div class="col-lg-10">
                    <form:input path="modelo" id="modelo" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="row col-md-9">
            <div class="form-group">
                <label for="dentel" class="col-lg-2 control-label">DENTEL</label>
                <div class="col-lg-10">
                    <form:input path="dentel" id="dentel" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="row col-md-9">
            <div class="form-group">
                <label for="fiam" class="col-lg-2 control-label">FIAM</label>
                <div class="col-lg-10">
                    <form:input path="fiam" id="fiam" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="row col-md-9">
            <div class="form-group">
                <label for="apoliceSeguro" class="col-lg-2 control-label">Apólice de Seguro</label>
                <div class="col-lg-10">
                    <form:input path="apoliceSeguro" id="apoliceSeguro" cssClass="form-control"/>
                </div>
            </div>
        </div>

        <div class="row col-md-10">
            <div class="row">
                <div class="form-group pull-left">
                    <label for="fichaPesoBalanceamento" class="col-lg-2 control-label">Possui Ficha de Balanceamento?</label>
                    <div class="col-md-3">
                        <form:checkbox path="fichaPesoBalanceamento" value="true" id="fichaPesoBalanceamento" cssClass="form-control"/>
                    </div>
                </div>

                <div class="form-group pull-left">
                    <label for="manualVoo" class="col-lg-2 control-label">Possui Manual de Vôo?</label>
                    <div class="col-md-3">
                        <form:checkbox path="manualVoo" value="true" id="manualVoo" cssClass="form-control"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group pull-left">
            <label for="checkList" class="col-lg-2 control-label">Possui Check List?</label>
            <div class="col-lg-10">
                <form:checkbox path="checkList"value="true" id="checkList" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group pull-left">
            <label for="nsca3_5" class="col-lg-2 control-label">Possui NSCA 3-5?</label>
            <div class="col-lg-10">
                <form:checkbox path="nsca3_5" value="true" id="nsca3_5" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group pull-left">
            <label for="nsca3_7" class="col-lg-2 control-label">Possui NSCA 3-7?</label>
            <div class="col-lg-10">
                <form:checkbox path="nsca3_7" value="true" id="nsca3_7" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group col-md-6">
            <label for="diarioBordo" class="col-lg-2 control-label">Possui Diário de Bordo?</label>
            <div class="col-lg-10">
                <form:checkbox path="diarioBordo" value="true" id="diarioBordo" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group col-md-6">
            <label for="ativo" class="col-lg-2 control-label">Aeronave Ativa?</label>
            <div class="col-lg-10">
                <form:checkbox path="ativo" value="true" id="ativo" cssClass="form-control"/>
            </div>
        </div>

        <div class="row col-md-9">
            <div class="form-group">
                <label for="motivoInatividade" class="col-lg-2 control-label">Motivo da inatividade</label>
                <div class="col-lg-10">
                    <form:input path="motivoInatividade" id="motivoInatividade" cssClass="form-control"/>
                </div>
            </div>
        </div>
    </div>
    <div class="btn-group pull-right">
        <button type="button" class="btn btn-default">Limpar</button>
        <button type="submit" class="btn btn-default">Enviar</button>
    </div>

</form:form>