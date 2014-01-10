<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../includes/header.jsp"/>

<div class="row" ng-controller="AgendamentosController">

    <div class="col-md-8">
        <div ui-calendar="uiConfig.calendar" class="span8 calendar" ng-model="eventSources"></div>
    </div>
    <div class="col-xs-6 col-md-4">
        <h5>Aeronaves disponíveis - hoje</h5>
        <table class="table">
            <thead>
                <td>Aeronave</td>
                <td>Horários</td>
            </thead>
            <tr>
                <td>PT-IZQ - Cherokee</td>
                <td>09-11, 11-12, 13-14, 16-17</td>
            </tr>
            <tr>
                <td>PR-MRG - A330</td>
                <td>13-14, 16-17</td>
            </tr>
        </table>
        <hr/>
        <h5>Instrutores disponíveis - hoje</h5>
        <table class="table">
            <thead>
            <td>Instrutor</td>
            <td>Horários</td>
            </thead>
            <tr>
                <td>Santos Dumont</td>
                <td>09-11, 11-12, 13-14, 16-17</td>
            </tr>
            <tr>
                <td>Barão Vermelho</td>
                <td>13-14, 16-17</td>
            </tr>
        </table>
    </div>
</div>

<script type="text/ng-template" id="myModalContent.html">
    <div class="modal-dialog" ng-controller="AgendamentosController">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title"><spring:message code="agendamento.titulo"/></h4>
            </div>
            <form>
                <div class="modal-body">
                    <div class="validation_error">
                        <div class="alert alert-danger" ng-repeat="error in validation.fieldErrors">
                            {{error.message}}
                        </div>
                        <br/>
                    </div>
                    <input type="hidden" name="id"/>

                    <div class="form-group">
                        <label><spring:message code="agenda.dataReserva"/></label>
                        {{agendamento.dataReserva}} @ {{agendamento.horario.horarioAgenda}}
                    </div>

                    <div class="form-group">
                        <label for="aluno"><spring:message code="agenda.aluno"/></label>
                        <select ng-model="agendamento.aluno.id" id="aluno" cssClass="form-control">
                            <option value="" label="--- Selecione ---" />
                            <options items="${listaDeAlunos}" itemValue="id" itemLabel="nome" />
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="aeronave"><spring:message code="agenda.aeronave"/></label>
                        <select id="aeronave" ng-model="agendamento.aeronaveId" ng-model="agendamento.aeronave.id" cssClass="form-control">
                            <option value="" label="--- Selecione ---"/>
                            <options items="${listaDeAeronaves}" itemValue="id"/>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="horario"><spring:message code="agenda.horario"/></label>
                        <select ng-model="agendamento.horario.id" id="horario" items="${listaDeHorarios}" itemValue="id" itemLabel="horarioAgenda" cssClass="form-control" />
                    </div>

                    <div class="form-group">
                        <label for="qtdeHoras"><spring:message code="agenda.qtdeHoras"/></label>
                        <input ng-model="agendamento.qtdeHoras" id="qtdeHoras" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="aula"><spring:message code="agenda.aula"/></label>
                        <select multiple="multiple" ng-model="agendamento.aula.id" id="agendamento.aula.id" class="form-control">
                            <option ng-selected="{{estaSelecionado(i.id)}}"
                                    ng-repeat="i in aulas"
                                    value="{{i.id}}">
                                {{i.displayName}}
                            </option>
                        </select>
                        <select ng-model="agendamento.aula.id" id="aula" cssClass="form-control">
                            <option value="" label="--- Selecione ---" />
                            <options items="${listaDeAulas}" itemValue="id" itemLabel="materia"/>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="instrutor"><spring:message code="agenda.instrutor"/></label>
                        <select ng-model="agendamento.instrutor.id" id="instrutor" cssClass="form-control">
                            <option value="" label="--- Selecione ---" />
                            <options items="${listaDeInstrutores}" itemValue="id" itemLabel="nome"/>
                        </select>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" ng-model="agendamento.flag360milhas" value="true"/>
                            <spring:message code="agenda.360Milhas"/>
                        </label>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="btn-group pull-right">
                        <button class="btn btn-default" ng-click="cancel()" data-dismiss="modal">
                            <spring:message code="formulario.botaoFechar"/>
                        </button>
                        <button ng-click="saveAndClose(entity)" class="btn btn-primary" aria-hidden="true">
                            <spring:message code="formulario.botaoSalvar"/>
                        </button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</script>

<jsp:include page="../includes/footer.jsp"/>