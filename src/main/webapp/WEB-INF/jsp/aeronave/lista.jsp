<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../../includes/header.jsp"/>

<div ng-controller="AeronavesController">

    <div class="clearfix">

        <div ng-init="list()"></div>

        <table class="table table-striped table-hover">
            <thead>
                <th class="hidden">Código</th>
                <th><spring:message code="aeronave.certificadoMatricula"/></th>
                <th><spring:message code="aeronave.marca"/></th>
                <th><spring:message code="aeronave.modelo"/></th>
                <th><spring:message code="aeronave.manualVoo"/></th>
                <th><spring:message code="aeronave.checkList"/></th>
                <th><spring:message code="aeronave.diarioBordo"/></th>
                <th><spring:message code="aeronave.ativo"/></th>
                <th></th>
            </thead>
            <tbody>
                <tr ng-repeat="aeronave in aeronaves">
                    <td class="hidden">{{aeronave.id}}</td>
                    <td>{{aeronave.certificadoMatricula}}</td>
                    <td>{{aeronave.marca}}</td>
                    <td>{{aeronave.modelo}}</td>
                    <td><i ng-class="style(aeronave.manualVoo)"></i></td>
                    <td><i ng-class="style(aeronave.checkList)"></i></td>
                    <td><i ng-class="style(aeronave.diarioBordo)"></i></td>
                    <td><i ng-class="style(aeronave.ativo)"></i></td>
                    <td>
                        <div class="btn-group btn-custom-block">
                            <span data-toggle="modal" data-target="#myModal" data-toggle="modal" ng-click="load(aeronave.id)" class="glyphicon glyphicon-edit btn-lg"></span>
                            <span ng-click="disable(aeronave.id)" class="glyphicon glyphicon-remove-circle btn-lg"></span>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Button trigger modal -->
    <a ng-click="novaAeronave()" data-toggle="modal" data-target="#myModal" class="btn btn-primary btn-lg">Nova Aeronave</a>

    <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <h4 class="modal-title"><spring:message code="aeronave.titulo"/></h4>
                    </div>

                    <div class="modal-body">
                        <form name="aeronaveForm" >
                            <input type="hidden" name="id" ng-model="aeronave.id"/>

                            <div class="form-group">
                                <label for="certificadoMatricula"><spring:message code="aeronave.certificadoMatricula"/></label>
                                <input type="text" name="certificadoMatricula" id="certificadoMatricula" class="form-control" ng-model="aeronave.certificadoMatricula"/>
                            </div>

                            <div class="form-group">
                                <label for="marca"><spring:message code="aeronave.marca"/></label>
                                <input type="text" name="marca" id="marca" class="form-control" ng-model="aeronave.marca"/>
                            </div>

                            <div class="form-group">
                                <label for="modelo"><spring:message code="aeronave.modelo"/></label>
                                <input type="text" name="modelo" id="modelo" class="form-control" ng-model="aeronave.modelo"/>
                            </div>

                            <div class="form-group">
                                <label for="dentel"><spring:message code="aeronave.dentel"/></label>
                                <input type="text" name="dentel" id="dentel" class="form-control" ng-model="aeronave.dentel"/>
                            </div>

                            <div class="form-group">
                                <label for="fiam"><spring:message code="aeronave.fiam"/></label>
                                <input type="text" name="fiam" id="fiam" class="form-control" ng-model="aeronave.fiam"/>
                            </div>

                            <div class="form-group">
                                <label for="apoliceSeguro"><spring:message code="aeronave.apoliceSeguro"/></label>
                                <input type="text" type="text" name="apoliceSeguro" id="apoliceSeguro" class="form-control" ng-model="aeronave.apoliceSeguro"/>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="fichaPesoBalanceamento" value="true" id="fichaPesoBalanceamento" ng-model="aeronave.fichaPesoBalanceamento"/>
                                    <spring:message code="aeronave.fichaPesoBalanceamento"/>
                                </label>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="manualVoo" value="true" id="manualVoo" ng-model="aeronave.manualVoo"/>
                                    <spring:message code="aeronave.manualVoo"/>
                                </label>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="checkList" value="true" id="checkList" ng-model="aeronave.checkList" />
                                    <spring:message code="aeronave.checkList"/>
                                </label>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="nsca3_5" value="true" id="nsca3_5" ng-model="aeronave.nsca3_5"/>
                                    <spring:message code="aeronave.nsca3_5"/>
                                </label>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="nsca3_7" value="true" id="nsca3_7" ng-model="aeronave.nsca3_7"/>
                                    <spring:message code="aeronave.nsca3_7"/>
                                </label>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="diarioBordo" value="true" id="diarioBordo" ng-model="aeronave.diarioBordo"/>
                                    <spring:message code="aeronave.diarioBordo"/>
                                </label>
                            </div>

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="ativo" value="true" id="ativo" ng-model="aeronave.ativo"/>
                                    <spring:message code="aeronave.ativo"/>
                                </label>
                            </div>

                            <div class="form-group">
                                <label for="motivoInatividade"><spring:message code="aeronave.motivoInatividade"/></label>
                                <input type="text" name="motivoInatividade" id="motivoInatividade" class="form-control" ng-model="aeronave.motivoInatividade"/>
                            </div>
                        </form>
                    </div>

                    <div class="modal-footer">
                        <div class="btn-group pull-right">
                            <button class="btn btn-default" ng-click="cancel()" data-dismiss="modal">
                                <spring:message code="formulario.botaoFechar"/>
                            </button>
                            <button type="reset" class="btn btn-default" ng-click="cancel()" data-dismiss="modal">
                                <spring:message code="formulario.botaoLimpar"/>
                            </button>
                            <button ng-click="add()" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">
                                <spring:message code="formulario.botaoSalvar"/>
                            </button>
                        </div>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

</div>

<jsp:include page="../../includes/footer.jsp"/>