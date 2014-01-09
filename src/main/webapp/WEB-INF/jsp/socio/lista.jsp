<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../../includes/header.jsp"/>

<div ng-controller="GenericController">

    <div ng-init="setEntitiesType('socios')"></div>
    <div ng-init="setEntityType('socio')"></div>

    <div ng-init="list()"></div>

    <div class="clearfix">
        <table class="table table-striped table-hover datatabled">
            <thead>
            <th>Nome do sócio</th>
            <th>Número de Inscrição</th>
            <th>Código anac</th>
            <th>CPF</th>
            <th>Nome de Pista</th>
            <th>CHT</th>
            <th>CMA</th>
            <th>Ativo</th>
            </thead>
            <tbody>
                <tr ng-repeat="socio in entities" ng-click="load(socio.id)" data-toggle="modal" data-target="#myModal">
                    <td>{{socio.nome}}</td>
                    <td>{{socio.numeroInscricao}}</td>
                    <td>{{socio.codigoANAC}}</td>
                    <td>{{socio.cpf}}</td>
                    <td>{{socio.nomePista}}</td>
                    <td>{{socio.cht}}</td>
                    <td>{{socio.cma}}</td>
                    <td>
                        <i ng-class="style(socio.ativo)"></i>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Button trigger modal -->
    <a ng-click="newEntity()" id="socioModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Socio</a>

    <script type="text/ng-template" id="myModalContent.html">
        <div class="modal-dialog" ng-controller="GenericController">
            <div ng-init="setEntitiesType('socios')"></div>
            <div ng-init="setEntityType('socio')"></div>
            <div ng-init="loadEducationLevels()"></div>
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title"><spring:message code="socio.titulo"/></h4>
                    </div>
                    <form>
                        <div class="modal-body">
                            <div class="validation_error">
                                <div class="alert alert-danger" ng-repeat="error in validation.fieldErrors">
                                    {{error.message}}
                                </div>
                                <br/>
                            </div>
                            <input type="hidden" id="id" ng-model="entity.id"/>

                            <div class="form-group">
                                <label for="numeroInscricao"><spring:message code="socio.numeroInscricao"/></label>
                                <input ng-model="entity.numeroInscricao" id="numeroInscricao" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="nome"><spring:message code="socio.nome"/></label>
                                <input ng-model="entity.nome" id="nome" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="rg"><spring:message code="socio.rg"/></label>
                                <input ng-model="entity.rg" id="rg" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="cpf"><spring:message code="socio.cpf"/></label>
                                <input ng-model="entity.cpf" id="cpf" class="form-control cpf" size="14" maxlength="14"/>
                            </div>

                            <div class="form-group">
                                <label for="alistamentoMilitar"><spring:message code="socio.alistamentoMilitar"/></label>
                                <input ng-model="entity.alistamentoMilitar" id="alistamentoMilitar" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="escolaridade"><spring:message code="socio.escolaridade"/></label>
                                <select ng-model="entity.escolaridade" id="escolaridade" class="form-control" ng-options="k as v for (k,v) in educationLevels"/>
                            </div>

                            <div class="form-group">
                                <label for="tituloEleitor"><spring:message code="socio.tituloEleitor"/></label>
                                <input ng-model="entity.tituloEleitor" id="tituloEleitor" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="codigoANAC"><spring:message code="socio.codigoANAC"/></label>
                                <input ng-model="entity.codigoANAC" id="codigoANAC" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="nomePista"><spring:message code="socio.nomePista"/></label>
                                <input ng-model="entity.nomePista" id="nomePista" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="cht"><spring:message code="socio.CHT"/></label>
                                <input ng-model="entity.cht" id="cht" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="cma"><spring:message code="socio.CMA"/></label>
                                <input ng-model="entity.cma" id="cma" class="form-control"/>
                            </div>

                            <div class="checkbox">
                                <label for="ativo">
                                    <checkbox ng-model="entity.ativo" id="ativo" ng-model="socio.ativo"/>
                                    <spring:message code="socio.ativo"/>
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

    </div>
    <jsp:include page="../../includes/footer.jsp"/>

</div>