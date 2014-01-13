<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="../../includes/header.jsp"/>

<div ng-controller="GenericController">

    <div ng-init="setEntitiesType('instrutores')"></div>
    <div ng-init="setEntityType('instrutor')"></div>
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
            </thead>
            <tbody>
            <tr ng-repeat="instrutor in entities" ng-click="load(instrutor.id)" data-toggle="modal"
                data-target="#myModal">
                <td class="hidden">{{instrutor.id}}</td>
                <td id="instrutorNome{{instrutor.id}}">{{instrutor.nome}}</td>
                <td>{{instrutor.nomePista}}</td>
                <td>{{instrutor.codigoANAC}}</td>
                <td>{{instrutor.cpf}}</td>
                <td>{{instrutor.cht}}</td>
                <td>{{instrutor.cma}}</td>
                <td>
                    <i ng-class="style(instrutor.ativo)"></i>
                </td>
                <td>{{instrutor.quantidadeHorasMinistrada}}</td>
            </tr>
            </tbody>
        </table>
    </div>

    <!-- Button trigger modal -->
    <a ng-click="newEntity()" id="instrutorModalBtn" data-toggle="modal" data-target="#myModal" href="#myModal"
       class="btn btn-primary btn-lg">Novo Instrutor</a>

    <!-- Modal -->
    <script type="text/ng-template" id="myModalContent.html">
        <div class="modal-dialog" ng-controller="GenericController">
            <div ng-init="setEntitiesType('instrutores')"></div>
            <div ng-init="setEntityType('instrutor')"></div>
            <div ng-init="loadEducationLevels()"></div>

            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><spring:message code="instrutor.titulo"/></h4>
                </div>
                <form>
                    <div class="modal-body">
                        <div class="validation_error">
                            <div class="alert alert-danger" ng-repeat="error in validation.fieldErrors">
                                {{error.message}}
                            </div>
                            <br/>
                        </div>
                        <input type="hidden" name="id" ng-model="entity.id"/>

                        <div class="form-group">
                            <label for="nome"><spring:message code="instrutor.nome"/></label>
                            <input type="text" name="nome" id="nome" ng-model="entity.nome" class="form-control"/>
                            <errors path="nome" class="help-block alert-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="rg"><spring:message code="instrutor.rg"/></label>
                            <input type="text" name="rg" id="rg" ng-model="entity.rg" class="form-control"/>
                            <errors path="rg" class="help-block alert-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="cpf"><spring:message code="instrutor.cpf"/></label>
                            <input type="text" name="cpf" id="cpf" ng-model="entity.cpf" class="form-control cpf"
                                   size="14" maxlength="14"/>
                            <errors path="cpf" class="help-block alert-danger"/>
                        </div>

                        <div class="form-group">
                            <label for="alistamentoMilitar"><spring:message
                                    code="instrutor.alistamentoMilitar"/></label>
                            <input type="text" ng-model="entity.alistamentoMilitar" id="alistamentoMilitar"
                                   class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="escolaridade"><spring:message code="instrutor.escolaridade"/></label>
                            <select ng-model="entity.escolaridade" id="escolaridade" class="form-control"
                                    ng-options="k as v for (k,v) in educationLevels"/>
                        </div>

                        <div class="form-group">
                            <label for="tituloEleitor"><spring:message code="instrutor.tituloEleitor"/></label>
                            <input type="text" ng-model="entity.tituloEleitor" id="tituloEleitor" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="codigoANAC"><spring:message code="instrutor.codigoANAC"/></label>
                            <input type="text" ng-model="entity.codigoANAC" id="codigoANAC" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="nomePista"><spring:message code="instrutor.nomePista"/></label>
                            <input type="text" ng-model="entity.nomePista" id="nomePista" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="cht"><spring:message code="instrutor.CHT"/></label>
                            <input type="text" ng-model="entity.cht" id="cht" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="cma"><spring:message code="instrutor.CMA"/></label>
                            <input type="text" ng-model="entity.cma" id="cma" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="quantidadeHorasMinistrada"><spring:message
                                    code="instrutor.quantidadeHorasMinistrada"/></label>
                            <input type="text" ng-model="entity.quantidadeHorasMinistrada"
                                   id="quantidadeHorasMinistrada" class="form-control"/>
                        </div>

                        <div class="checkbox">
                            <label for="ativo">
                                <input type="checkbox" ng-model="entity.ativo" id="ativo" value="true"/>
                                <spring:message code="instrutor.ativo"/>
                            </label>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancel()"
                                    data-dismiss="modal">
                                <spring:message code="formulario.botaoFechar"/>
                            </button>
                            <button ng-click="saveAndClose(entity)" aria-hidden="true" type="button"
                                    class="btn btn-primary">
                                <spring:message code="formulario.botaoSalvar"/>
                            </button>
                        </div>
                    </div>
                </form>

            </div>
            <!-- /.modal-content -->
        </div>
    </script>

</div>

<jsp:include page="../../includes/footer.jsp"/>