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
        <div ng-init="loadAeronaves()"></div>
        <div ng-init="loadAulas()"></div>
        <div ng-init="loadInstrutores()"></div>
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
                        <div ng-hide="agendamento.aluno.nome">
                            <input type="text" ng-model="agendamento.aluno" placeholder="Digite o nome"
                                   typeahead-editable="false"
                                   typeahead="aluno as aluno.label for aluno in getAlunos($viewValue) | filter:{nome: $viewValue}"
                                   typeahead-loading="loadingLocations" id="aluno" class="form-control" typeahead-min-length="3" typeahead-wait-ms="500">
                            <i ng-show="loadingLocations" class="glyphicon glyphicon-refresh"></i>
                        </div>
                        <div ng-show="agendamento.aluno.nome">
                            {{agendamento.aluno.label}}
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="aula"><spring:message code="agenda.aula"/></label>
                        <select ng-model="agendamento.aula" id="aula" class="form-control">
                            <option value="" label="--- Selecione ---" />
                            <option ng-selected="{{aulaSelecionada(i.id)}}"
                                    ng-repeat="i in aulas"
                                    value="{{i.id}}">
                                {{i.materia}}
                            </option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="aeronave"><spring:message code="agenda.aeronave"/></label>
                        <select id="aeronave" ng-model="agendamento.aeronave" class="form-control">
                            <option value="" label="--- Selecione ---" />
                            <option ng-selected="{{aeronaveSelecionada(i.id)}}"
                                    ng-repeat="i in aeronaves"
                                    value="{{i.id}}">
                                {{i.label}}
                            </option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="horario"><spring:message code="agenda.horario"/></label>
                        <select ng-model="agendamento.horario.id" id="horario" class="form-control" />
                    </div>

                    <div class="form-group">
                        <label for="qtdeHoras"><spring:message code="agenda.qtdeHoras"/></label>
                        <input ng-model="agendamento.qtdeHoras" id="qtdeHoras" cssClass="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="instrutor"><spring:message code="agenda.instrutor"/></label>
                        <select ng-model="agendamento.instrutor.id" id="instrutor" class="form-control">
                            <option value="" label="--- Selecione ---" />
                            <option ng-selected="{{instrutorSelecionado(i.id)}}"
                                    ng-repeat="i in instrutores"
                                    value="{{i.id}}">
                                {{i.nome}}
                            </option>
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