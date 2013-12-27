<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../../includes/header.jsp"/>

<div ng-controller="AtendentesController">

    <div ng-init="list()"></div>

    <div class="clearfix">
        <table class="table table-striped table-hover datatabled">
            <thead>
                <th>Nome do Atendente</th>
                <th>CPF</th>
                <th>Ativo</th>
                <th></th>
            </thead>
            <tbody>
                <tr ng-repeat="atendente in atendentes" ng-click="load(atendente.id)" data-toggle="modal" data-target="#myModal">
                    <td>{{atendente.nome}}</td>
                    <td>{{atendente.cpf}}</td>
                    <td><i ng-class="style(atendente.ativo)"></i></td>
                    <td>
                        <div class="btn-group btn-custom-block">
                            <span class="icon-edit icon-2x editaAction"></span>
                            <span class="icon-remove-circle icon-2x apagaAction"></span>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Button trigger modal -->
    <a ng-click="novoAtendente()" id="atendenteModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Atendente</a>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><spring:message code="atendente.titulo"/></h4>
                </div>

                <form name="atendente_form">
                    <div class="modal-body">

                        <div class="validation_error">
                            <div class="alert alert-danger" ng-repeat="error in validation.data.fieldErrors">
                                {{error.message}}
                            </div>
                            <br/>
                        </div>

                        <input type="hidden" ng-model="atendente.id" />

                        <div class="form-group">
                            <label><spring:message code="atendente.nome"/></label>
                            <input id="nome" ng-model="atendente.nome" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label><spring:message code="atendente.rg"/></label>
                            <input id="rg" ng-model="atendente.rg" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label><spring:message code="atendente.cpf"/></label>
                            <input id="cpf" ng-model="atendente.cpf" class="form-control cpf" size="14" maxlength="14"/>
                        </div>

                        <div class="form-group">
                            <label><spring:message code="atendente.alistamentoMilitar"/></label>
                            <input id="alistamento" ng-model="atendente.alistamentoMilitar" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label><spring:message code="atendente.escolaridade"/></label>
                            <select items="${escolaridades}" ng-model="atendente.escolaridade" itemValue="id" itemLabel="descricao" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label><spring:message code="atendente.tituloEleitor"/></label>
                            <input id="tituloeleitor" ng-model="atendente.tituloEleitor" class="form-control"/>
                        </div>

                        <div class="checkbox">
                            <label for="ativo">
                                <checkbox id="status" ng-model="atendente.ativo" id="ativo"/>
                                <spring:message code="atendente.ativo"/>
                            </label>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancel()">
                                <spring:message code="formulario.botaoFechar"/>
                            </button>
                            <button type="reset" class="btn btn-default" ng-click="novoAtendente()">
                                <spring:message code="formulario.botaoLimpar"/>
                            </button>
                            <button type="button" class="btn btn-primary" ng-click="save()">
                                <spring:message code="formulario.botaoSalvar"/>
                            </button>

                        </div>
                    </div>
                </form>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

</div>

<jsp:include page="../../includes/footer.jsp"/>