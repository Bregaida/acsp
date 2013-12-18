<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../../includes/header.jsp"/>

<div ng-controller="InstrutoresController">

    <div ng-init="list()"></div>

    <div class="clearfix">
        <table class="table table-striped table-hover table-condensed datatabled">
            <thead>
                <th>Nome do instrutor</th>
                <th>Nome de Pista</th>
                <th>Código anac</th>
                <th>CPF</th>
                <th>CHT</th>
                <th>CMA</th>
                <th>Ativo</th>
                <th>Qth. Hr/Aula</th>
                <th></th>
            </thead>
            <tbody>
                 <tr ng-repeat="instrutor in instrutores" ng-click="load(instrutor.id)" data-toggle="modal" data-target="#myModal">
                    <td class="hidden">{{instrutor.id}}</td>
                    <td id="instrutorNome{{instrutor.id}}">{{instrutor.nome}}</td>
                    <td>{{instrutor.nomePista}}</td>
                    <td>{{instrutor.codigoANAC}}</td>
                    <td>{{instrutor.cpf}}</td>
                    <td>{{instrutor.cht}}</td>
                    <td>{{instrutor.cma}}</td>
                    <td><i ng-class="style(instrutor.ativo)"></i> </td>
                    <td>{{instrutor.quantidadeHorasMinistrada}}</td>
                    <td>
                        <div class="btn-group btn-custom-block">
                            <span class="icon-edit icon-2x"></span>
                            <span class="icon-remove-circle icon-2x"></span>
                            <span class="icon-plane icon-2x"></span>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Button trigger modal -->
    <a ng-click="novoInstrutor()" id="instrutorModalBtn" data-toggle="modal" data-target="#myModal" href="#myModal" class="btn btn-primary btn-lg">Novo Instrutor</a>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><spring:message code="instrutor.titulo"/></h4>
                </div>
                <form>
                    <div class="modal-body">

                        <input type="hidden" name="id" ng-model="instrutor.id"/>

                        <div class="form-group">
                            <label for="nome"><spring:message code="instrutor.nome"/></label>
                            <input type="text" name="nome" id="nome" ng-model="instrutor.nome" class="form-control"/>
                            <errors path="nome" class="help-block alert-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="rg"><spring:message code="instrutor.rg"/></label>
                            <input type="text" name="rg" id="rg" ng-model="instrutor.rg" class="form-control"/>
                            <errors path="rg" class="help-block alert-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="cpf"><spring:message code="instrutor.cpf"/></label>
                            <input type="text" name="cpf" id="cpf" ng-model="instrutor.cpf" class="form-control cpf" size="14" maxlength="14"/>
                            <errors path="cpf" class="help-block alert-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="alistamentoMilitar"><spring:message code="instrutor.alistamentoMilitar"/></label>
                            <input type="text" ng-model="instrutor.alistamentoMilitar" id="alistamentoMilitar" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="escolaridade"><spring:message code="instrutor.escolaridade"/></label>
                            <select items="${escolaridades}" ng-model="instrutor.escolaridade" id="escolaridade" itemValue="id" itemLabel="descricao" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="tituloEleitor"><spring:message code="instrutor.tituloEleitor"/></label>
                            <input  type="text" ng-model="instrutor.tituloEleitor" id="tituloEleitor" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="codigoANAC"><spring:message code="instrutor.codigoANAC"/></label>
                            <input  type="text" ng-model="instrutor.codigoANAC" id="codigoANAC" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="nomePista"><spring:message code="instrutor.nomePista"/></label>
                            <input  type="text" ng-model="instrutor.nomePista" id="nomePista" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="cht"><spring:message code="instrutor.CHT"/></label>
                            <input  type="text" ng-model="instrutor.cht" id="cht" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="cma"><spring:message code="instrutor.CMA"/></label>
                            <input  type="text" ng-model="instrutor.cma" id="cma" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="quantidadeHorasMinistrada"><spring:message code="instrutor.quantidadeHorasMinistrada"/></label>
                            <input  type="text" ng-model="instrutor.quantidadeHorasMinistrada" id="quantidadeHorasMinistrada" class="form-control"/>
                        </div>

                        <div class="checkbox">
                            <label for="ativo">
                                <checkbox ng-model="instrutor.ativo" id="ativo" />
                                <spring:message code="instrutor.ativo"/>
                            </label>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancel()" data-dismiss="modal">
                                <spring:message code="formulario.botaoFechar"/></button>
                            <button type="reset" class="btn btn-default" ng-click="cancel()" data-dismiss="modal">
                                <spring:message code="formulario.botaoLimpar"/>
                            </button>
                            <button ng-click="save()" data-dismiss="modal" aria-hidden="true" type="button" class="btn btn-primary">
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