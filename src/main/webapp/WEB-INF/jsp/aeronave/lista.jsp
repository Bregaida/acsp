<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../../includes/header.jsp"/>

<div ng-controller="GenericController">

    <div ng-init="setEntitiesType('aeronaves')"></div>
    <div ng-init="setEntityType('aeronave')"></div>

    <div class="clearfix" >

        <div ng-init="list()"></div>

        <table class="table table-striped table-hover">
            <thead>
                <th class="hidden">Código</th>
                <th><spring:message code="aeronave.certificadoMatricula"/></th>
                <th><spring:message code="aeronave.valorHora"/></th>
                <th><spring:message code="aeronave.marca"/></th>
                <th><spring:message code="aeronave.modelo"/></th>
                <th><spring:message code="aeronave.manualVoo"/></th>
                <th><spring:message code="aeronave.checkList"/></th>
                <th><spring:message code="aeronave.diarioBordo"/></th>
                <th><spring:message code="aeronave.ativo"/></th>
            </thead>
            <tbody>
                <tr ng-repeat="aeronave in entities" ng-click="load(aeronave.id)" data-toggle="modal" data-target="#myModal">
                    <td class="hidden">{{aeronave.id}}</td>
                    <td>{{aeronave.certificadoMatricula}}</td>
                	<td>{{aeronave.valorHora}}</td>
                    <td>{{aeronave.marca}}</td>
                    <td>{{aeronave.modelo}}</td>
                    <td><i ng-class="style(aeronave.manualVoo)"></i></td>
                    <td><i ng-class="style(aeronave.checkList)"></i></td>
                    <td><i ng-class="style(aeronave.diarioBordo)"></i></td>
                    <td><i ng-class="style(aeronave.ativo)"></i></td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Button trigger modal -->
    <a ng-click="newEntity()" data-toggle="modal" data-target="#myModal" class="btn btn-primary btn-lg">Nova Aeronave</a>

    <script type="text/ng-template" id="myModalContent.html">
        <div class="modal-dialog" ng-controller="GenericController">
            <div ng-init="setEntitiesType('aeronaves')"></div>
            <div ng-init="setEntityType('aeronave')"></div>

            <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title"><spring:message code="aeronave.titulo"/></h4>
                    </div>

                    <div class="modal-body">
                        <div class="validation_error">
                            <div class="alert alert-danger" ng-repeat="error in validation.data.fieldErrors">
                                {{error.message}}
                            </div>
                            <br/>
                        </div>
                        <form name="aeronaveForm" >
                            <input type="hidden" name="id" ng-model="entity.id"/>

                            <div class="form-group">
                                <label for="certificadoMatricula"><spring:message code="aeronave.certificadoMatricula"/></label>
                                <input type="text" name="certificadoMatricula" id="certificadoMatricula" class="form-control" ng-model="entity.certificadoMatricula"/>
                            </div>
							
							 <div class="form-group">
                                <label for="valorHora"><spring:message code="aeronave.valorHora"/></label>
                                <input type="text" name="valorHora" id="valorHora" class="form-control" ng-model="entity.valorHora"/>
                            </div>

                            <div class="form-group">
                                <label for="marca"><spring:message code="aeronave.marca"/></label>
                                <input type="text" name="marca" id="marca" class="form-control" ng-model="entity.marca"/>
                            </div>

                            <div class="form-group">
                                <label for="modelo"><spring:message code="aeronave.modelo"/></label>
                                <input type="text" name="modelo" id="modelo" class="form-control" ng-model="entity.modelo"/>
                            </div>

                            <div class="form-group">
                                <label for="dentel"><spring:message code="aeronave.dentel"/></label>
                                <input type="text" name="dentel" id="dentel" class="form-control" ng-model="entity.dentel"/>
                            </div>

                            <div class="form-group">
                                <label for="fiam"><spring:message code="aeronave.fiam"/></label>
                                <input type="text" name="fiam" id="fiam" class="form-control" ng-model="entity.fiam"/>
                            </div>

                            <div class="form-group">
                                <label for="apoliceSeguro"><spring:message code="aeronave.apoliceSeguro"/></label>
                                <input type="text" type="text" name="apoliceSeguro" id="apoliceSeguro" class="form-control" ng-model="entity.apoliceSeguro"/>
                            </div>

                            <div class="checkbox">
                                <label for="fichaPesoBalanceamento"><spring:message code="aeronave.fichaPesoBalanceamento"/></label>
                                <input type="checkbox" name="fichaPesoBalanceamento" value="true" id="fichaPesoBalanceamento" ng-model="entity.fichaPesoBalanceamento"/>
                            </div>

                            <div class="checkbox">
                                <label for="manualVoo"><spring:message code="aeronave.manualVoo"/></label>
                                    <input type="checkbox" name="manualVoo" value="true" id="manualVoo" ng-model="entity.manualVoo"/>
                            </div>

                            <div class="checkbox">
                                <label for="checkList"><spring:message code="aeronave.checkList"/></label>
                                <input type="checkbox" name="checkList" value="true" id="checkList" ng-model="entity.checkList" />
                            </div>

                            <div class="checkbox">
                                <label for="nsca3_5"><spring:message code="aeronave.nsca3_5"/></label>
                                <input type="checkbox" name="nsca3_5" value="true" id="nsca3_5" ng-model="entity.nsca3_5"/>
                            </div>

                            <div class="checkbox">
                                <label for="nsca3_7"><spring:message code="aeronave.nsca3_7"/></label>
                                <input type="checkbox" name="nsca3_7" value="true" id="nsca3_7" ng-model="entity.nsca3_7"/>
                            </div>

                            <div class="checkbox">
                                <label for="diarioBordo"><spring:message code="aeronave.diarioBordo"/></label>
                                <input type="checkbox" name="diarioBordo" value="true" id="diarioBordo" ng-model="entity.diarioBordo"/>
                            </div>

                            <div class="checkbox">
                                <label for="ativo"><spring:message code="aeronave.ativo"/></label>
                                <input type="checkbox" name="ativo" value="true" id="ativo" ng-model="entity.ativo"/>
                            </div>

                            <div class="form-group">
                                <label for="motivoInatividade"><spring:message code="aeronave.motivoInatividade"/></label>
                                <input type="text" name="motivoInatividade" id="motivoInatividade" class="form-control" ng-model="entity.motivoInatividade"/>
                            </div>
                        </form>
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
                </div>
        </div>
    </script>
</div>

<jsp:include page="../../includes/footer.jsp"/>